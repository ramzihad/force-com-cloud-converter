package com.modelmetrics.cloudconverter.admin.struts2;

import com.modelmetrics.cloudconverter.admin.AdminBean;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminHome extends ActionSupport {

	private String existingLocationUrl;
	
	private String existingSessionId;
	
	private SalesforceSessionContext salesforceSessionContext;
	
	public String execute() throws Exception {
		
		if (this.getSalesforceSessionContext().getSalesforceSession() == null
				&& this.getExistingSessionId() != null
				&& this.getExistingLocationUrl() != null) {
			
			/*
			 * 2009-09-03
			 */
			if (!this.getExistingLocationUrl().matches("https://[^/]+\\.(sales|visual\\.)force\\.com/services/(S|s)(O|o)(A|a)(P|p)/(u|c)/.*")) {
				addActionMessage("Location URL is invalid.");
				return ERROR;
			}
			
			this.getSalesforceSessionContext().setSalesforceExistingSession(
					this.getExistingSessionId(), this.getExistingLocationUrl());

			this.getSalesforceSessionContext().setUserInfo(
					this.getSalesforceSessionContext().getSalesforceSession()
							.getSalesforceService().getUserInfo());

			
		}
		
		if (!this.salesforceSessionContext.isAdmin()) {
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public AdminBean getAdminBean() {
		return AdminBean.instance;
	}

	public SalesforceSessionContext getSalesforceSessionContext() {
		return salesforceSessionContext;
	}

	public void setSalesforceSessionContext(
			SalesforceSessionContext salesforceSessionContext) {
		this.salesforceSessionContext = salesforceSessionContext;
	}

	public String getExistingLocationUrl() {
		return existingLocationUrl;
	}

	public void setExistingLocationUrl(String existingLocationUrl) {
		this.existingLocationUrl = existingLocationUrl;
	}

	public String getExistingSessionId() {
		return existingSessionId;
	}

	public void setExistingSessionId(String existingSessionId) {
		this.existingSessionId = existingSessionId;
	}
	
	public String getS() {
		return this.getExistingSessionId();
	}

	public String getU() {
		return this.getExistingLocationUrl();
	}
	
	public void setS(String s) {
		this.setExistingSessionId(s);
	}

	public void setU(String u) {
		this.setExistingLocationUrl(u);
	}
	
	
}
