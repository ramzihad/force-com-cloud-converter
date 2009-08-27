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
package com.modelmetrics.cloudconverter.describe;

import java.util.Iterator;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;

public class LayoutsBuilderV2Test extends TestCase {

	private Log log = LogFactory.getLog(LayoutsBuilderV2Test.class);

	public void testBasic() throws Exception {

		SalesforceCredentials cred = new SalesforceCredentials();
		cred.setPassword("blah1234");
		cred.setUsername("reid_carlberg@modelmetrics.com");
		SalesforceSession salesforceSession = SalesforceSessionFactory.factory
				.build(cred);

		LayoutsBuilderV2 builder = new LayoutsBuilderV2();
		LayoutsSummary summary=builder.execute(salesforceSession, "AAA__c");
		
		int size = 0;
		
		for (Iterator iter = summary.getRows().iterator(); iter.hasNext();) {
			LayoutsFieldVOV2 element = (LayoutsFieldVOV2) iter.next();
			
			if (size == 0) {
				size = element.getLayouts().size();
			}
			
			assertEquals(size, element.getLayouts().size());
			
			assertEquals(size, summary.getHeaders().size());
		}

		

	}
	
//	public void testMapping() throws Exception {
//		
//		SalesforceCredentials cred = new SalesforceCredentials();
//		cred.setPassword("blah1234");
//		cred.setUsername("reid_carlberg@modelmetrics.com");
//		SalesforceSession salesforceSession = SalesforceSessionFactory.factory
//				.build(cred);
//
//		LayoutsBuilderV2 builder = new LayoutsBuilderV2();
//		builder.execute(salesforceSession, "AAA__c");
//
//		Map<String, Collection<String>> fieldToMapping = builder.getFieldsToRecordTypes();
//		
//		for (Iterator iter = fieldToMapping.keySet().iterator(); iter.hasNext();) {
//			String element = (String) iter.next();
//			
//			log.info("element: " + element);
//			
//			Collection<String> types = fieldToMapping.get(element);
//			
//			for (Iterator iterator = types.iterator(); iterator.hasNext();) {
//				String type = (String) iterator.next();
//				
//				log.info("type: " + type);
//			}
//		}
//		
//	}
}
