package com.modelmetrics.utility.describe;

import java.util.Comparator;

import com.sforce.soap.partner.Field;

public class FieldComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		Field field0 = (Field) arg0;
		Field field1 = (Field) arg1;
		
		return field0.getLabel().compareTo(field1.getLabel());
	}

}
