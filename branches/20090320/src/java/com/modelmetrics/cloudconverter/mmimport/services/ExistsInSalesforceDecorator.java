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
package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.List;

public class ExistsInSalesforceDecorator {

	public void decorate(List<CloudConverterObject> cloudConverterObjects,
			SalesforceService salesforceService) {

		for (CloudConverterObject current : cloudConverterObjects) {
			if (current.getObjectName() == null
					|| !current.getObjectName().endsWith("__c")) {
				throw new RuntimeException(
						"Can't check blank or non-custom object names");
			}

			try {
				current.setExistsInSalesforce(salesforceService
						.containsObject(current.getObjectName()));
			} catch (Exception e) {
				throw new RuntimeException("Couldn't determine if '"
						+ current.getObjectName() + "' exists in SFDC.");
			}
		}
	}

}
