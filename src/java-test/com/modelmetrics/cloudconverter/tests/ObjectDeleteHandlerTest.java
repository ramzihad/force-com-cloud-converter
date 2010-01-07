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
package com.modelmetrics.cloudconverter.tests;

import java.io.File;

import com.modelmetrics.cloudconverter.engine.ObjectDeleteHandler;
import com.modelmetrics.cloudconverter.importxls.struts2.ImportPrepareAction;
import com.modelmetrics.cloudconverter.importxls.struts2.UploadActionComposite;
import com.modelmetrics.cloudconverter.importxls.struts2.UploadContext;
import com.modelmetrics.cloudconverter.util.OperationStatusSubscriberLifoImpl;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Requires Publisher__c and Publications__c to be useful.
 * 
 * @author reidcarlberg
 * @since 2009-05-25
 */
public class ObjectDeleteHandlerTest extends TestCaseWithDevOrg {

	public void testBasic() throws Exception {
		SalesforceSession salesforceSession = new SalesforceSessionFactory().build(this.salesforceCredentials);
		
		if (!this.containsTestObject(salesforceSession, "Publisher__c") || !this.containsTestObject(salesforceSession, "Publications__c")) {
			throw new RuntimeException("requires both pub and publication to work.");
		}
		
		// target file
		String fileName = "./src/sampledbs/excel/Sample-Excel-MultiTab-Related-v1.xls";

		SalesforceSessionContext salesforceSessionContext = new SalesforceSessionContext();
		salesforceSessionContext.setSalesforceSession(salesforceSession);

		UploadContext uploadContext = new UploadContext();

		// upload action composite
		UploadActionComposite uploadActionComposite = (UploadActionComposite) this
				.getTestBeanFactory().getBean("uploadActionComposite");

		uploadActionComposite
				.setSalesforceSessionContext(salesforceSessionContext);
		uploadActionComposite.setUploadContext(uploadContext);
		uploadActionComposite.setUpload(new File(fileName));

		String s = uploadActionComposite.execute();

		assertEquals(ActionSupport.SUCCESS, s);

		// standard import prepare
		ImportPrepareAction standardImportPrepareAction = new ImportPrepareAction();
		standardImportPrepareAction.setUploadContext(uploadContext);
		standardImportPrepareAction
				.setSalesforceSessionContext(salesforceSessionContext);
		standardImportPrepareAction.setSalesforceService(uploadActionComposite
				.getSalesforceService());
		
		s = standardImportPrepareAction.execute();		
		
		ObjectDeleteHandler objectDeleteHandler = new ObjectDeleteHandler();
		objectDeleteHandler.execute(salesforceSession, uploadContext.getCloudConverterObjects(), new OperationStatusSubscriberLifoImpl());
		
	}
}
