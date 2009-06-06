/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.modelmetrics.cc.importxls.svcs;

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
	
	public void testSampleSheetMultipleTabsFormulas() throws Exception {
		String fileName = "./src/sampledbs/excel/Project-Management-Demo-2009-05-26.xls";
		
		FileServiceImpl fileServiceImpl = new FileServiceImpl();
		
		List<ExcelWorksheetWrapperBean> wrapperBeans = fileServiceImpl.parseXLS(new File(fileName));
		ExcelWorksheetWrapperBean wrapperBean = wrapperBeans.get(0);
		
		
	}

	
}
