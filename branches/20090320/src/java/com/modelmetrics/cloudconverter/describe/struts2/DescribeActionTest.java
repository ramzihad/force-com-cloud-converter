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
package com.modelmetrics.cloudconverter.describe.struts2;

import com.modelmetrics.cloudconverter.common.struts2.UtilityContext;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;

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
		
		assertNull(action.getDescribeContext().getTypesArray());
		
		action.execute();
		
		assertNotNull(action.getDescribeContext().getTypesArray());
		
		assertNull(action.getObjectFields());
		
		action.setTarget("Account");
		
		action.execute();
		
		assertNotNull(action.getObjectFields());
		
		
	}
}
