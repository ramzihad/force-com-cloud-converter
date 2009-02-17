package com.modelmetrics.cloudconverter;

import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.util.TestCaseWithLog;

public class TestCaseWithDevOrg extends TestCaseWithLog {

	protected SalesforceCredentials salesforceCredentials;

	protected String sampleSfdcUsername = "reid_carlberg@modelmetrics.com";

	protected String sampleSfdcPassword = "";

	private String sampleObject = "mytable__c";

	@Override
	protected void setUp() throws Exception {

		log.debug("starting setup");

		// TODO Auto-generated method stub
		super.setUp();

		salesforceCredentials = new SalesforceCredentials();
		salesforceCredentials.setUsername(this.sampleSfdcUsername);
		salesforceCredentials.setPassword(this.sampleSfdcPassword);


		log.debug("setup complete");

	}
}
