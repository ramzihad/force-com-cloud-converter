package com.modelmetrics.cloudconverter.mmimport.services;

public class ValueId {

	private String value;
	
	private String id;

	public String getId() {
		return id;
	}

	public ValueId(String value, String id) {
		super();
		this.value = value;
		this.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
