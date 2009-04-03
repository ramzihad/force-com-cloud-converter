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

package com.modelmetrics.common.sforce;

import com.modelmetrics.common.spring.util.AbstractSpringObjectFactory;
import com.sforce.soap.partner.SoapBindingStub;


/**
 * SalesforceSessionFactory
 * @author Reid Carlberg rcarlberg@modelmetrics.com
 * @since May 17, 2007
 */

public class SalesforceSessionFactory extends AbstractSpringObjectFactory {

	public static final SalesforceSessionFactory factory = new SalesforceSessionFactory();
	
	/*
	 * returns whatever the current configured session is.
	 */
	public SalesforceSession build() {
	
		SalesforceSessionNewImpl ret = (SalesforceSessionNewImpl) this.getBean("salesforceSession");

		
		return ret;
		
	}
	
	

	
	public SalesforceSession build(SalesforceCredentials salesforceCredentials) {
		
		SalesforceSessionNewImpl ret = new SalesforceSessionNewImpl();
	
		ret.setSalesforceCredentials(salesforceCredentials);
		
		return ret;
		
	}	
	
	public SalesforceSession build(String existingSessionId, String existingSessionUrl) {
		
		SalesforceSessionExistingImpl ret = new SalesforceSessionExistingImpl(existingSessionId, existingSessionUrl);
		
		
		return ret;
		
	}
	
	public SalesforceSession build(SoapBindingStub soapBindingStub) {
		throw new RuntimeException("Reid is lazy & didn't implement");
	}
	
	/*
	 * 2007-06-25 rsc useful for testing.
	 */
	public SalesforceSession buildAlwaysFails() throws Exception {
		SalesforceSessionSimpleImpl ret = new SalesforceSessionSimpleImpl();
		ret.setSforce(new SoapBindStubAlwaysFailsImpl());
		
		return ret;
	}

	
	public SalesforceSession buildAlwaysSucceeds() throws Exception {
		SalesforceSessionSimpleImpl ret = new SalesforceSessionSimpleImpl();
		ret.setSforce(new SoapBindStubAlwaysSucceedsImpl());
		
		return ret;
		
	}

	
	/*
	 * 2007-06-25 rsc useful for testing.
	 */
	public SalesforceSession buildReturnsSingleMock() throws Exception {
		SalesforceSessionSimpleImpl ret = new SalesforceSessionSimpleImpl();
		ret.setSforce(new SoapBindingStubMockReturnsQueryImpl());
		
		return ret;
	}

}
