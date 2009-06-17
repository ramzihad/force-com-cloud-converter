package com.modelmetrics.cloudconverter.tests;

import java.util.Collection;

import ognl.Ognl;

import com.modelmetrics.cloudconverter.describe.SobjectFieldPropertyBean;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.PicklistEntry;

public class OgnlFinderTest extends TestCaseWithDevOrg {

	public void testBasic() throws Exception {
		
		SalesforceSession salesforceSession = SalesforceSessionFactory.factory.build(this.salesforceCredentials);
		
		DescribeSObjectResult describeSObjectResult = salesforceSession.getSalesforceService().describeSObject("Contact");
		
		Collection<SobjectFieldPropertyBean> beans = SobjectFieldPropertyBean.getFieldBeans();
		
		int i = 0;
		
		for (Field element : describeSObjectResult.getFields()) {

			
			i= 0;
			
			for (SobjectFieldPropertyBean current : beans) {
				
				Object o = null;
				try {
				o = Ognl.getValue(current.getName(), element);
				
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				

				log.info("key: " + current.getName() + " retreived value: " + o);
				
				if (o instanceof PicklistEntry[]) {
					log.info("Picklist entry!");
					PicklistEntry[] pe = (PicklistEntry[]) o;
					for (PicklistEntry currentPicklistEntry : pe) {
						log.info("pe: " + currentPicklistEntry.getValue());
					}
				}
				
				if (o instanceof String[]) {
					log.info("String!");
					String[] pe = (String[]) o;
					for (String currentPicklistEntry : pe) {
						log.info("ref to: " + currentPicklistEntry);
					}
				}
			}
		}
		
	}
}
