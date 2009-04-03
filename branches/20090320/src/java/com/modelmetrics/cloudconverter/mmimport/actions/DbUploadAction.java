package com.modelmetrics.cloudconverter.mmimport.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;

public class DbUploadAction extends AbstractUploadContextAware implements ServletRequestAware {

	private static final long serialVersionUID = 6218725685999955325L;

	private static final Logger log = Logger.getLogger(DbUploadAction.class);

	private SalesforceService salesforceService;

	private String password;

	private String username;

	private String dbUser;

	private String dbPassword;

	private String dbUrl;

	private String dbName;

	private String dbTable;

	private String externalIds;

	private String lookupFields;

	private String picklistFields;

	private Boolean override;
	
	private HttpServletRequest request;

	/**
	 * initializes form input page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String init() throws Exception {

		return INPUT;
	}

	/**
	 * reads a DB table and generates an object to be sent to salesforce view
	 * 
	 * @return
	 */
	public String generate() {

		try {

			validateData();

			/*
			 * let's check the username and password if there were no validation
			 * errors
			 */
			if (getActionMessages().isEmpty()) {
				try {
					this.getSalesforceSessionContext()
							.setSalesforceCredentials(this.getUsername(),
									this.getPassword());
				} catch (Exception e) {

					addActionMessage("Could not initialize your Salesforce session.  You might need your security token.");
				}
			}

			/*
			 * failed?
			 */
			if (!getActionMessages().isEmpty()) {
				return INPUT;
			}

			salesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());
			
			String realPath = request.getSession().getServletContext().getRealPath("/");
			salesforceService.generateObjectFromDB(this, realPath);
			log.info("Object sent successfully");

			return SUCCESS;
		} catch (Exception e) {
			message = "There has been a problem generating salesforce objects";
			log.error(message, e);
			addActionMessage(e.getMessage());
			return ERROR;
		}
	}

	private void validateData() {

		if ("".equals(username)) {
			addActionMessage("Username is required");
		}
		if ("".equals(password)) {
			addActionMessage("Password is required");
		}
		if ("".equals(dbName)) {
			addActionMessage("Database name is required");
		}
		if ("".equals(dbUser)) {
			addActionMessage("Database user is required");
		}
		if ("".equals(dbUrl)) {
			addActionMessage("Database url is required");
		}
		if ("".equals(dbTable)) {
			addActionMessage("Database table is required");
		}
		if ("".equals(externalIds)) {
			addActionMessage("You must enter at least one external id");
		}
		if ("".equals(lookupFields)) {
			addActionMessage("You must enter at least one lookup field");
		}
		if ("".equals(picklistFields)) {
			addActionMessage("You must enter at least one picklist field");
		}
		if (externalIds.split(",|;").length > 3) {
			addActionMessage("You cannot enter more than 3 Id´s");
		}

	}

	public Boolean getOverride() {
		return override;
	}

	public void setOverride(Boolean override) {
		this.override = override;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SalesforceService getSalesforceService() {
		return salesforceService;
	}

	public void setSalesforceService(SalesforceService salesforceService) {
		this.salesforceService = salesforceService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbTable() {
		return dbTable;
	}

	public void setDbTable(String dbTable) {
		this.dbTable = dbTable;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(String externalIds) {
		this.externalIds = externalIds;
	}

	public String getLookupFields() {
		return lookupFields;
	}

	public void setLookupFields(String lookupFields) {
		this.lookupFields = lookupFields;
	}

	public String getPicklistFields() {
		return picklistFields;
	}

	public void setPicklistFields(String picklistFields) {
		this.picklistFields = picklistFields;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
		
	}

}
