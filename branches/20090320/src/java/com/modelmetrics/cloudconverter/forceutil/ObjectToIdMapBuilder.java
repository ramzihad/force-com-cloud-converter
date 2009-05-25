package com.modelmetrics.cloudconverter.forceutil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

public class ObjectToIdMapBuilder {

	public Map<String, List<String>> getMap(SalesforceSession salesforceSession) throws Exception {
		
		Map<String, List<String>> ret = new HashMap<String, List<String>>();
		
		DescribeGlobalResult describeGlobalResult = salesforceSession.getSalesforceService().describeGlobal();
		
		for (String current:describeGlobalResult.getTypes()) {
			if (this.include(current)) {
				ret.put(current, new ArrayList<String>());
			}
		}
		
		for (String current:ret.keySet()) {
			DescribeSObjectResult describeSObjectResult = salesforceSession.getSalesforceService().describeSObject(current);
			
			for(Field currentField:describeSObjectResult.getFields()) {
				if (currentField.getName().equalsIgnoreCase("id")) {
					ret.get(current).add(currentField.getName());
				} else if (currentField.getExternalId() != null && currentField.getExternalId().booleanValue()) {
					ret.get(current).add(currentField.getName());
				}
			}
		}
		
		return ret;
		
	}
	
	/*
	 * stolen from DataLoader 13 THANKS LEXI!
	 */
	public boolean include(String entityName) {
        /*
         * Account Case Contact Event Lead Opportunity Pricebook2 Product2 Task User Custom Objects
         */
        if (entityName.equals("Account") || entityName.equals("Case") || entityName.equals("Contact")
                || entityName.equals("Event") || entityName.equals("Lead") || entityName.equals("Opportunity")
                || entityName.equals("Pricebook2") || entityName.equals("Product2") || entityName.equals("Task")
                || entityName.equals("User")) {
            return true;
        } else if (entityName.endsWith("__c")) {
            return true;
        }
        return false;
	}
	
	
}
