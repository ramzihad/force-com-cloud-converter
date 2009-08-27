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

import com.sforce.soap.partner.sobject.SObject;

public class SproxyBuilderTest extends TestCase {

	/*
	 * tests a simple object build.
	 */
	public void testBasic() throws Exception {
		
		SObject sample = SobjectSampleFactory.build();
		
		Sproxy object = new SproxyBuilder().build(sample);
		
		assertNotNull(object.getType());
		
		assertEquals(SobjectSampleFactory.TYPE, object.getType());
		
	}
	
	
	/*
	 * 2007-06-26 comment out if we don't need to use live data
	 */
//	public void testWithDevOrg() throws Exception {
//		
//		SalesforceSession session = SalesforceSessionFactory.factory.build();
//		
//		QueryResult qr = session.getSforce().query("select Id, Name from Account");
//		
//		SObject so = qr.getRecords(0);
//
//		SalesforceObject object = new SalesforceObjectBuilder().build(so);
//		
//		assertNotNull(object);
//		
//		assertNotNull(object.getTypeName());
//		
//		assertNotNull(object.getSalesforceId());
//		
//		assertEquals("Account", object.getTypeName());
//		
//		assertTrue(object.getMap().containsKey("Name"));
//		
//		assertFalse(object.getMap().containsKey("Id"));
//		
//	}
}
