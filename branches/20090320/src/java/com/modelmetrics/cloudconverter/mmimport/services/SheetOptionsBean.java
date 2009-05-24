package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.List;

public class SheetOptionsBean {

	private List<SingleFieldOptionsBean> advanceOptionsBeans;
	
	private String sheetName;

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheet) {
		this.sheetName = sheet;
	}

	public List<SingleFieldOptionsBean> getAdvanceOptionsBeans() {
		return advanceOptionsBeans;
	}

	public void setAdvanceOptionsBeans(List<SingleFieldOptionsBean> advanceOptionsBeans) {
		this.advanceOptionsBeans = advanceOptionsBeans;
	}


}
