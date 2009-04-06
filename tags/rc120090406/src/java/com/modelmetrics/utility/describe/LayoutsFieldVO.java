package com.modelmetrics.utility.describe;

import java.util.ArrayList;
import java.util.Collection;

public class LayoutsFieldVO {

	private String label;
	
	private String name;
	
	private boolean notFound;
	
	private Collection<Boolean> present = new ArrayList<Boolean>();

	public String getName() {
		return name;
	}

	public void setName(String api) {
		this.name = api;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String name) {
		this.label = name;
	}

	public boolean isNotFound() {
		return notFound;
	}

	public void setNotFound(boolean notFound) {
		this.notFound = notFound;
	}

	public Collection<Boolean> getPresent() {
		return present;
	}

	public void setPresent(Collection<Boolean> present) {
		this.present = present;
	}
	
}
