package com.modelmetrics.cloudconverter.describe;

import java.util.Collection;

import com.sforce.soap.partner.Field;

public class DisplayableFieldMetadataBean {

	private Field field;
	
	private Collection<DisplayableSobjectFieldPropertyBean> properties;

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Collection<DisplayableSobjectFieldPropertyBean> getProperties() {
		return properties;
	}

	public void setProperties(
			Collection<DisplayableSobjectFieldPropertyBean> properties) {
		this.properties = properties;
	}
	
	
}
