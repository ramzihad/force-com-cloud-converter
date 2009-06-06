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
package com.modelmetrics.cc.importxls.svcs;

import com.modelmetrics.cc.importxls.struts2.UploadContext;
import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriber;

public class SalesforceServiceImpl extends AbstractSalesforceService {

	private UploadContext uploadContext;
	
	public void execute(UploadContext uploadContext) throws Exception {

		this.uploadContext = uploadContext;
		
		for (CloudConverterObject current : uploadContext
				.getCloudConverterObjects()) {

			this.execute(current, uploadContext.getStatusSubscriber());

		}

	}
	
	public void execute(CloudConverterObject current, MigrationStatusSubscriber migrationStatusSubscriber) throws Exception {
		
		// reset status
		migrationStatusSubscriber.reset();
		
		// notify subscribers
		migrationStatusSubscriber.publish(
				"Starting object: " + current.getObjectLabel() + " ("
						+ current.getObjectName() + ")");

		// get started
		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(this.getSalesforceSession());

		migrationContext.setCloudConverterObject(current);
		
		migrationContext.setPicklistFields(current.getPicklistFields());

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build(migrationContext);
		migrationEngineIF.setMigrationContext(migrationContext);
		migrationEngineIF.subscribeToStatus(migrationStatusSubscriber);
		migrationEngineIF.execute();
		
		migrationStatusSubscriber.publish(
				"Object complete: " + current.getObjectLabel() + " ("
						+ current.getObjectName() + ")");
		
	}

}
