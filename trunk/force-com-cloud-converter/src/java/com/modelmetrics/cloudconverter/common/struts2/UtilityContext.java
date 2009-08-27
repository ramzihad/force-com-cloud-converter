package com.modelmetrics.cloudconverter.common.struts2;

import com.modelmetrics.common.sforce.SalesforceCredentials;

public class UtilityContext  {

	private SalesforceCredentials salesforceCredentials;


	public SalesforceCredentials getSalesforceCredentials() {
		return salesforceCredentials;
	}


	public void setSalesforceCredentials(SalesforceCredentials salesforceCredentials) {
		this.salesforceCredentials = salesforceCredentials;
	}


}
