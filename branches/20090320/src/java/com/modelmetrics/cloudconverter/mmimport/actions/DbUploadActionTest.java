package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.mmimport.services.DbSalesforceServiceImpl;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.opensymphony.xwork2.ActionSupport;

public class DbUploadActionTest  extends TestCaseWithDevOrg {
	
	public void testBasicDbConnection() throws Exception {

		DbUploadAction action = new DbUploadAction();

		// sfdc
		action.setSfdcUsername(this.sampleSfdcUsername);
		action.setSfdcPassword(this.sampleSfdcPassword);
//		action.setSfdcPassword("police78");
//		action.setSfdcSecurityToken("VAwrqZKkqcEGyTYO7LhNu1CV");

		// db
		action.setDbTypeName("derby");

		action.setDbDriver("org.apache.derby.jdbc.EmbeddedDriver");

		action.setDbConnection("jdbc:derby:./src/sampledbs/derby/sample2");

		action.setDbUser("sa");

		action.setDbPassword("");

		action.setDbSelect("Select * from mytable");

		// special fields
		action.getExternalIds().add("MYID");

		action.getPicklistInfos().add(
				new PicklistInfo("MYPICKLIST",
						"select distinct mypicklist from mytable"));

		action.getLookupSettings().add(
				new LookupSettings("MYTABLE", "MYTABLE__r", "AAA__c",
						"TestExternalId__c"));

		
		DbSalesforceServiceImpl salesforceServiceImpl = new DbSalesforceServiceImpl();
		action.setDbSalesforceService(salesforceServiceImpl);
		SalesforceSessionContext context = new SalesforceSessionContext();
		
		action.setSalesforceSessionContext(context);
		String s = action.generate();
		assertEquals(ActionSupport.SUCCESS, s);

	}
}
