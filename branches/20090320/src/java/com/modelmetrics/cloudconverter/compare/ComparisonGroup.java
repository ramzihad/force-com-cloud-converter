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

import java.util.ArrayList;
import java.util.List;

public class ComparisonGroup {

	private final String groupKey;
	
	private List<ComparisonSession> comparisonSessions = new ArrayList<ComparisonSession>();

	public ComparisonGroup(String groupKey) {
		this.groupKey = groupKey;
	}
	
	public String getGroupKey() {
		return groupKey;
	}

	public void addComparisonSession(ComparisonSession comparisonSession) {
		if (this.getComparisonSessions().contains(comparisonSession)) {
			throw new RuntimeException("Comparison group " + this.groupKey + " already contains session " + comparisonSession.getSalesforceSession());
		}
		if (!this.groupKey.equals(comparisonSession.getGroupKey())) {
			throw new RuntimeException("Group keys are wrong.");
		}
		this.getComparisonSessions().add(comparisonSession);
	}
	
	public boolean isValid() {
		return this.comparisonSessions.size() > 1;
	}
	
	public List<ComparisonSession> getComparisonSessions() {
		return comparisonSessions;
	}

	
	
}
