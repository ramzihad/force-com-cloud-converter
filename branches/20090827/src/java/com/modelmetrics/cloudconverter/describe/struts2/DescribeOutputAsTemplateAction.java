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
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.cloudconverter.describe.DescribeExcelBuilderDelegate;
import com.modelmetrics.cloudconverter.describe.DescribeExcelBuilderDelegateMetadataImpl;
import com.modelmetrics.cloudconverter.describe.DescribeExcelBuilderDelegateTemplateImpl;
import com.modelmetrics.cloudconverter.describe.DisplayableSobjectFieldMetadataBeanBuilder;
import com.modelmetrics.cloudconverter.describe.SobjectFieldPropertyBean;
import com.modelmetrics.cloudconverter.util.OperationStatusSubscriberLifoImpl;
import com.modelmetrics.common.poi.ExcelSupport;
import com.opensymphony.xwork2.Action;

public class DescribeOutputAsTemplateAction extends DescribeAction {
	private String submitMetadata;
	private String submitTemplate;
	private Collection<String> selectedObjects;
//	private HSSFWorkbook workbook;

	public String execute() throws Exception {
		if (this.getSubmitMetadata() == null
				&& this.getSubmitTemplate() == null)
			return Action.INPUT;

		ExcelSupport excelSupport = new ExcelSupport();

		HSSFWorkbook workbook = excelSupport.getWorkbook();

		DescribeExcelBuilderDelegate delegate = null;

		if (this.getSubmitMetadata() != null) {

			delegate = new DescribeExcelBuilderDelegateMetadataImpl(
					excelSupport, workbook);
		} else {
			delegate = new DescribeExcelBuilderDelegateTemplateImpl(
					excelSupport, workbook, this.getSalesforceSessionContext()
							.getSalesforceSession());
		}
		
		//status
		this.getDescribeContext().setStatusSubscriber(new OperationStatusSubscriberLifoImpl());

		for (Iterator iter = selectedObjects.iterator(); iter.hasNext();) {
			String objectType = (String) iter.next();
			this.setTarget(objectType);
			
			this.getDescribeContext().getStatusSubscriber().publish("Describing " + objectType);
			
			super.execute();

			delegate.handleBuild(this.getDisplayableFields(), this
					.getDescribeContext().getTarget());

			//			
			// delegate.handleBuild(this.getObjectFields(), excelSupport,
			// workbook, this.getTarget());
		}

		this.getDescribeContext().setWorkbook(workbook);
		
		this.getDescribeContext().getStatusSubscriber().reset();
		
		return Action.SUCCESS;
	}

	public String getSubmitMetadata() {
		return submitMetadata;
	}

	public void setSubmitMetadata(String submit) {
		this.submitMetadata = submit;
	}

	public Collection<String> getSelectedObjects() {
		return selectedObjects;
	}

	public void setSelectedObjects(Collection<String> selectedObjects) {
		this.selectedObjects = selectedObjects;
	}

//	public HSSFWorkbook getWorkbook() {
//		return workbook;
//	}
//
//	public void setWorkbook(HSSFWorkbook workbook) {
//		this.workbook = workbook;
//	}

	public String getSubmitTemplate() {
		return submitTemplate;
	}

	public void setSubmitTemplate(String submitTemplate) {
		this.submitTemplate = submitTemplate;
	}

}
