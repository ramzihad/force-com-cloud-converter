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

package com.modelmetrics.common.sforce.dao;
import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;

public class SalesforceDAOTest extends TestCase {

	private static Log log = LogFactory.getLog(SalesforceDAOTest.class);
	
	public void testQuerySingle() throws Exception 
	{
		SalesforceDAO dao = new SalesforceDAO();
		dao.setSalesforceSession(SalesforceSessionFactory.factory.buildReturnsSingleMock());
		Sproxy returnedSproxy = dao.querySingle("Select Id, Name from Account where Id='123456'");
		assertEquals("123456", returnedSproxy.getId());
	}
	
	public void testBasicSucceeds() throws Exception {
		
		//first construct a mock salesforce session
		SalesforceSession succeeds = SalesforceSessionFactory.factory.buildAlwaysSucceeds();
		
		//build a salesforce dao with the mock session
		SalesforceDAO dao = new SalesforceDAO();
		dao.setSalesforceSession(succeeds);
		
		//second construct a sample sproxy object -- can be garbage values
		// Sproxy sampleSproxy = SproxySampleFactory.build();
		Sproxy sampleSproxy = MockSproxyBuilder.build("Select Id, Name from Account where Id='123456'");
		
		
		//use the dao to save the sproxy
		Sproxy returnedSproxy = dao.save(sampleSproxy);
		
		assertEquals("123456", returnedSproxy.getId());
		
		
	}

	public void testBasicFails() throws Exception {
		boolean ifSucceeds = true;
		//first construct a mock salesforce session
		SalesforceSession fails = SalesforceSessionFactory.factory.buildAlwaysFails();
		
		//build a salesforce dao with the mock session
		SalesforceDAO dao = new SalesforceDAO();
		dao.setSalesforceSession(fails);
		
		//second construct a sample sproxy object -- can be garbage values
		Sproxy sampleSproxy = MockSproxyBuilder.build("Select Id, Name from Account where Id='123456'");
		
		//use the dao to save it and make sure the save operation fails.
		try{
			Sproxy returnedSproxy = dao.save(sampleSproxy);
		}
		
		catch(Exception e)
		{
			assertTrue(true);
			ifSucceeds = false;
		}
		
		if (ifSucceeds == true)
		{
			assertTrue(false);
		}
		// Sproxy returnedSproxy = dao.saveOrUpdate(sampleSproxy);
		// assertEquals("123456", returnedSproxy.getId());
		
		
	}

	
//	public void testWithLiveSession() throws Exception 
//	{
//		//salesforce session should be real, use your dev org.
//
//		SalesforceCredentials credentials = new SalesforceCredentials();
//		credentials.setUsername("farhan.karim@modelmetrics.com");
//		credentials.setPassword("farhan");
////		credentials.setWsdlUrl("https://na4.salesforce.com/soap/wsdl.jsp");
//		credentials.setWsdlUrl("https://www.salesforce.com/services/Soap/u/9.0");
//		SalesforceSession realSession = new SalesforceSessionFactory().build(credentials);
//
//		SalesforceDAO dao = new SalesforceDAO();
//		dao.setSalesforceSession(realSession);
//
//		SObject realSObject = new SObject();
//		realSObject.setType("Account");
//
//		// Sproxy sample1 = SproxySampleFactory.build();
//
//		// Sproxy realSproxy = MockSproxyBuilder.build("Select Id, Name from Account where Name = 'lkfdcsd'");
//
//		// realSproxy.setValue("Id", "0016000000GM5ujAAD");
//		Sproxy sampleSproxy = SproxySampleFactory.build();
//		sampleSproxy.setValue("Name", "Whazzaaaaaaaaa");
//		Sproxy returnedSproxy = dao.save(sampleSproxy);
//		log.info(returnedSproxy.getId());
//		assertEquals("Account", returnedSproxy.getType());
//
//
//
//		// SalesforceSessionFactory.build(credentials);
//
//
//		//sproxy cannot be garbage values.
//
//	}
}
