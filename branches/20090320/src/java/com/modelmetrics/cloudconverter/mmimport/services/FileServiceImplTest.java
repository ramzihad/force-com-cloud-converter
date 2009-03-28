package com.modelmetrics.cloudconverter.mmimport.services;

import java.io.File;

import com.modelmetrics.cloudconverter.mmimport.beans.WrapperBean;
import com.modelmetrics.cloudconverter.mmimport.utils.Constants;
import com.modelmetrics.common.spring.util.SpringBeanBroker;

import junit.framework.TestCase;

public class FileServiceImplTest extends TestCase {

	public void testSampleSheet() throws Exception {
		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v1.xls";
		
		FileServiceImpl fileServiceImpl = (FileServiceImpl) SpringBeanBroker.getBeanFactory().getBean("fileService");
		
		WrapperBean wrapperBean = fileServiceImpl.parseXLS(new File(fileName));
		
		assertNotNull(wrapperBean);
		
		assertEquals(Constants.STRING, wrapperBean.getTypes().get(0));
		
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
}
