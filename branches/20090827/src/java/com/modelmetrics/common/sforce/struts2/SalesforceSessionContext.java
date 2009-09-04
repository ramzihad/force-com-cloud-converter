/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.modelmetrics.common.sforce.struts2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.common.sforce.AbstractSalesforceSessionAware;
import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.sforce.soap.partner.GetUserInfoResult;

public class SalesforceSessionContext extends AbstractSalesforceSessionAware {

	private static final Log log = LogFactory.getLog(SalesforceSessionContext.class);
	
	private GetUserInfoResult userInfo;
	
	public SalesforceSessionContext() {
		super();
		log.debug("In create.");
	}
	
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

	public GetUserInfoResult getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(GetUserInfoResult userInfo) {
		this.userInfo = userInfo;
	}
	
	public boolean isAdmin() {
		return this.userInfo.getOrganizationId().substring(0,15).equalsIgnoreCase("00DA0000000H9WC");
	}
}
