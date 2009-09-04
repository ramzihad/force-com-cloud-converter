package com.modelmetrics.cloudconverter.common.struts2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.admin.AdminBean;
import com.modelmetrics.cloudconverter.describe.struts2.AbstractDescribeContextAware;

public class CompositeLoginAction extends AbstractDescribeContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Log log = LogFactory.getLog(CompositeLoginAction.class);

	private String existingLocationUrl;
	private String existingSessionId;



	public String getExistingLocationUrl() {
		return existingLocationUrl;
	}

	public String getExistingSessionId() {
		return existingSessionId;
	}



	public void setExistingLocationUrl(String username) {
		this.existingLocationUrl = username;
	}

	public void setExistingSessionId(String password) {
		this.existingSessionId = password;
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

	/**
	 * initializes form input page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {

		boolean error = false;

		// if (this.getSalesforceSessionContext().getSalesforceSession() !=
		// null) {
		// return SUCCESS;
		// }

		if ("".equals(this.getExistingLocationUrl())) {
			addActionMessage("locationUrl is required");
			error = true;
		}
		if ("".equals(this.getExistingSessionId())) {
			addActionMessage("Session Id is required");
			error = true;
		}

		/*
		 * 2009-09-03
		 */
		if (!this
				.getExistingLocationUrl()
				.matches(
						"https://[^/]+\\.(sales|visual\\.)force\\.com/services/(S|s)(O|o)(A|a)(P|p)/(u|c)/.*")) {
			addActionMessage("Location URL is invalid.");
			error = true;
		}

		if (error) {
			return ERROR;
		}

		/*
		 * let's check the session id and location url
		 */
		try {
			// RSC 2009-05-29 cleans out session. useful when switching back and
			// forth between orgs in the same browser.
			this.getSalesforceSessionContext().setSalesforceSession(null);

			this.getSalesforceSessionContext().setSalesforceExistingSession(
					this.getExistingSessionId(), this.getExistingLocationUrl());

			log.info("salesforce existing session null??");
			log.info(this.getSalesforceSessionContext() == null);

			log.info("utility context id " + this.getUtilityContext());

			this.getSalesforceSessionContext().setUserInfo(
					this.getSalesforceSessionContext().getSalesforceSession()
							.getSalesforceService().getUserInfo());
			
			AdminBean.instance.addUser(this.getSalesforceSessionContext().getUserInfo());

		} catch (Exception e) {

			// this.getUtilityContext().setLastException(e);
			error = true;
			addActionMessage("Could not initialize your Salesforce session.  (Existing URL or Session ID invalid");
		}

		if (error)
			return ERROR;

		return SUCCESS;
	}



}
