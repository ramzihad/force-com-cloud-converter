package com.modelmetrics.cloudconverter.engine;

import java.io.File;

import com.modelmetrics.cloudconverter.mmimport.actions.ImportPrepareAction;
import com.modelmetrics.cloudconverter.mmimport.actions.UploadActionComposite;
import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriberLifoImpl;
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
		objectDeleteHandler.execute(salesforceSession, uploadContext.getCloudConverterObjects(), new MigrationStatusSubscriberLifoImpl());
		
	}
}
