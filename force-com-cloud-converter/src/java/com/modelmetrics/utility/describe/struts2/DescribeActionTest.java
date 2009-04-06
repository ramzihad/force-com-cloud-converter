package com.modelmetrics.utility.describe.struts2;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.modelmetrics.utility.common.struts2.UtilityContext;

public class DescribeActionTest extends TestCaseWithDevOrg {

	public void testBasic() throws Exception {
		
		
		SalesforceSession salesforceSession = SalesforceSessionFactory.factory.build(salesforceCredentials);
		
		SalesforceSessionContext salesforceSessionContext = new SalesforceSessionContext();
		salesforceSessionContext.setSalesforceSession(salesforceSession);
		
		UtilityContext describeContext = new UtilityContext();
//		describeContext.setSalesforceSession(salesforceSession);
		
		DescribeAction action = new DescribeAction();
		action.setUtilityContext(describeContext);
		
		action.setDescribeContext(new DescribeContext());
		
		action.setSalesforceSessionContext(salesforceSessionContext);
		
		assertNull(action.getDescribeContext().getTypes());
		
		action.execute();
		
		assertNotNull(action.getDescribeContext().getTypes());
		
		assertNull(action.getResults());
		
		action.setTarget("Account");
		
		action.execute();
		
		assertNotNull(action.getResults());
		
		
	}
}
