package com.modelmetrics.cloudconverter.forceutil;

/**
 * 
 * @author reidcarlberg
 * @since 2009-05-24
 */
public class CustomObjectNameBuilder {

	public String buildCustomObjectName(String name) {
		
		name = name.replaceAll("__", "_");
		name = name.replaceAll("[^A-Za-z0-9_]", "");
		String ret = name + "__c";
		
		return ret;
	}
}
