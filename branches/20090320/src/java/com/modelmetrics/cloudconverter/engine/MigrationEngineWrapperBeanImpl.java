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

import java.util.List;

import com.modelmetrics.cloudconverter.forceutil.CustomObjectBuilder;
import com.modelmetrics.cloudconverter.forceutil.DataInsertExecutor;
import com.modelmetrics.cloudconverter.forceutil.DataUpsertExecutor;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.modelmetrics.cloudconverter.util.MetadataProxyCollectionBuilder;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.temp.ExcelWorksheetWrapperBean;

/**
 * @deprecated s
 * @author reidcarlberg
 *
 */
public class MigrationEngineWrapperBeanImpl extends AbstractMigrationEngine
		implements MigrationEngineIF {

	
	public void execute() throws Exception {
		this.createCustomObject();
	}


	private void createCustomObject() throws Exception {

		this.publishStatus("Beginning migration");
		
		ExcelWorksheetWrapperBean bean = this.getMigrationContext().getWrapperBean();
		
		/*
		 * 2009-03-21 RSC Convert that over to a MetadataProxy
		 */
		List<MetadataProxy> metadataProxies = new MetadataProxyCollectionBuilder()
				.build(bean);

		this.getMigrationContext().setMetadataProxies(metadataProxies);

		// check if it needs overriding	
//		this.cleanUpOrg(bean.getSheetName()+"__c", bean.getSheetName(), bean.getOverride().booleanValue());

		/*
		 * 2009-03-21 RSC //TODO rs should probably be a little more generic as
		 * well but not changing for right now.
		 */

		/*
		 * build the basic custom object
		 */
		CustomObject co = new CustomObjectBuilder().build(bean);

		this.executeCommon(co);

		/*
		 * Move the data
		 */
		try {
			if (this.getMigrationContext().getExternalIdForUpsert() == null) {
				new DataInsertExecutor().execute(this.getMigrationContext());
			} else {
				new DataUpsertExecutor().execute(this.getMigrationContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.publishStatus("Found a problem: " + e.getLocalizedMessage());
			throw new RuntimeException(e);
		}

		// new DefaultPageLayoutFinder(this.getMigrationContext()).getLayout();

		log.info("complete");

	}




}
