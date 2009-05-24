package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.ArrayList;
import java.util.List;

public class ExcelWorksheetWrapperBean {

	private String sheetName;
	
	private List<String> names = new ArrayList<String>();
	
	private List<String> labels= new ArrayList<String>();

	private List<String> types= new ArrayList<String>();
	
	//a single row of example data
	private List<String> examples= new ArrayList<String>();

	private List<List<Object>> data = new ArrayList<List<Object>>();

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

	public List<List<Object>> getData() {
		return data;
	}

	public void setData(List<List<Object>> objects) {
		this.data = objects;
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
