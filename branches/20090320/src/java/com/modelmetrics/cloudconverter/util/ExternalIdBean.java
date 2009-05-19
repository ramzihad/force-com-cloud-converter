package com.modelmetrics.cloudconverter.util;

public class ExternalIdBean {

	private String name;
	
	private String label;
	
	private boolean unique;

	public ExternalIdBean() {
	}
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public ExternalIdBean(String label, boolean unique) {
		super();
		this.label = label;
		this.unique = unique;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
