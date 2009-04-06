package com.modelmetrics.utility.describe;

import java.util.Comparator;

public class LayoutsFieldVOV2Comparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		LayoutsFieldVOV2 one = (LayoutsFieldVOV2) arg0;
		LayoutsFieldVOV2 two = (LayoutsFieldVOV2) arg1;
		return one.getField().getLabel().compareTo(two.getField().getLabel());
	}

}
