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
package com.modelmetrics.cloudconverter.tests;

import com.modelmetrics.cloudconverter.common.struts2.UtilityContext;
import com.modelmetrics.cloudconverter.describe.struts2.DescribeContext;
import com.modelmetrics.cloudconverter.describe.struts2.SelectObjectAction;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.opensymphony.xwork2.ActionSupport;

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
