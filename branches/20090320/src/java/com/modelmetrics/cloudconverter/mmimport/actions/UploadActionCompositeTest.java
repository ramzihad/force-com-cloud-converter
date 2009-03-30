package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;

import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSessionNewImpl;
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

		
		UploadActionComposite action = (UploadActionComposite) SpringBeanBroker
				.getBeanFactory().getBean("uploadActionComposite");

		assertNotNull(action.getFileService());

		assertNotNull(action.getSalesforceService());
		
		action.setUploadContext(new UploadContext());

		SalesforceSessionNewImpl salesforceSessionNewImpl = new SalesforceSessionNewImpl();

		salesforceSessionNewImpl
				.setSalesforceCredentials(this.salesforceCredentials);
		
		log.debug("heading to the main test of action with an existing session id...");

		action.setExistingSessionId(salesforceSessionNewImpl.getSessionId());

		action.setExistingLocationUrl(salesforceSessionNewImpl.getUrl());

		action.setOverride(Boolean.TRUE);

		action.setUpload(new File(fileName));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);

	}

}
