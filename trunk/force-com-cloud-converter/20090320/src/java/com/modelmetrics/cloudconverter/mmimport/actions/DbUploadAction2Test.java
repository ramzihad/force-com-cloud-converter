package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.opensymphony.xwork2.ActionSupport;

public class DbUploadAction2Test extends TestCaseWithDevOrg {

	public void testBasicDbConnection() throws Exception {
		
		DbUploadAction2 action = new DbUploadAction2();
		
		//sfdc
		action.setSfdcUsername(this.sampleSfdcUsername);
		
		action.setSfdcPassword(this.sampleSfdcPassword);
		
		//db
		action.setDbTypeName("derby");
		
		action.setDbDriver("org.apache.derby.jdbc.EmbeddedDriver");
		
		action.setDbConnection("jdbc:derby:./src/sampledbs/derby/sample2");
		
		action.setDbUser("sa");
		
		action.setDbPassword("");
		
		action.setDbSelect("Select * from mytable");
		
		//special fields
		action.getExternalIds().add("MYID");
		
		action.getPicklistInfos().add(new PicklistInfo("MYPICKLIST",
				"select distinct mypicklist from mytable"));
		
		action.getLookupSettings().add(new LookupSettings("MYTABLE", "MYTABLE__r", "AAA__c", "TestExternalId__c"));
		
		String s = action.execute();
		
		assertEquals(ActionSupport.SUCCESS, s);
		
	}
}
