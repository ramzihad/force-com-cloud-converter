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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import com.modelmetrics.cloudconverter.util.InterestingSobjectFilter;
import com.modelmetrics.cloudconverter.util.SelectObjectFilterProvider;
import com.sforce.soap.partner.DescribeGlobalResult;

public class SelectObjectAction extends AbstractDescribeContextAware {

	private static final Log log = LogFactory.getLog(SelectObjectAction.class);

	private String target;

	private String filter;

	private String existingLocationUrl;
	
	private String existingSessionId;

	public String execute() throws Exception {

		if (this.getSalesforceSessionContext().getSalesforceSession() == null
				&& this.getExistingSessionId() != null
				&& this.getExistingLocationUrl() != null) {
			this.getSalesforceSessionContext().setSalesforceExistingSession(
					this.getExistingSessionId(), this.getExistingLocationUrl());

		} else {
			//not an error condition -- just possibly repopulating if cookie lost.
//			return ERROR;
		}

		if (this.getTarget() == null) {
			// get describe global
			DescribeGlobalResult describeGlobalResult = this
					.getSalesforceSessionContext().getSalesforceSession()
					.getSalesforceService().describeGlobal();

			// only deal with interesting types
			if (StringUtils.hasText(this.getFilter())) {
				Collection<String> types = new ArrayList<String>();

				for (String type : describeGlobalResult.getTypes()) {
					if (this.getFilter().equalsIgnoreCase("all")) {
						types.add(type);
					} else if (type.startsWith(this.getFilter())) {
						types.add(type);
					}
				}
				this.getDescribeContext().setTypes(types);
			} else {
				this.getDescribeContext().setTypes(
						new InterestingSobjectFilter()
								.getInterestSobjects(describeGlobalResult));
			}
			
			//make sure we reset the context
			this.getDescribeContext().setLastResult(null);

			return INPUT;
		}

		this.getDescribeContext().setTarget(this.getTarget());

		return SUCCESS;

	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String targetSObject) {
		this.target = targetSObject;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getExistingLocationUrl() {
		return existingLocationUrl;
	}

	public String getExistingSessionId() {
		return existingSessionId;
	}

	public String getS() {
		return this.getExistingSessionId();
	}

	public String getU() {
		return this.getExistingLocationUrl();
	}

	public void setExistingLocationUrl(String username) {
		this.existingLocationUrl = username;
	}

	public void setExistingSessionId(String password) {
		this.existingSessionId = password;
	}

	public void setS(String s) {
		this.setExistingSessionId(s);
	}

	public void setU(String u) {
		this.setExistingLocationUrl(u);
	}
	
	public Collection<String> getFilterPrompts() {
		return SelectObjectFilterProvider.getFilters();
	}

}
