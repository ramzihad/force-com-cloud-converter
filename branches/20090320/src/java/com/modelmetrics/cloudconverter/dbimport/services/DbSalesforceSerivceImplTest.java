package com.modelmetrics.cloudconverter.dbimport.services;

import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.mmimport.services.PicklistInfo;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;

public class DbSalesforceSerivceImplTest extends TestCaseWithDevOrg {

	public void testGenerateObjectFromDB() {
		DbUploadAction action = new DbUploadAction();

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
		try {
			DbSalesforceServiceImpl salesforceServiceImpl = new DbSalesforceServiceImpl();
			SalesforceSessionContext context = new SalesforceSessionContext();
			context.setSalesforceCredentials(this.sampleSfdcUsername,
					this.sampleSfdcPassword);
			salesforceServiceImpl.setSalesforceSession(context
					.getSalesforceSession());

			salesforceServiceImpl.generateObjectFromDB(action);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
}
