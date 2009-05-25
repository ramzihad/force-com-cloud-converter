package com.modelmetrics.cloudconverter.mmimport.services;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.modelmetrics.common.util.TestCaseWithLog;

public class FileServiceImplTest extends TestCaseWithLog {

	public void testSampleSheet() throws Exception {
		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v1.xls";
		
		FileServiceImpl fileServiceImpl = new FileServiceImpl();
		
		List<ExcelWorksheetWrapperBean> wrapperBeans = fileServiceImpl.parseXLS(new File(fileName));
		ExcelWorksheetWrapperBean wrapperBean = wrapperBeans.get(0);
		assertNotNull(wrapperBean);
		
		assertEquals(Constants.TEXT, wrapperBean.getTypes().get(0));
		
		assertEquals(Constants.DATE, wrapperBean.getTypes().get(1));
		
		assertEquals(Constants.DATETIME, wrapperBean.getTypes().get(2));
		
		assertEquals(Constants.INT, wrapperBean.getTypes().get(3));
		
		assertEquals(Constants.DOUBLE, wrapperBean.getTypes().get(4));
		
		assertEquals(Constants.PERCENTAGE, wrapperBean.getTypes().get(5));

		assertEquals(Constants.CURRENCY, wrapperBean.getTypes().get(6));

		assertEquals(Constants.EMAIL, wrapperBean.getTypes().get(7));

		assertEquals(Constants.URL, wrapperBean.getTypes().get(8));
		
		assertEquals("S heet1", wrapperBean.getSheetName());

	}
	
	public void testSampleSheetWithDates() throws Exception {
		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v2.xls";
		
		FileServiceImpl fileServiceImpl = new FileServiceImpl();
		
		List<ExcelWorksheetWrapperBean> wrapperBeans = fileServiceImpl.parseXLS(new File(fileName));
		ExcelWorksheetWrapperBean wrapperBean = wrapperBeans.get(0);
		assertNotNull(wrapperBean);		
		assertNotNull(wrapperBean);
		
		assertEquals(Constants.DATE, wrapperBean.getTypes().get(0));
		
		Date dateOne = (Date) wrapperBean.getData().get(0).get(0);
		
		log.info(dateOne.toString());

		
	}
	
	public void testSampleSheetWithDateTimes() throws Exception {
		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v3.xls";
		
		FileServiceImpl fileServiceImpl = new FileServiceImpl();
		
		List<ExcelWorksheetWrapperBean> wrapperBeans = fileServiceImpl.parseXLS(new File(fileName));
		ExcelWorksheetWrapperBean wrapperBean = wrapperBeans.get(0);
		assertNotNull(wrapperBean);		
		assertNotNull(wrapperBean);
		
		assertEquals(Constants.DATETIME, wrapperBean.getTypes().get(0));
		
		Date dateOne = (Date) wrapperBean.getData().get(0).get(0);
		
		log.info(dateOne.toString());

		
	}
	

	
}
