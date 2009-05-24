package com.modelmetrics.common.util;

import com.modelmetrics.cloudconverter.forceutil.DeleteExecutor;
import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap.partner.DescribeGlobalResult;

public class TestCaseWithDevOrg extends TestCaseWithLog {

	protected SalesforceCredentials salesforceCredentials;

	protected String sampleSfdcUsername = "reid_carlberg@modelmetrics.com";

	protected String sampleSfdcPassword = "goody2shoes";

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
	
	protected void handleCustomObjectKill(String objectName) throws Exception {
		SalesforceSession salesforceSession = SalesforceSessionFactory.factory
				.build(salesforceCredentials);

		if (this.containsTestObject(salesforceSession, objectName)) {
			CustomObject co = new CustomObject();
			co.setFullName(objectName);

			new DeleteExecutor(salesforceSession.getMetadataService())
					.executeSimpleDelete(co);
		}

		log.debug("custom object killed.");
	}
	
	public boolean containsTestObject(SalesforceSession salesforceSession,
			String testObjectName) throws Exception {
		DescribeGlobalResult result = salesforceSession.getSalesforceService()
				.describeGlobal();

		boolean foundType = false;

		for (int i = 0; i < result.getTypes().length; i++) {
			String name = result.getTypes(i);
			if (name.equalsIgnoreCase(testObjectName)) {
				foundType = true;
			}
		}

		return foundType;
	}
}
