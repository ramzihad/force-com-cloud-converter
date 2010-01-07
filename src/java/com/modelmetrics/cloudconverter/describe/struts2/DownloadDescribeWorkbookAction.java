package com.modelmetrics.cloudconverter.describe.struts2;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadDescribeWorkbookAction extends AbstractDescribeContextAware {

	private HSSFWorkbook workbook;
	
	public String execute() throws Exception {
		
		if (!this.getDescribeContext().isWorkbookPresent()) {
			return ERROR;
		}
		
		this.workbook = this.getDescribeContext().getWorkbook();
		
		return SUCCESS;
	}
	
	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}
}
