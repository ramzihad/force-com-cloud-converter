package com.modelmetrics.cloudconverter.describe;

import com.sforce.soap.partner.Field;

public class DisplayableSobjectFieldPropertyBean {

	public SobjectFieldPropertyBean sobjectFieldBean;
	
	public Field field;
	
	public boolean multiline;
	
	public String value;
	
	public String[] multilineValue;

	public SobjectFieldPropertyBean getSobjectFieldBean() {
		return sobjectFieldBean;
	}

	public void setSobjectFieldBean(SobjectFieldPropertyBean sobjectFieldBean) {
		this.sobjectFieldBean = sobjectFieldBean;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String displayableValue) {
		this.value = displayableValue;
	}

	public boolean isMultiline() {
		return multiline;
	}

	public void setMultiline(boolean multiline) {
		this.multiline = multiline;
	}

	public String[] getMultilineValue() {
		return multilineValue;
	}

	public void setMultilineValue(String[] multilineValue) {
		this.multilineValue = multilineValue;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
	
}
