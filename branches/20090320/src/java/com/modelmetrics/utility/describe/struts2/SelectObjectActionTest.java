package com.modelmetrics.utility.describe.struts2;

import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.modelmetrics.utility.common.struts2.UtilityContext;
import com.opensymphony.xwork2.ActionSupport;

import junit.framework.TestCase;

public class SelectObjectActionTest extends TestCaseWithDevOrg {

	public void testBasic() throws Exception {

		SelectObjectAction action = new SelectObjectAction();

		action.setDescribeContext(new DescribeContext());

		action.setUtilityContext(new UtilityContext());
		
		SalesforceSessionContext salesforceSessionContext = new SalesforceSessionContext();
		salesforceSessionContext.setSalesforceSession(new SalesforceSessionFactory()
		.build(this.salesforceCredentials));
		
		action.setSalesforceSessionContext(salesforceSessionContext)
				;
		
		String s = action.execute();
		
		assertEquals(ActionSupport.INPUT, s);
	}
}
