package com.mmimport.actions;

import java.io.File;

import com.mmimport.test.utils.SpringUtils;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.opensymphony.xwork2.ActionSupport;

public class UploadActionTest extends TestCaseWithDevOrg {

	private String sampleObject = "sheet1__c";

	@Override
	protected void setUp() throws Exception {

		log.debug("starting setup");

		super.setUp();

		this.handleCustomObjectKill(this.sampleObject);

		log.debug("setup complete");

	}
	
	public void testSampleUpload_Sheet4WithNames() throws Exception {
	
		UploadAction action = (UploadAction) SpringUtils.getBean("uploadAction");
		
		assertNotNull(action.getFileService());
		
		assertNotNull(action.getSalesforceService());
		
		action.setUsername(this.sampleSfdcUsername);
		
		action.setPassword(this.sampleSfdcPassword);
		
		action.setOverride(Boolean.TRUE);
		
		action.setUpload(new File("./src/sampledbs/excel/SampleInputSpreadsheet2009-03-17.v4.xls"));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);
		
	}
	
}
