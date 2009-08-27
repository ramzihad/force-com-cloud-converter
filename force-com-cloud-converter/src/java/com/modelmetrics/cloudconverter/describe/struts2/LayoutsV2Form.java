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
package com.modelmetrics.cloudconverter.describe.struts2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.modelmetrics.cloudconverter.describe.FieldItemVO;
import com.modelmetrics.cloudconverter.describe.LayoutsFieldVOV2;
import com.opensymphony.xwork2.Action;

public class LayoutsV2Form extends LayoutsActionV2 {

	private Collection<String> requiredFields = new ArrayList<String>();;

	private Collection<String> multipicklists = new ArrayList<String>();;

	public String execute() throws Exception {

		super.execute();

		for (Iterator iter = this.getSummary().getRows().iterator(); iter
				.hasNext();) {
			LayoutsFieldVOV2 element = (LayoutsFieldVOV2) iter.next();
			if (element.getField().getType().getValue().equalsIgnoreCase(
					"multipicklist")) {
				this.getMultipicklists().add(element.getField().getName());
			}
			
			
			
			for (Iterator iterator = element.getLayouts().iterator(); iterator.hasNext();) {
				FieldItemVO layoutElement = (FieldItemVO) iterator.next();
				if (layoutElement.isRequired()) {
					this.getRequiredFields().add(element.getField().getName());
					break;
				}
			}
		}
		
		

		return Action.SUCCESS;
	}

	public Collection<String> getMultipicklists() {
		return multipicklists;
	}

	public void setMultipicklists(Collection<String> multipicklists) {
		this.multipicklists = multipicklists;
	}

	public Collection<String> getRequiredFields() {
		return requiredFields;
	}

	public void setRequiredFields(Collection<String> requiredFields) {
		this.requiredFields = requiredFields;
	}
}
