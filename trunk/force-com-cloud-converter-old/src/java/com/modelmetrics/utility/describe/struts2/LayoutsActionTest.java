package com.modelmetrics.utility.describe.struts2;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.modelmetrics.utility.common.struts2.UtilityContext;

public class LayoutsActionTest extends TestCaseWithDevOrg {

	public void testBasic() throws Exception {
//		SalesforceCredentials salesforceCredentials = new SalesforceCredentials();
//		salesforceCredentials.setPassword("blah1234");
//		salesforceCredentials.setUsername("reid_carlberg@modelmetrics.com");
//		salesforceCredentials
//				.setWsdlUrl("https://www.salesforce.com/services/Soap/u/14.0");

		SalesforceSession salesforceSession = SalesforceSessionFactory.factory
				.build(salesforceCredentials);

		SalesforceSessionContext salesforceSessionContext = new SalesforceSessionContext();
		salesforceSessionContext.setSalesforceSession(salesforceSession);
		
		UtilityContext utilityContext = new UtilityContext();
//		utilityContext.setSalesforceSession(salesforceSession);

		LayoutsAction action = new LayoutsAction();
		action.setUtilityContext(utilityContext);
		action.setDescribeContext(new DescribeContext());

		action.setTarget("Account");

		action.execute();
		
		assertTrue(action.getRows() != null);

	}

}
