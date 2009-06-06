package com.modelmetrics.cloudconverter.importxls.struts2;

import java.io.File;

import com.modelmetrics.cc.importxls.svcs.CloudConverterObject;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class StandardImportTest extends TestCaseWithDevOrg {

	public void testBasic() throws Exception {

		this.handleCustomObjectKill("Publisher__c");
		this.handleCustomObjectKill("Publications__c");
		
		// target file
		String fileName = "./src/sampledbs/excel/Sample-Excel-MultiTab-Related-v1.xls";

		// basics
		SalesforceSession session = new SalesforceSessionFactory()
				.build(this.salesforceCredentials);
		SalesforceSessionContext salesforceSessionContext = new SalesforceSessionContext();
		salesforceSessionContext.setSalesforceSession(session);

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

		assertEquals(ActionSupport.SUCCESS, s);
		
		assertEquals(2, uploadContext.getCloudConverterObjects().size());
		CloudConverterObject cloudConverterObject = uploadContext.getCloudConverterObjects().get(0);
		
		assertNotNull(cloudConverterObject.getObjectName());
		assertTrue(cloudConverterObject.getObjectName().endsWith("__c"));

		
		// standard import execute

		StandardImportExecuteAction standardImportExecuteAction = new StandardImportExecuteAction();
		standardImportExecuteAction.setUploadContext(uploadContext);
		standardImportExecuteAction.setSalesforceSessionContext(salesforceSessionContext);
		
		s = standardImportExecuteAction.execute();
		
		assertEquals(Action.SUCCESS, s);
		
		// validate
		assertTrue(this.containsTestObject(session, "Publisher__c"));
		assertTrue(this.containsTestObject(session, "Publications__c"));

	}
}
