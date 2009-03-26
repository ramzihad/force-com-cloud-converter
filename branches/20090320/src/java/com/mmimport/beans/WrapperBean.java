package com.mmimport.beans;

import java.util.List;


public class WrapperBean {

	private List<String> names;
	
	private List<String> types;
	
	
	private List<List<String>> objects;
	
	private String name;

	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString(){
		return name;
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

	public List<List<String>> getObjects() {
		return objects;
	}

	public void setObjects(List<List<String>> objects) {
		this.objects = objects;
	}
}
