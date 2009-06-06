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

import java.util.Collection;

import com.modelmetrics.cloudconverter.describe.LayoutsBuilder;
import com.modelmetrics.cloudconverter.describe.LayoutsFieldVO;
import com.opensymphony.xwork2.Action;
import com.sforce.soap.partner.DescribeSObjectResult;

public class LayoutsAction extends AbstractDescribeContextAware {

	private String target;

	private DescribeSObjectResult results;

	private Collection<LayoutsFieldVO> rows;

	private Collection<String> recordTypes;

	private Collection<String> layoutIds;

	public Collection<String> getRecordTypes() {
		return recordTypes;
	}

	public void setRecordTypes(Collection<String> recordTypes) {
		this.recordTypes = recordTypes;
	}

	public Collection<LayoutsFieldVO> getRows() {
		return rows;
	}

	public void setRows(Collection<LayoutsFieldVO> rows) {
		this.rows = rows;
	}

	public String execute() throws Exception {

		try {
			if (this.getDescribeContext().getTarget() != null) {

				LayoutsBuilder builder = new LayoutsBuilder();
				builder.execute(this.getSalesforceSessionContext()
						.getSalesforceSession(), this.getDescribeContext()
						.getTarget());

				this.setLayoutIds(builder.getLayoutIds());
				this.setRecordTypes(builder.getRecordTypes());
				this.setResults(builder.getResults());
				this.setRows(builder.getRows());

				this.getDescribeContext().setTarget(this.getTarget());
			}
		} catch (Exception e) {
			this.getDescribeContext().setLastMessage("Layouts not supported for object '" + this.getDescribeContext().getTarget() + "'.");
			return Action.ERROR;
		}

		return Action.SUCCESS;

	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String targetSObject) {
		this.target = targetSObject;
	}

	public DescribeSObjectResult getResults() {
		return results;
	}

	public void setResults(DescribeSObjectResult results) {
		this.results = results;
	}

	public Collection<String> getLayoutIds() {
		return layoutIds;
	}

	public void setLayoutIds(Collection<String> layoutIds) {
		this.layoutIds = layoutIds;
	}

}
