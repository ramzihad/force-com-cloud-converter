package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;

import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.SalesforceSessionNewImpl;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.spring.util.SpringBeanBroker;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.opensymphony.xwork2.ActionSupport;

public class UploadActionCompositeTest extends TestCaseWithDevOrg {

	private String sampleObject = "sheet1__c";

	@Override
	protected void setUp() throws Exception {

		log.debug("starting setup");

		super.setUp();

		this.handleCustomObjectKill(this.sampleObject);

		log.debug("setup complete");

	}
	
	public void testSampleUpload_TestSheet1() throws Exception {

		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v1.xls";

		
		UploadActionComposite action = (UploadActionComposite) this.getTestBeanFactory().getBean("uploadActionComposite");

		assertNotNull(action.getFileService());

		assertNotNull(action.getSalesforceService());
		
		action.setUploadContext(new UploadContext());
		
		action.setSalesforceSessionContext(new SalesforceSessionContext());

		SalesforceSessionNewImpl salesforceSessionNewImpl = new SalesforceSessionNewImpl();

		salesforceSessionNewImpl
				.setSalesforceCredentials(this.salesforceCredentials);
		
		log.debug("heading to the main test of action with an existing session id...");

action.getSalesforceSessionContext().setSalesforceSession(salesforceSessionNewImpl);

		action.setOverride(Boolean.TRUE);

		action.setUpload(new File(fileName));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);

	}
	
	public void testSampleUpload_TestSheet2_The500() throws Exception {

		this.handleCustomObjectKill("The500__c");
		
		String fileName = "./src/sampledbs/excel/TestSpreadsheet-500-DoNotChange-v1.xls";

		
		UploadActionComposite action = (UploadActionComposite) this.getTestBeanFactory().getBean("uploadActionComposite");

		assertNotNull(action.getFileService());

		assertNotNull(action.getSalesforceService());
		
		action.setUploadContext(new UploadContext());

		SalesforceSessionNewImpl salesforceSessionNewImpl = new SalesforceSessionNewImpl();

		salesforceSessionNewImpl
				.setSalesforceCredentials(this.salesforceCredentials);
		
		log.debug("heading to the main test of action with an existing session id...");

		SalesforceSessionContext salesforceSessionContext = new SalesforceSessionContext();
		salesforceSessionContext.setSalesforceSession(new SalesforceSessionFactory().build(salesforceSessionNewImpl.getSessionId(), salesforceSessionNewImpl.getUrl()));

		action.setSalesforceSessionContext(salesforceSessionContext);
		
		action.setOverride(Boolean.TRUE);
		
		

		action.setUpload(new File(fileName));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);

	}

}
