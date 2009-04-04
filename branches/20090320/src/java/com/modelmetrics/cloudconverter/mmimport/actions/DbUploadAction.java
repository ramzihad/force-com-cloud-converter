package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.mmimport.services.DbSalesforceService;

public class DbUploadAction extends AbstractUploadContextAware implements
		ServletRequestAware {

	private static final long serialVersionUID = 6218725685999955325L;

	private static final Logger log = Logger.getLogger(DbUploadAction.class);

	private DbSalesforceService dbSalesforceService;

	//sfdc connection information -- same as before
	private String sfdcUsername;
	
	private String sfdcPassword;
	
	private String sfdcSecurityToken;
	
	//database credentials information
	private String dbTypeName; //"derby" -- name internal to CloudConverter
	
	private String dbDriver; //"org.apache.derby.jdbc.EmbeddedDriver" -- Fully qualified JDBC driver name
	
	private String dbConnection; //"jdbc:derby:./src/sampledbs/derby/sample2" -- Fully qualified JDBC connection string
	
	private String dbUser; //"sa" 
	
	private String dbPassword; //""
	
	private String dbSelect; //"Select * from mytable" -- since this could be a very complex select string, I want people to be able to enter whatever they want.

	//special fields
	/*
	 * note in struts2, I **think** these can be either arrays or Lists.  You probably want to check the documentation on that.
	 */
	private List<String> externalIds = new ArrayList<String>(); //not required, no more than three allowed.
	
	private List<PicklistInfo> picklistInfos = new ArrayList<PicklistInfo>(); //not required -- this new object is to illustrate the info I want
	
	private List<LookupSettings> lookupSettings = new ArrayList<LookupSettings>(); //not required -- this new object is to illustrate what I want


	private HttpServletRequest request;

	/**
	 * initializes form input page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String init() throws Exception {

		
		externalIds.add("");
		externalIds.add("");
		externalIds.add("");
		
		picklistInfos.add(new PicklistInfo());
		picklistInfos.add(new PicklistInfo());
		picklistInfos.add(new PicklistInfo());
		
		lookupSettings.add(new LookupSettings());
		lookupSettings.add(new LookupSettings());
		lookupSettings.add(new LookupSettings());
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
							.setSalesforceCredentials(sfdcUsername,
									sfdcPassword+sfdcSecurityToken);
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

			dbSalesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());

			//This has to be done this way otherwise the server does not see the folder inside web-inf
			String realPath = request.getSession().getServletContext()
					.getRealPath("/");
			String dbUrl = "jdbc:derby:";
			dbUrl += realPath + "sampledbs/";
			dbUrl += this.getDbConnection();
			
			
			dbSalesforceService.generateObjectFromDB(this, dbUrl);
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

		if ("".equals(sfdcUsername)) {
			addActionMessage("Username is required");
		}
		if ("".equals(sfdcPassword)) {
			addActionMessage("Password is required");
		}
		if ("".equals(dbTypeName)) {
			addActionMessage("Database type name is required");
		}
		if ("".equals(dbUser)) {
			addActionMessage("Database user is required");
		}
		if ("".equals(dbDriver)) {
			addActionMessage("Database driver is required");
		}
		if ("".equals(dbConnection)) {
			addActionMessage("Database connection is required");
		}
		

	}


	public String getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(String dbConnection) {
		this.dbConnection = dbConnection;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public String getDbSelect() {
		return dbSelect;
	}

	public void setDbSelect(String dbSelect) {
		this.dbSelect = dbSelect;
	}

	public String getDbTypeName() {
		return dbTypeName;
	}

	public void setDbTypeName(String dbTypeName) {
		this.dbTypeName = dbTypeName;
	}

	public List<String> getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(List<String> externalIds) {
		this.externalIds = externalIds;
	}

	public List<LookupSettings> getLookupSettings() {
		return lookupSettings;
	}

	public void setLookupSettings(List<LookupSettings> lookupSettings) {
		this.lookupSettings = lookupSettings;
	}

	public List<PicklistInfo> getPicklistInfos() {
		return picklistInfos;
	}

	public void setPicklistInfos(List<PicklistInfo> picklistInfos) {
		this.picklistInfos = picklistInfos;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getSfdcPassword() {
		return sfdcPassword;
	}

	public void setSfdcPassword(String sfdcPassword) {
		this.sfdcPassword = sfdcPassword;
	}

	public String getSfdcSecurityToken() {
		return sfdcSecurityToken;
	}

	public void setSfdcSecurityToken(String sfdcSecurityToken) {
		this.sfdcSecurityToken = sfdcSecurityToken;
	}

	public String getSfdcUsername() {
		return sfdcUsername;
	}

	public void setSfdcUsername(String sfdcUsername) {
		this.sfdcUsername = sfdcUsername;
	}


	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}



	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}



	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;

	}

	public DbSalesforceService getDbSalesforceService() {
		return dbSalesforceService;
	}

	public void setDbSalesforceService(DbSalesforceService dbSalesforceService) {
		this.dbSalesforceService = dbSalesforceService;
	}

}
