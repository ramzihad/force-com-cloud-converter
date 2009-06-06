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
package com.modelmetrics.cloudconverter.compare;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeSObjectResult;

public class ComparisonSession {

	private final String groupKey;
	
	private String name;
	
	private final SalesforceSession salesforceSession;
	
	private DescribeGlobalResult describeGlobalResult;
	
	private Set<String> interestingTypes = new TreeSet<String>();
	
	private Map<String, DescribeSObjectResult> sobjectMap = new HashMap<String, DescribeSObjectResult>();

	public ComparisonSession(String groupKey, SalesforceSession salesforceSession) {
		this.salesforceSession = salesforceSession;
		this.groupKey = groupKey;
	}
	
	public DescribeGlobalResult getDescribeGlobalResult() {
		return describeGlobalResult;
	}

	public void setDescribeGlobalResult(DescribeGlobalResult describeGlobalResult) {
		this.describeGlobalResult = describeGlobalResult;
	}

	public Map<String, DescribeSObjectResult> getSobjectMap() {
		return sobjectMap;
	}

	public void setSobjectMap(Map<String, DescribeSObjectResult> sobjectMap) {
		this.sobjectMap = sobjectMap;
	}

	public String getGroupKey() {
		return groupKey;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SalesforceSession getSalesforceSession() {
		return salesforceSession;
	}

	public Set<String> getInterestingTypes() {
		return interestingTypes;
	}

	public void setInterestingTypes(Set<String> interestingTypes) {
		this.interestingTypes = interestingTypes;
	}
	
	
	
}
