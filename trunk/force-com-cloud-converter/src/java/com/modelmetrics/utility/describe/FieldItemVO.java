package com.modelmetrics.utility.describe;

import java.util.Collection;

import com.sforce.soap.partner.Field;

public class FieldItemVO {



	private String fieldName;
	private Field field;
	private boolean present;
	private boolean editable;
	private boolean required;
	private Collection<String> values;
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public String toString() {
		
		return fieldName + ": present: " + isPresent() + ", editable: " + isEditable() + ", required: " + isRequired();
	}
	public Collection<String> getValues() {
		return values;
	}
	public void setValues(Collection<String> values) {
		this.values = values;
	}
	
}
