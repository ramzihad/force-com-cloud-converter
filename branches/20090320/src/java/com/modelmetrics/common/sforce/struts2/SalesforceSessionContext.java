package com.modelmetrics.common.sforce.struts2;

import com.modelmetrics.common.sforce.AbstractSalesforceSessionAware;
import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;

public class SalesforceSessionContext extends AbstractSalesforceSessionAware {

	public void setSalesforceCredentials(String salesforceUsername,
			String salesforcePassword) throws Exception {

		this.setSalesforceSession(new SalesforceSessionFactory()
				.build(new SalesforceCredentials(salesforceUsername,
						salesforcePassword)));
		this.getSalesforceSession().initialize();

	}

	public void setSalesforceExistingSession(String sessionId, String url)
			throws Exception {

		this.setSalesforceSession(new SalesforceSessionFactory().build(
				sessionId, url));
		this.getSalesforceSession().initialize();

	}
	
	public String getProfileListUrl() {

		// https://na4-api

		String ret = this.getSalesforceSession().getUrl().substring(0, 11)
				+ ".salesforce.com/setup/ui/profilelist.jsp?setupid=Profiles&retURL=%2Fui%2Fsetup%2FSetup%3Fsetupid%3DUsers";

		return ret;
	}
}
