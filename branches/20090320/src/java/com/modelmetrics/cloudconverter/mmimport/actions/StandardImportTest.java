package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.opensymphony.xwork2.ActionSupport;

public class StandardImportTest extends TestCaseWithDevOrg {

	public void testBasic() throws Exception {

		//target file
		String fileName = "./src/sampledbs/excel/Sample-Excel-MultiTab-Related-v1.xls";

		//basics
		SalesforceSession session = new SalesforceSessionFactory().build(this.salesforceCredentials);
		SalesforceSessionContext salesforceSessionContext = new SalesforceSessionContext();
		salesforceSessionContext.setSalesforceSession(session);
		
		UploadContext uploadContext = new UploadContext();
		
		//upload action composite
		UploadActionComposite uploadActionComposite =(UploadActionComposite) this
				.getTestBeanFactory().getBean("uploadActionComposite");
		
		uploadActionComposite.setSalesforceSessionContext(salesforceSessionContext);
		uploadActionComposite.setUploadContext(uploadContext);
		uploadActionComposite.setUpload(new File(fileName));

		String s = uploadActionComposite.execute();

		assertEquals(ActionSupport.SUCCESS, s);
		
		
		//standard import prepare
		
		//standard import execute
		
		//validate
		
	}
}
