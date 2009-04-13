package com.modelmetrics.cloudconverter.util;

import com.sforce.soap._2006._04.metadata.FieldType;

public class MetadataProxy {

	private String name;
	
	private String label;
	
	private FieldType type;
	
	private int length;
	
	private int scale;
	
	private int precision;
	
	private String defaultValue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType fieldType) {
		this.type = fieldType;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
