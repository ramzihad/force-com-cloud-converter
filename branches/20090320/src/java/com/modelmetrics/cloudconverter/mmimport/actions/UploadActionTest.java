package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;

import com.modelmetrics.cloudconverter.mmimport.services.FileServiceImpl;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.common.spring.util.SpringBeanBroker;
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
	
		UploadAction action = (UploadAction) SpringBeanBroker.getBeanFactory().getBean("uploadAction");
		
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
	 * 
	 * unit tests in FileServiceImplTest and MetadataProxyCollectionBuilderTest.
	 */
	public void testSampleUpload_TestSheet1() throws Exception {
		
		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v1.xls";
		
		UploadAction action = (UploadAction) SpringBeanBroker.getBeanFactory().getBean("uploadAction");
		
		assertNotNull(action.getFileService());
		
		assertNotNull(action.getSalesforceService());
		
		action.setUsername(this.sampleSfdcUsername);
		
		action.setPassword(this.sampleSfdcPassword);
		
		action.setOverride(Boolean.TRUE);
		
		action.setUpload(new File(fileName));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);
		
		
	}
	
}
