package com.modelmetrics.cloudconverter.mmimport.test.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringUtils {

	private static BeanFactory beanFactory;

	public static Object getBean(String name) {

		if (beanFactory == null) {
			beanFactory = new XmlBeanFactory(new ClassPathResource(
					"spring-config.xml"));
		}
		return beanFactory.getBean(name);
	}

}
