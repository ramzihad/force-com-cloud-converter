package com.modelmetrics.utility.describe;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.sforce.soap.partner.Field;

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
