package com.modelmetrics.utility.describe.struts2;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.common.poi.ExcelSupport;
import com.modelmetrics.utility.describe.DataTemplateExcelBuilderDelegate;
import com.modelmetrics.utility.describe.LayoutsBuilderV2;
import com.modelmetrics.utility.describe.LayoutsSummary;
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
		
		delegate.handleBuild(this.getResults(), summary, excelSupport, workbook, this.getDescribeContext().getTarget());
		
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
