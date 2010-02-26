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

import com.modelmetrics.cloudconverter.util.OperationStatusPublisherSupport;
import com.modelmetrics.cloudconverter.util.OperationStatusSubscriber;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeGlobalSObjectResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

public class ObjectToIdMapBuilder {

	private Map<String, List<String>> objectToIdMap;
	
	private Map<String, List<String>> objectToFieldMap;

	private OperationStatusPublisherSupport operationStatusPublisherSupport;


	public void build(SalesforceSession salesforceSession) throws Exception {
		
		Map<String, List<String>> objectToIdMap = new HashMap<String, List<String>>();
		
		Map<String, List<String>> objectToFieldMap = new HashMap<String, List<String>>();
		
		DescribeGlobalResult describeGlobalResult = salesforceSession.getSalesforceService().describeGlobal();
		
		this.getOperationStatusPublisherSupport().publishStatus("Refreshing metadata target list.");
		
		for (DescribeGlobalSObjectResult current:describeGlobalResult.getSobjects()) {
			if (this.include(current.getName())) {
				objectToIdMap.put(current.getName(), new ArrayList<String>());
				objectToFieldMap.put(current.getName(), new ArrayList<String>());
			}
		}
		
		for (String current:objectToIdMap.keySet()) {
			
			this.getOperationStatusPublisherSupport().publishStatus("Refreshing metadata for " + current + ".");
			
			DescribeSObjectResult describeSObjectResult = salesforceSession.getSalesforceService().describeSObject(current);
			
			for(Field currentField:describeSObjectResult.getFields()) {
				//object to Id map
				if (currentField.getName().equalsIgnoreCase("id")) {
					objectToIdMap.get(current).add(currentField.getName());
				} else if (currentField.getExternalId() != null && currentField.getExternalId().booleanValue()) {
					objectToIdMap.get(current).add(currentField.getName());
				}
				//object to Field map
				if (currentField.isUpdateable()) {
					objectToFieldMap.get(current).add(currentField.getName());
				}
			}
		}
		
		this.setObjectToIdMap(objectToIdMap);
		
		this.setObjectToFieldMap(objectToFieldMap);
		
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

	public Map<String, List<String>> getObjectToIdMap() {
		return objectToIdMap;
	}

	public void setObjectToIdMap(Map<String, List<String>> objectToIdMap) {
		this.objectToIdMap = objectToIdMap;
	}

	public Map<String, List<String>> getObjectToFieldMap() {
		return objectToFieldMap;
	}

	public void setObjectToFieldMap(Map<String, List<String>> objectToFieldMap) {
		this.objectToFieldMap = objectToFieldMap;
	}


	public OperationStatusPublisherSupport getOperationStatusPublisherSupport() {
		return operationStatusPublisherSupport;
	}

	public void setOperationStatusPublisherSupport(
			OperationStatusPublisherSupport operationStatusPublisherSupport) {
		this.operationStatusPublisherSupport = operationStatusPublisherSupport;
	}
	
}
