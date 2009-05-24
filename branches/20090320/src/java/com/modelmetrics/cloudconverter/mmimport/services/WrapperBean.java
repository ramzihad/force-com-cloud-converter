package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.List;

public class WrapperBean {

	private String sheetName;
	
	private List<String> names;
	
	private List<String> labels;

	private List<String> types;
	
	private List<String> examples;

	private List<List<Object>> objects;

	private Boolean override;

	public Boolean getOverride() {
		return override;
	}

	public void setOverride(Boolean override) {
		this.override = override;
	}

	public String toString() {
		return "Names: " + names + "\nTypes: " + types;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<List<Object>> getObjects() {
		return objects;
	}

	public void setObjects(List<List<Object>> objects) {
		this.objects = objects;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<String> getExamples() {
		return examples;
	}

	public void setExamples(List<String> examples) {
		this.examples = examples;
	}
}
