package com.mmimport.actions;

import java.io.File;

import com.mmimport.beans.WrapperBean;
import com.mmimport.services.impl.POIService;
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
	
	public void testSampleUpload_Sheet1() throws Exception {
	
		UploadAction action = (UploadAction) SpringUtils.getBean("uploadAction");
		
		assertNotNull(action.getFileService());
		
		assertNotNull(action.getSalesforceService());
		
		action.setUsername(this.sampleSfdcUsername);
		
		action.setPassword(this.sampleSfdcPassword);
		
		action.setOverride(Boolean.TRUE);
		
		action.setUpload(new File("./src/sampledbs/excel/SampleInputSpreadsheet2009-03-17.v1.xls"));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);
		
	}
	
	/*
	 * functional test
	 */
	public void testSampleUpload_TestSheet1() throws Exception {
		
		String fileName = "TestSpreadsheet-DoNotChange-v1.xls";
		
		UploadAction action = (UploadAction) SpringUtils.getBean("uploadAction");
		
		assertNotNull(action.getFileService());
		
		assertNotNull(action.getSalesforceService());
		
		action.setUsername(this.sampleSfdcUsername);
		
		action.setPassword(this.sampleSfdcPassword);
		
		action.setOverride(Boolean.TRUE);
		
		action.setUpload(new File(fileName));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);
		
		/*
		 * OK now this is to make sure we get everything set here.
		 */
		POIService poService = new POIService();
		
		WrapperBean wrapperBean = poService.parseXLS(new File(fileName));
		
		assertEquals("sheet1", wrapperBean.getSheetName());
		
		
		
		
		
		
	}
	
}
