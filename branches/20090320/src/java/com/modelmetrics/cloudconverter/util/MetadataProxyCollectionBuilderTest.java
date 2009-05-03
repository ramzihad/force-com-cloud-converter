package com.modelmetrics.cloudconverter.util;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import com.modelmetrics.cloudconverter.mmimport.services.FileServiceImpl;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.common.spring.util.SpringBeanBroker;
import com.sforce.soap._2006._04.metadata.FieldType;

public class MetadataProxyCollectionBuilderTest extends TestCase {

	public void testWrapperBeanToMetadataProxy() throws Exception {
		
		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v1.xls";
		
		FileServiceImpl fileServiceImpl = (FileServiceImpl) SpringBeanBroker.getBeanFactory().getBean("fileService");
		
		WrapperBean wrapperBean = fileServiceImpl.parseXLS(new File(fileName));
		
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
		
		WrapperBean wrapperBean = fileServiceImpl.parseXLS(new File(fileName));
		
		assertNotNull(wrapperBean);
		
		List<MetadataProxy> proxies = new MetadataProxyCollectionBuilder().build(wrapperBean);

		
	}
}
