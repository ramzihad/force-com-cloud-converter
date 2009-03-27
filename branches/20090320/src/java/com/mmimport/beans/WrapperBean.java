package com.mmimport.beans;

import java.util.List;

public class WrapperBean {

	private String sheetName;
	
	private List<String> names;

	private List<String> types;

	private List<List<Object>> objects;


	private String type;

	private Boolean override;

	public Boolean getOverride() {
		return override;
	}

	public void setOverride(Boolean override) {
		this.override = override;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
}
