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
package com.modelmetrics.cloudconverter.util;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import com.modelmetrics.cloudconverter.importxls.services.ExcelWorksheetWrapperBean;
import com.modelmetrics.cloudconverter.importxls.services.FileServiceImpl;
import com.modelmetrics.common.spring.util.SpringBeanBroker;
import com.sforce.soap._2006._04.metadata.FieldType;

public class MetadataProxyCollectionBuilderTest extends TestCase {

	public void testWrapperBeanToMetadataProxy() throws Exception {
		
		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v1.xls";
		
		FileServiceImpl fileServiceImpl = (FileServiceImpl) SpringBeanBroker.getBeanFactory().getBean("fileService");
		
		List<ExcelWorksheetWrapperBean> wrapperBeans = fileServiceImpl.parseXLS(new File(fileName));
		ExcelWorksheetWrapperBean wrapperBean = wrapperBeans.get(0);
		assertNotNull(wrapperBean);		

		List<MetadataProxy> proxies = new MetadataProxyCollectionBuilder().build(wrapperBean);
		
		assertEquals(wrapperBean.getTypes().size(), proxies.size());
		
		assertEquals(proxies.get(0).getType(), FieldType.Text);
		
		assertEquals(proxies.get(1).getType(), FieldType.Date);

		assertEquals(proxies.get(2).getType(), FieldType.DateTime);

		assertEquals(proxies.get(3).getType(), FieldType.Number);

		assertEquals(proxies.get(4).getType(), FieldType.Number);
		
		assertEquals(proxies.get(5).getType(), FieldType.Percent);

		assertEquals(proxies.get(6).getType(), FieldType.Currency);
		
		assertEquals(proxies.get(7).getType(), FieldType.Email);
		
		assertEquals(proxies.get(8).getType(), FieldType.Url);

	}
	
	public void testSampleSheet_ShowedIndexOutOfBoundsErrors() throws Exception {
		//2009-05-03 resulted in a default field data type.
		
		String fileName = "./src/sampledbs/excel/Sample-Error-Index-OutOfBounds-2009-05-03.xls";
		
		FileServiceImpl fileServiceImpl = new FileServiceImpl();
		List<ExcelWorksheetWrapperBean> wrapperBeans = fileServiceImpl.parseXLS(new File(fileName));
		ExcelWorksheetWrapperBean wrapperBean = wrapperBeans.get(0);
		assertNotNull(wrapperBean);		
		assertNotNull(wrapperBean);
		
		List<MetadataProxy> proxies = new MetadataProxyCollectionBuilder().build(wrapperBean);

		
	}
}
