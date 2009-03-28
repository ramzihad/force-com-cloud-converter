package com.modelmetrics.cloudconverter.mmimport.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import junit.framework.TestCase;

import com.modelmetrics.cloudconverter.mmimport.beans.WrapperBean;
import com.modelmetrics.common.spring.util.SpringBeanBroker;

public class POIServiceTest extends TestCase {

	private FileService service;

	private static final String FILE_NAME = "example-test.xls";

	public void setUp() {

		service = (FileService) SpringBeanBroker.getBeanFactory().getBean("fileService");

	}

	public void testParsing() {
		InputStream stream = getClass().getClassLoader().getResourceAsStream(
				FILE_NAME);

		if (stream == null) {
			stream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(FILE_NAME);
		}

		assertNotNull(stream);

		WrapperBean bean;

		try {

			File file = getFileFromStream(stream);
			bean = service.parseXLS(file);

			assertNotNull(bean);

			assertEquals(bean.getNames().isEmpty(), false);
			assertEquals(bean.getTypes().isEmpty(), false);
			assertEquals(bean.getObjects().isEmpty(), false);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	private File getFileFromStream(InputStream inputStream) throws Exception {
		File f = new File(FILE_NAME);
		OutputStream out = new FileOutputStream(f);
		byte buf[] = new byte[1024];
		int len;
		while ((len = inputStream.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		out.close();
		inputStream.close();
		return f;
	}

}
