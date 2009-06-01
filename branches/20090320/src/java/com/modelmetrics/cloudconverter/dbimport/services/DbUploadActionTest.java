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
package com.modelmetrics.cloudconverter.dbimport.services;

import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.mmimport.services.PicklistInfo;
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
