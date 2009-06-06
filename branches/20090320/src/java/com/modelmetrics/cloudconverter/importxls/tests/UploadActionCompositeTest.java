package com.modelmetrics.cloudconverter.importxls.tests;

import java.io.File;

import com.modelmetrics.cloudconverter.importxls.services.CloudConverterObject;
import com.modelmetrics.cloudconverter.importxls.struts2.UploadActionComposite;
import com.modelmetrics.cloudconverter.importxls.struts2.UploadContext;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.opensymphony.xwork2.ActionSupport;

public class UploadActionCompositeTest extends TestCaseWithDevOrg {

	@Override
	protected void setUp() throws Exception {

		log.debug("starting setup");

		log.debug("setup complete");

	}

	public void testSampleUpload_TestSheet1() throws Exception {

		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v1.xls";

		UploadActionComposite action = (UploadActionComposite) this
				.getTestBeanFactory().getBean("uploadActionComposite");

		assertNotNull(action.getFileService());

		assertNotNull(action.getSalesforceService());

		action.setUploadContext(new UploadContext());

		action.setSalesforceSessionContext(new SalesforceSessionContext());

		action.getSalesforceSessionContext().setSalesforceSession(
				new SalesforceSessionFactory().buildReturnsSingleMock());

		action.setUpload(new File(fileName));

		String s = action.execute();

		assertEquals(ActionSupport.SUCCESS, s);

		assertEquals(1, action.getUploadContext().getCloudConverterObjects()
				.size());

		CloudConverterObject object = action.getUploadContext()
				.getCloudConverterObjects().get(0);

		assertNotNull(object.getOriginalData());

		assertNotNull(object.getMetadataProxies());

		assertNull(object.getLookupSettings());

		assertFalse(object.isExistsInSalesforce());

	}

	public void testSampleUpload_MultipleWorksheets() throws Exception {

		String fileName = "./src/sampledbs/excel/Sample-Excel-MultiTab-Related-v1.xls";

		UploadActionComposite action = (UploadActionComposite) this
				.getTestBeanFactory().getBean("uploadActionComposite");

		assertNotNull(action.getFileService());

		assertNotNull(action.getSalesforceService());

		action.setUploadContext(new UploadContext());

		action.setSalesforceSessionContext(new SalesforceSessionContext());

		action.getSalesforceSessionContext().setSalesforceSession(
				new SalesforceSessionFactory().buildReturnsSingleMock());

		action.setUpload(new File(fileName));

		String s = action.execute();

		assertEquals(ActionSupport.SUCCESS, s);

		assertEquals(2, action.getUploadContext().getCloudConverterObjects()
				.size());

		CloudConverterObject object = action.getUploadContext()
				.getCloudConverterObjects().get(0);

		assertNotNull(object.getOriginalData());

		assertNotNull(object.getMetadataProxies());

		assertNull(object.getLookupSettings());

		assertFalse(object.isExistsInSalesforce());

		object = action.getUploadContext().getCloudConverterObjects().get(1);

		assertNotNull(object.getOriginalData());

		assertNotNull(object.getMetadataProxies());

		assertNull(object.getLookupSettings());

		assertFalse(object.isExistsInSalesforce());

	}

}
