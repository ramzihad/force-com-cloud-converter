package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.List;

import com.modelmetrics.cloudconverter.forceutil.CustomObjectNameBuilder;

public class CustomObjectNameDecorator {
	public void decorate(List<CloudConverterObject> cloudConverterObjects) {

		for (CloudConverterObject current : cloudConverterObjects) {

			current.setObjectName(new CustomObjectNameBuilder()
					.buildCustomObjectName(current.getObjectName()));
		}
	}
}
