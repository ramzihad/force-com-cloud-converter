package com.modelmetrics.cloudconverter;

import com.modelmetrics.cloudconverter.forceutil.DeleteExecutor;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

/**
 * Test exercises default cloud converter script against a sample database -- there are a few
 * items that are hard coded and will need to be changed when the source data changes.
 * 
 * @author reidcarlberg
 *
 */
public class CloudConverterScriptTest extends TestCaseWithDevOrg {


	private String sampleObject = "mytable__c";

	@Override
	protected void setUp() throws Exception {

		log.debug("starting setup");

		super.setUp();

		this.handleCustomObjectKill(this.sampleObject);

		log.debug("setup complete");

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();

		log.debug("starting clean up");

		//this.handleCustomObjectKill(this.sampleObject);

		log.debug("clean up complete");
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

	}

	public void testCreatesObject() throws Exception {

		CloudConverterScript script = new CloudConverterScript();

		SalesforceSession salesforceSession = SalesforceSessionFactory.factory
				.build(salesforceCredentials);

		script.execute(salesforceCredentials.getUsername(),
				salesforceCredentials.getPassword());

		// bouncing the session
		salesforceSession = SalesforceSessionFactory.factory
				.build(salesforceCredentials);

		assertTrue(this
				.containsTestObject(salesforceSession, this.sampleObject));

		DescribeSObjectResult describeSObjectResult = salesforceSession
				.getSalesforceService().describeSObject(this.sampleObject);

		log.info("Field size returned: "
				+ describeSObjectResult.getFields().length);

		// verify that they're the ones I expect based on the sample database
		assertTrue(describeSObjectResult.getFields().length == 18);

		for (int i = 0; i < describeSObjectResult.getFields().length; i++) {
			Field field = describeSObjectResult.getFields(i);

			log.debug("field " + field.getName());

			if (field.getName().equalsIgnoreCase("mypicklist__c")) {
				assertTrue(field.getPicklistValues().length == 5);
			} else if (field.getName().equalsIgnoreCase("myid__c")) {
				assertTrue(field.getExternalId().booleanValue());
			}
		}

		// good enough time to clean up
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
