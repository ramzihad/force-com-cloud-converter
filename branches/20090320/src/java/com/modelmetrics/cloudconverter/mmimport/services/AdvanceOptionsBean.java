package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.List;

public class AdvanceOptionsBean {
	
	private String name;
	
	private String label;
	
	private String type;
	
	private List<Object> data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}
}
