package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.List;

public class ExistsInSalesforceDecorator {

	public void decorate(List<CloudConverterObject> cloudConverterObjects,
			SalesforceService salesforceService) {

		for (CloudConverterObject current : cloudConverterObjects) {
			if (current.getObjectName() == null
					|| !current.getObjectName().endsWith("__c")) {
				throw new RuntimeException(
						"Can't check blank or non-custom object names");
			}

			try {
				current.setExistsInSalesforce(salesforceService
						.containsObject(current.getObjectName()));
			} catch (Exception e) {
				throw new RuntimeException("Couldn't determine if '"
						+ current.getObjectName() + "' exists in SFDC.");
			}
		}
	}

}
