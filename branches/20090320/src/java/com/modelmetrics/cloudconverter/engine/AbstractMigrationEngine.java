/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package com.modelmetrics.cloudconverter.engine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.forceutil.CreateExecutor;
import com.modelmetrics.cloudconverter.forceutil.CustomFieldBuilder;
import com.modelmetrics.cloudconverter.forceutil.CustomTabBuilder;
import com.modelmetrics.cloudconverter.forceutil.LayoutBuilder;
import com.modelmetrics.cloudconverter.forceutil.ProfileTabVisibilityBuilder;
import com.modelmetrics.cloudconverter.forceutil.UpdateExecutor;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.CustomTab;
import com.sforce.soap._2006._04.metadata.Layout;
import com.sforce.soap._2006._04.metadata.Profile;

public abstract class AbstractMigrationEngine extends
		AbstractMigrationContextAware implements MigrationEngineIF {

	protected static final Log log = LogFactory
			.getLog(AbstractMigrationEngine.class);

	public void executeCommon(CustomObject co) throws Exception {

		this.getMigrationContext().setCustomObject(co);

		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService(), new CustomObject[] { co }).execute();

		/*
		 * create custom fields 2009-03-21 RSC This has the migration context so
		 * it is now aware of the metadata proxy collection
		 */
		CustomField[] fields = new CustomFieldBuilder().build(this
				.getMigrationContext());

		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService(), fields).execute();

		// reseting the session
		this.pauseSession();

		// moving to the lookups
		if (this.getMigrationContext().getCustomLookupFields() != null
				&& this.getMigrationContext().getCustomLookupFields().length > 0) {
			new CreateExecutor(this.getMigrationContext()
					.getSalesforceSession().getMetadataService(), this
					.getMigrationContext().getCustomLookupFields()).execute();
		}

		/*
		 * Custom Tab
		 */
		CustomTab customTab = new CustomTabBuilder().build(co);
		log.debug("CustomTab - local definition complete - "
				+ customTab.getFullName());

		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService(), new CustomTab[] { customTab }).execute();

		/*
		 * update the layout
		 */
		LayoutBuilder layoutBuilder = new LayoutBuilder();
		layoutBuilder.setMigrationContext(this.getMigrationContext());
		Layout layout = layoutBuilder.build();

		new UpdateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService()).executeSimpleUpdate(layout);

		this.pauseSession();

		/*
		 * update profile permissions
		 */
//		Profile profile = new ProfileTabVisibilityBuilder().build("Admin",
//				customTab.getFullName());
//		new UpdateExecutor(this.getMigrationContext().getSalesforceSession()
//				.getMetadataService()).executeSimpleUpdate(profile);
//		
//		this.pauseSession();

	}
	
	/**
	 * sleeps for 10 seconds -- useful when executing a lot of tasks dependent upon other preceding tasks.
	 * (2009-03-28 RSC)
	 * 
	 * @throws Exception
	 */
	public void pauseSession() throws Exception {
		
//		log.info("in reset session...");
//		
//		SalesforceSession newSession = SalesforceSessionFactory.factory.build(this.getSalesforceCredentials());
//		
//		this.setSalesforceSession(newSession);
//		
//		log.info("reset session complete...");
		
		log.debug("waiting for 10 seconds (instead of resetting session)...");
		Thread.sleep(10000);
		
	}

}
