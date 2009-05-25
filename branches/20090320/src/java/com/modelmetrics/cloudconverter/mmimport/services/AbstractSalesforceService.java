package com.modelmetrics.cloudconverter.mmimport.services;

import org.apache.log4j.Logger;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeGlobalResult;

public abstract class AbstractSalesforceService implements SalesforceService {

	static final Logger log = Logger
			.getLogger(AbstractSalesforceService.class);

	private SalesforceSession salesforceSession;


	public boolean containsObject(String objectName) throws Exception {
		DescribeGlobalResult result = salesforceSession.getSalesforceService()
				.describeGlobal();

		boolean foundType = false;
		
		for (int i = 0; i < result.getTypes().length; i++) {
			String name = result.getTypes(i);
			if (name.equalsIgnoreCase(objectName)) {
				foundType = true;
			}
		}

		return foundType;
	}



	
	public SalesforceSession getSalesforceSession() {
		return salesforceSession;
	}

	public void setSalesforceSession(SalesforceSession salesforceSession) {
		this.salesforceSession = salesforceSession;
	}

}
