package com.modelmetrics.utility.describe;

import java.util.Comparator;

public class FieldItemVOComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {

		FieldItemVO one = (FieldItemVO) arg0;
		
		FieldItemVO two = (FieldItemVO) arg1;
		
		return one.getFieldName().compareTo(two.getFieldName());
		
	}

}
