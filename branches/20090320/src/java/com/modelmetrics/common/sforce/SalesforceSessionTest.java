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

import junit.framework.TestCase;

import org.apache.axis.message.MessageElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;

/**
 * SalesforceSessionTest
 * @author Reid Carlberg rcarlberg@modelmetrics.com
 * @since May 21, 2007
 */

public class SalesforceSessionTest extends TestCase {

	private Log log = LogFactory.getLog(SalesforceSessionTest.class);
	
	/*
	 * 2006-06-07 RSC  Just logging isn't great -- but this shows how it works.
	 * If this we an actual test, we'd want to get everything setup with programatic value testing, etc.
	 * 
	 */
	public void testNewSession() throws Exception {
		
		
		log.info("post login");
		
		SalesforceSession salesforceSession = new SalesforceSessionFactory().build();
		
		QueryResult qr = salesforceSession.getSalesforceService().query("select Id, Name from Account");
		
		for (int i = 0; i < qr.getSize(); i++) {
			SObject so = qr.getRecords(i);
			log.info("i " + i + ": " + so.getType() + ": " );
			for (int j = 0; j < so.get_any().length; j++) {
				MessageElement me = so.get_any()[j];
				log.info("j " + j + ": " + me.getValue());
			}
		}
		
		log.info("record count: " + qr.getSize());
		
	}
	
}
