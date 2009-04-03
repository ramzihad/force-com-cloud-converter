package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;

import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
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
	
	public void testBadCredentials() throws Exception {
		UploadAction action = (UploadAction) this.getTestBeanFactory().getBean("uploadAction");
		
		assertNotNull(action.getFileService());
		
		assertNotNull(action.getSalesforceService());
		
		action.setUploadContext(new UploadContext());
		
		action.setSalesforceSessionContext(new SalesforceSessionContext());
		
		action.setUsername("bad@username.com");
		
		action.setPassword("badPassword");
		
		action.setOverride(Boolean.TRUE);
		
		action.setUpload(new File("./src/sampledbs/excel/SampleInputSpreadsheet2009-03-17.v1.xls"));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.INPUT, s);

		assertTrue(action.hasActionMessages());
		
	}
	public void testSampleUpload_Sheet1() throws Exception {
	
		UploadAction action = (UploadAction) this.getTestBeanFactory().getBean("uploadAction");
		
		action.setUploadContext(new UploadContext());
		
		action.setSalesforceSessionContext(new SalesforceSessionContext());
		
		assertNotNull(action.getFileService());
		
		assertNotNull(action.getSalesforceService());
		
		action.setUsername(this.sampleSfdcUsername);
		
		action.setPassword(this.sampleSfdcPassword);
		
		action.setOverride(Boolean.TRUE);
		
		action.setUpload(new File("./src/sampledbs/excel/SampleInputSpreadsheet2009-03-17.v1.xls"));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);
		
	}
	
	public void testSampleUpload_WasFailing_Evan1() throws Exception {
		
		UploadAction action = (UploadAction) this.getTestBeanFactory().getBean("uploadAction");
		
		action.setUploadContext(new UploadContext());
		
		action.setSalesforceSessionContext(new SalesforceSessionContext());
		
		assertNotNull(action.getFileService());
		
		assertNotNull(action.getSalesforceService());
		
		action.setUsername(this.sampleSfdcUsername);
		
		action.setPassword(this.sampleSfdcPassword);
		
		action.setOverride(Boolean.TRUE);
		
		action.setUpload(new File("./src/sampledbs/excel/snapshot test.xls"));
		
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
		
		UploadAction action = (UploadAction) this.getTestBeanFactory().getBean("uploadAction");
		
		assertNotNull(action.getFileService());
		
		assertNotNull(action.getSalesforceService());
		
		action.setUploadContext(new UploadContext());
		
		action.setSalesforceSessionContext(new SalesforceSessionContext());
		
		action.setUsername(this.sampleSfdcUsername);
		
		action.setPassword(this.sampleSfdcPassword);
		
		action.setOverride(Boolean.TRUE);
		
		action.setUpload(new File(fileName));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);
		
		
	}
	
	public void testSampleUpload_TestSheet2() throws Exception {
		
		
		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v2.xls";
		
		UploadAction action = (UploadAction) this.getTestBeanFactory().getBean("uploadAction");
		
		assertNotNull(action.getFileService());
		
		assertNotNull(action.getSalesforceService());
		
		
		
		action.setUploadContext(new UploadContext());
		
		action.setSalesforceSessionContext(new SalesforceSessionContext());
		
		action.setUsername(this.sampleSfdcUsername);
		
		action.setPassword(this.sampleSfdcPassword);
		
		action.setOverride(Boolean.TRUE);
		
		action.setUpload(new File(fileName));
		
		String s = action.upload();
		
		assertEquals(ActionSupport.SUCCESS, s);
		
		
	}
	

	
}
