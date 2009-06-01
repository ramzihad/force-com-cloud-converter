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

import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeSObjectResult;

public class ComparisonSessionObjectInfoDecorator {

	public void execute(ComparisonSession comparisonSession) throws Exception {

		// get global
		DescribeGlobalResult describeGlobalResult = comparisonSession
				.getSalesforceSession().getSalesforceService().describeGlobal();

		comparisonSession.setDescribeGlobalResult(describeGlobalResult);

		// get for each object
		for (String sobject : describeGlobalResult.getTypes()) {
			if (this.isInteresting(sobject)) {
				
				DescribeSObjectResult describeSObjectResult = comparisonSession.getSalesforceSession().getSalesforceService().describeSObject(sobject);
				
				
				comparisonSession.getSobjectMap().put(sobject, describeSObjectResult);
				
				comparisonSession.getInterestingTypes().add(sobject);
			}
		}

	}

	/*
	 * filter out the stuff I don't need to worry about.
	 */
	public boolean isInteresting(String string) {

		boolean ret = true;

		if (string.endsWith("History") || string.endsWith("Share"))
			return false;

		if (string.equalsIgnoreCase("ApexComponent")
				|| string.equalsIgnoreCase("ApexClass")
				|| string.equalsIgnoreCase("ApexTrigger")
				|| string.equalsIgnoreCase("ApexPage"))
			return false;

		if (string.equalsIgnoreCase("ProcessInstance")
				|| string.equalsIgnoreCase("ProcessInstanceHistory")
				|| string.equalsIgnoreCase("ProcessInstanceStep")
				|| string.equals("ProcessInstanceHistory"))
			return false;
		
		if (string.equalsIgnoreCase("Document")
				|| string.equalsIgnoreCase("DocumentAttachmentMap")
				|| string.equalsIgnoreCase("Note")
				|| string.equals("NoteAndAttachment"))
			return false;
		
		if (string.equalsIgnoreCase("EmailServicesAddress")
				|| string.equalsIgnoreCase("EmailServicesFunction")
				|| string.equalsIgnoreCase("EmailStatus"))
			return false;
		
		if (string.equalsIgnoreCase("FiscalYearSettings")
				|| string.equalsIgnoreCase("Folder")
				|| string.equalsIgnoreCase("ForecastShare")
				|| string.equalsIgnoreCase("Group")
				|| string.equalsIgnoreCase("GroupMember"))
			return false;
		
		//for testing only -- just to keep the list short.
		if (!string.equalsIgnoreCase("Account") && !string.equalsIgnoreCase("Contact")) {
			return false;
		}

		return ret;
	}
}
