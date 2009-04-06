package com.modelmetrics.utility.describe.struts2;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.common.poi.ExcelSupport;
import com.modelmetrics.utility.describe.DescribeExcelBuilderDelegate;
import com.opensymphony.xwork2.Action;

public class DescribeAllInExcelAction extends DescribeAction {

	private HSSFWorkbook workbook;

	public String execute() throws Exception {

		ExcelSupport excelSupport = new ExcelSupport();

		HSSFWorkbook workbook = excelSupport.getWorkbook();

		DescribeExcelBuilderDelegate delegate = new DescribeExcelBuilderDelegate();
		
		for (int i = 0; i < this.getDescribeContext().getTypes().length; i++) {

			this.setTarget(this.getDescribeContext().getTypes()[i]);
			super.execute();
			
			delegate.handleBuild(this.getResults(), excelSupport, workbook, this.getTarget());


		}
		
		this.setWorkbook(workbook);

		return Action.SUCCESS;
	}

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

}
