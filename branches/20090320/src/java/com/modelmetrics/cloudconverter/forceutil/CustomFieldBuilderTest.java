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
package com.modelmetrics.cloudconverter.forceutil;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.modelmetrics.cloudconverter.util.MetadataProxyCollectionBuilder;
import com.modelmetrics.common.spring.util.SpringBeanBroker;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.FieldType;
import com.temp.ExcelWorksheetWrapperBean;
import com.temp.FileServiceImpl;

public class CustomFieldBuilderTest extends TestCase {

	public void testBasedOnExcel() throws Exception {

		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v1.xls";

		FileServiceImpl fileServiceImpl = (FileServiceImpl) SpringBeanBroker
				.getBeanFactory().getBean("fileService");

		List<ExcelWorksheetWrapperBean> wrapperBeans = fileServiceImpl.parseXLS(new File(fileName));
		ExcelWorksheetWrapperBean wrapperBean = wrapperBeans.get(0);
		assertNotNull(wrapperBean);
		assertNotNull(wrapperBean);

		List<MetadataProxy> proxies = new MetadataProxyCollectionBuilder()
				.build(wrapperBean);

		MigrationContext migrationContext = new MigrationContext();

		migrationContext.setCustomObject(new CustomObjectBuilder()
				.build("test__c", "test"));

		migrationContext.setMetadataProxies(proxies);

		CustomFieldBuilder customFieldBuilder = new CustomFieldBuilder();

		CustomField[] fields = customFieldBuilder.build(migrationContext);
		
		assertEquals(proxies.size(), fields.length);
		
		assertEquals(fields[0].getType(), FieldType.Text);
		assertEquals(fields[1].getType(), FieldType.Date);
		assertEquals(fields[2].getType(), FieldType.DateTime);
		assertEquals(fields[3].getType(), FieldType.Number);
		assertEquals(fields[4].getType(), FieldType.Number);
		assertEquals(fields[5].getType(), FieldType.Percent);
		assertEquals(fields[6].getType(), FieldType.Currency);
		assertEquals(fields[7].getType(), FieldType.Email);
		assertEquals(fields[8].getType(), FieldType.Url);

	}
}
