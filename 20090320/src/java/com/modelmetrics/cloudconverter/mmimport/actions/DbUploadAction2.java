package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.List;

import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.opensymphony.xwork2.ActionSupport;

public class DbUploadAction2 {

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

	public String getSfdcUsername() {
		return sfdcUsername;
	}

	public void setSfdcUsername(String sfdcUsername) {
		this.sfdcUsername = sfdcUsername;
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

	public String getDbTypeName() {
		return dbTypeName;
	}

	public void setDbTypeName(String dbTypeName) {
		this.dbTypeName = dbTypeName;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public String getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(String dbConnection) {
		this.dbConnection = dbConnection;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbSelect() {
		return dbSelect;
	}

	public void setDbSelect(String dbSelect) {
		this.dbSelect = dbSelect;
	}

	public List<String> getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(List<String> externalIds) {
		this.externalIds = externalIds;
	}

	public List<PicklistInfo> getPicklistInfos() {
		return picklistInfos;
	}

	public void setPicklistInfos(List<PicklistInfo> picklistInfos) {
		this.picklistInfos = picklistInfos;
	}

	public List<LookupSettings> getLookupSettings() {
		return lookupSettings;
	}

	public void setLookupSettings(List<LookupSettings> lookupSettings) {
		this.lookupSettings = lookupSettings;
	}


	public String execute() throws Exception {
	
		//validate();
		
		//connect to cloud converter script
		
		//execute
		
		return ActionSupport.SUCCESS;
	}
}
