package com.modelmetrics.utility.common.struts2;

import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;

public class UtilityContext  {

	private SalesforceCredentials salesforceCredentials;


	public SalesforceCredentials getSalesforceCredentials() {
		return salesforceCredentials;
	}


	public void setSalesforceCredentials(SalesforceCredentials salesforceCredentials) {
		this.salesforceCredentials = salesforceCredentials;
	}


}
