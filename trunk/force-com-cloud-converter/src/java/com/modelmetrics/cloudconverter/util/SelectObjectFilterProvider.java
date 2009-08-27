package com.modelmetrics.cloudconverter.util;

import java.util.ArrayList;
import java.util.Collection;

public class SelectObjectFilterProvider {

	private static Collection<String> filters;
	
	public static Collection<String> getFilters() {
		if (filters == null) {
			filters = new ArrayList<String>();
			filters.add("All");
			filters.add("A");
			filters.add("B");
			filters.add("C");
			filters.add("D");
			filters.add("E");
			filters.add("F");
			filters.add("G");
			filters.add("H");
			filters.add("I");
			filters.add("J");
			filters.add("K");
			filters.add("L");
			filters.add("M");
			filters.add("N");
			filters.add("O");
			filters.add("P");
			filters.add("Q");
			filters.add("R");
			filters.add("S");
			filters.add("T");
			filters.add("U");
			filters.add("V");
			filters.add("W");
			filters.add("X");
			filters.add("Y");
			filters.add("Z");
			
			
			
		}
		return filters;
	}
}
