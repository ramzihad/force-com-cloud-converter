package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.List;

public class OptionsOneBean {

	private List<AdvanceOptionsBean> advanceOptionsBeans;
	
	private String sheet;

	public String getSheet() {
		return sheet;
	}

	public void setSheet(String sheet) {
		this.sheet = sheet;
	}

	public List<AdvanceOptionsBean> getAdvanceOptionsBeans() {
		return advanceOptionsBeans;
	}

	public void setAdvanceOptionsBeans(List<AdvanceOptionsBean> advanceOptionsBeans) {
		this.advanceOptionsBeans = advanceOptionsBeans;
	}


}
