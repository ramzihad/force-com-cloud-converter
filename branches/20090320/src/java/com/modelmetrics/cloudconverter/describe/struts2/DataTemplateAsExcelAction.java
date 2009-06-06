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

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.cloudconverter.describe.DataTemplateExcelBuilderDelegate;
import com.modelmetrics.cloudconverter.describe.LayoutsBuilderV2;
import com.modelmetrics.cloudconverter.describe.LayoutsSummary;
import com.modelmetrics.common.poi.ExcelSupport;
import com.opensymphony.xwork2.Action;

public class DataTemplateAsExcelAction extends DescribeAction {

	private HSSFWorkbook workbook;

	public String execute() throws Exception {

		try {
		super.execute();

		ExcelSupport excelSupport = new ExcelSupport();

		HSSFWorkbook workbook = excelSupport.getWorkbook();

		LayoutsBuilderV2 builder = new LayoutsBuilderV2();
		LayoutsSummary summary = builder.execute(this.getSalesforceSessionContext().getSalesforceSession(), this.getDescribeContext().getTarget());

		DataTemplateExcelBuilderDelegate delegate = new DataTemplateExcelBuilderDelegate();
		
		delegate.handleBuild(this.getObjectFields(), summary, excelSupport, workbook, this.getDescribeContext().getTarget());
		
		this.setWorkbook(workbook);
		} catch (Exception e) {
			this.getDescribeContext().setLastMessage("Layouts not supported for object '" + this.getDescribeContext().getTarget() + "'.");
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}



	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}
}
