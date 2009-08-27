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

import java.util.Iterator;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MockSproxyBuilderTest extends TestCase {

	private static Log log = LogFactory.getLog(MockSproxyBuilderTest.class);

	public void testBasic() throws Exception {

		Sproxy testSproxy = new MockSproxyBuilder()
				.build("Select Id, Name from Account");

		assertEquals(1, testSproxy.getValueKeys().size());

		assertNotNull(testSproxy);

		assertNotNull(testSproxy.getType());

		assertEquals("Account", testSproxy.getType());

		assertNotNull(testSproxy.getId());

		assertTrue(testSproxy.getValueKeys().contains("Name"));

		assertFalse(testSproxy.getValueKeys().contains("Id"));

	}

	public void testBasic2() throws Exception {

		Sproxy testSproxy = new MockSproxyBuilder()
				.build("Select Id, Name FROM Account");

		assertEquals(1, testSproxy.getValueKeys().size());

		assertNotNull(testSproxy);

		assertNotNull(testSproxy.getType());

		assertEquals("Account", testSproxy.getType());

		assertNotNull(testSproxy.getId());

		assertTrue(testSproxy.getValueKeys().contains("Name"));

		assertFalse(testSproxy.getValueKeys().contains("Id"));

	}

	public void testMessy() throws Exception {

		Sproxy sproxy = new MockSproxyBuilder()
				.build("Select Id , FirstName, LastName  from       Opportunity where id='123445656'");

		assertEquals(2, sproxy.getValueKeys().size());

		String[] template = {};

		String[] valuesKeys = sproxy.getValueKeys().toArray(template);

		assertEquals("FirstName", valuesKeys[0]);
		assertEquals("LastName", valuesKeys[1]);

		assertEquals("Opportunity", sproxy.getType());

	}

	public void testMessier() throws Exception {
		Sproxy sproxy = new MockSproxyBuilder()
				.build("Select Id,FirstName,LastName  from    Opportunity");

		assertEquals(2, sproxy.getValueKeys().size());

		String[] template = {};

		String[] valuesKeys = sproxy.getValueKeys().toArray(template);

		assertEquals("FirstName", valuesKeys[0]);
		assertEquals("LastName", valuesKeys[1]);

		assertEquals("Opportunity", sproxy.getType());
	}

	public void testMessy2() throws Exception {
		Sproxy sproxy = new MockSproxyBuilder()
				.build("Select a.AccountNumber, a.AnnualRevenue, a.BillingCity, a.BillingCountry, a.BillingPostalCode, "
						+ "a.BillingState, a.BillingStreet, a.CreatedById, a.CreatedDate, a.CustomerPriority__c, a.Description "
						+ "from Account a");

		assertEquals(11, sproxy.getValueKeys().size());

		String[] template = {};

		String[] valuesKeys = sproxy.getValueKeys().toArray(template);

		assertEquals("AccountNumber", valuesKeys[0]);

		assertEquals("Account", sproxy.getType());

		for (Iterator<String> iter = sproxy.getValueKeys().iterator(); iter
				.hasNext();) {
			String element = iter.next();
			log.info(element);

		}
	}

	public void testMessy3() throws Exception {
		Sproxy sproxy = new MockSproxyBuilder()
				.build("Select acct.AccountNumber, acct.AnnualRevenue, acct.BillingCity "
						+ "from Account acct");

		assertEquals(3, sproxy.getValueKeys().size());

		String[] template = {};

		String[] valuesKeys = sproxy.getValueKeys().toArray(template);

		assertEquals("AccountNumber", valuesKeys[0]);

		assertEquals(sproxy.getValueKeys().size(), 3);

		for (Iterator<String> iter = sproxy.getValueKeys().iterator(); iter
				.hasNext();) {
			String element = iter.next();
			assertFalse(element.startsWith("acct"));
			assertEquals(-1, element.indexOf("."));

		}
		assertEquals("Account", sproxy.getType());

		for (Iterator<String> iter = sproxy.getValueKeys().iterator(); iter
				.hasNext();) {
			String element = iter.next();
			log.info(element);

		}
	}

	public void testWithId() throws Exception {

		String soql = "Select Id, Name from Account where Id='123456'";

		Sproxy sproxy = MockSproxyBuilder.build(soql);

		assertEquals("123456", sproxy.getId());

	}

	public void testWithField() throws Exception {

		String soql = "Select Id, Name from Account where Name='Farhan'";

		Sproxy sproxy = MockSproxyBuilder.build(soql);

		assertEquals("Farhan", sproxy.getValue("Name"));

	}

	public void testWithFields() throws Exception {

		String soql = "Select Id, Name, BillingState from Account where Name='Farhan' and BillingState='MIfds'";

		Sproxy sproxy = MockSproxyBuilder.build(soql);

		assertEquals("Farhan", sproxy.getValue("Name"));
		assertEquals("MIfds", sproxy.getValue("BillingState"));
	}

	public void testWithFieldAndEscapedValue() throws Exception {

		// not to farhan -- make sure this works in ApexBuilder
		String soql = "Select Id, Name from Account where Name='O\'Mally'";

		Sproxy sproxy = MockSproxyBuilder.build(soql);

		assertEquals("O'Mally", sproxy.getValue("Name"));

	}

	public void testWithFieldAndEscapedValueAndSpaces() throws Exception {

		// not to farhan -- make sure this works in ApexBuilder
		String soql = "Select Id, Name from Account where Name = 'O\'Mally'";

		Sproxy sproxy = MockSproxyBuilder.build(soql);

		assertEquals("O'Mally", sproxy.getValue("Name"));

	}

	public void testBasicSplit() throws Exception {

		String soql = "Select Id, Name, BillingState from Account where Name = 'Farhan' and BillingState='MIfds'";

		String[] parts = soql.split("[ ,]");

		for (int i = 0; i < parts.length; i++) {
			log.info(parts[i]);
		}

	}

	public void testBasicQuotes() throws Exception {

		String ret = "'value'".trim();

		ret = ret.substring(1, ret.length() - 1);

		assertEquals("value", ret);

	}

}
