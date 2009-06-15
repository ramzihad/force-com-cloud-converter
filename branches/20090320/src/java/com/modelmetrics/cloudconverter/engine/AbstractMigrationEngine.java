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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.forceutil.CreateExecutor;
import com.modelmetrics.cloudconverter.forceutil.CustomFieldBuilder;
import com.modelmetrics.cloudconverter.forceutil.CustomTabBuilder;
import com.modelmetrics.cloudconverter.forceutil.LayoutBuilder;
import com.modelmetrics.cloudconverter.forceutil.MetadataReadinessChecker;
import com.modelmetrics.cloudconverter.forceutil.UpdateExecutor;
import com.modelmetrics.cloudconverter.util.OperationStatusSubscriber;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.CustomTab;
import com.sforce.soap._2006._04.metadata.Layout;

public abstract class AbstractMigrationEngine extends
		AbstractMigrationContextAware implements MigrationEngineIF,
		MigrationStatusPublisher {

	protected static final Log log = LogFactory
			.getLog(AbstractMigrationEngine.class);

	public List<OperationStatusSubscriber> subscribers = new ArrayList<OperationStatusSubscriber>();

	public void subscribeToStatus(
			OperationStatusSubscriber migrationStatusSubscriber) {
		subscribers.add(migrationStatusSubscriber);
	}

	public void publishStatus(String status) {
		for (Iterator<OperationStatusSubscriber> iterator = subscribers
				.iterator(); iterator.hasNext();) {
			OperationStatusSubscriber type = iterator.next();
			if (type != null)
				type.publish(status);

		}
	}

	public void executeCommon(CustomObject co) throws Exception {

		this.getMigrationContext().setCustomObject(co);

		this.publishStatus("creating new object");

		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService(), new CustomObject[] { co }).execute();

		/*
		 * create custom fields 2009-03-21 RSC This has the migration context so
		 * it is now aware of the metadata proxy collection
		 */
		CustomField[] fields = new CustomFieldBuilder().build(this
				.getMigrationContext());

		this.publishStatus("creating new fields");

		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService(), fields).execute();

		// reseting the session
		this.pauseSession();

		// moving to the lookups
		if (this.getMigrationContext().getCustomLookupFields() != null
				&& this.getMigrationContext().getCustomLookupFields().length > 0) {

			this.publishStatus("creating new lookup fields");

			new CreateExecutor(this.getMigrationContext()
					.getSalesforceSession().getMetadataService(), this
					.getMigrationContext().getCustomLookupFields()).execute();
		}

		/*
		 * Custom Tab
		 */

		this.pauseSession();
		this.publishStatus("creating custom tab");

		CustomTab customTab = new CustomTabBuilder().build(co);
		log.debug("CustomTab - local definition complete - "
				+ customTab.getFullName());

		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService(), new CustomTab[] { customTab }).execute();

		/*
		 * check to see if we're ready to proceed.
		 */
		 
		MetadataReadinessChecker checker = new MetadataReadinessChecker();

		boolean ready = false;

		for (int i = 0; i < 5; i++) {
			ready = checker.isMetadataReady(this.getMigrationContext());
			log.debug("is metadata ready? " + ready);
			if (ready) 
				break;
			this.pauseSession();
		}

		

		/*
		 * update the layout
		 */

		this.pauseSession();
		this.publishStatus("updating default layout");

		LayoutBuilder layoutBuilder = new LayoutBuilder();
		layoutBuilder.setMigrationContext(this.getMigrationContext());
		Layout layout = layoutBuilder.build();

		this.pauseSession();
		this.pauseSession();
		new UpdateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService()).executeSimpleUpdate(layout);

		this.pauseSession();

		/*
		 * update profile permissions
		 */
		// Profile profile = new ProfileTabVisibilityBuilder().build("Admin",
		// customTab.getFullName());
		// new UpdateExecutor(this.getMigrationContext().getSalesforceSession()
		// .getMetadataService()).executeSimpleUpdate(profile);
		//		
		// this.pauseSession();
	}

	/**
	 * sleeps for 10 seconds -- useful when executing a lot of tasks dependent
	 * upon other preceding tasks. (2009-03-28 RSC)
	 * 
	 * @throws Exception
	 */
	public void pauseSession() throws Exception {

		// log.info("in reset session...");
		//		
		// SalesforceSession newSession =
		// SalesforceSessionFactory.factory.build(this.getSalesforceCredentials());
		//		
		// this.setSalesforceSession(newSession);
		//		
		// log.info("reset session complete...");

		this.publishStatus("resting");
		log.debug("waiting for 10 seconds (instead of resetting session)...");
		Thread.sleep(10000);

	}


}
