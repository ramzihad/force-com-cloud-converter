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
