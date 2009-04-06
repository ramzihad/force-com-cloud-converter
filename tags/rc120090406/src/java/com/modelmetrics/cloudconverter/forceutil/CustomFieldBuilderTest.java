package com.modelmetrics.cloudconverter.forceutil;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.mmimport.services.FileServiceImpl;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.modelmetrics.cloudconverter.util.MetadataProxyCollectionBuilder;
import com.modelmetrics.common.spring.util.SpringBeanBroker;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.FieldType;

public class CustomFieldBuilderTest extends TestCase {

	public void testBasedOnExcel() throws Exception {

		String fileName = "./src/sampledbs/excel/TestSpreadsheet-DoNotChange-v1.xls";

		FileServiceImpl fileServiceImpl = (FileServiceImpl) SpringBeanBroker
				.getBeanFactory().getBean("fileService");

		WrapperBean wrapperBean = fileServiceImpl.parseXLS(new File(fileName));

		assertNotNull(wrapperBean);

		List<MetadataProxy> proxies = new MetadataProxyCollectionBuilder()
				.build(wrapperBean);

		MigrationContext migrationContext = new MigrationContext();

		migrationContext.setCustomObject(new CustomObjectBuilder()
				.build("test"));

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
