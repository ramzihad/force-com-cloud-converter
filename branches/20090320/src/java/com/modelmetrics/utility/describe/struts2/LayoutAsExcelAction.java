package com.modelmetrics.utility.describe.struts2;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.common.poi.ExcelSupport;
import com.modelmetrics.utility.describe.LayoutExcelBuilderDelegate;
import com.opensymphony.xwork2.Action;

public class LayoutAsExcelAction extends LayoutsAction {

	private HSSFWorkbook workbook;
	


	public String execute() throws Exception {
		super.execute();
		ExcelSupport excelSupport = new ExcelSupport();
		
		HSSFWorkbook workbook = excelSupport.getWorkbook();
		
		LayoutExcelBuilderDelegate delegate = new LayoutExcelBuilderDelegate();
		
		delegate.handleBuild(this.getRows(), this.getRecordTypes(), this.getLayoutIds(), excelSupport, workbook, this.getTarget());
		
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
