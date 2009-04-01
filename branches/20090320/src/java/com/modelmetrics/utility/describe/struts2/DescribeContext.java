package com.modelmetrics.utility.describe.struts2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

public class DescribeContext {

	private Collection<String> objectTypes;
	
	private String[] types;

	private String target;

	private Map<String, DescribeSObjectResult> descriptions = new HashMap<String, DescribeSObjectResult>();
	
	private DescribeSObjectResult lastResult;

	public void initialize() {

		this.types = null;

		this.descriptions = new HashMap<String, DescribeSObjectResult>();
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public Map<String, DescribeSObjectResult> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Map<String, DescribeSObjectResult> descriptions) {
		this.descriptions = descriptions;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public DescribeSObjectResult getLastResult() {
		return lastResult;
	}

	public void setLastResult(DescribeSObjectResult lastResult) {
		this.lastResult = lastResult;
	}

	public Collection<String> getObjectTypes()
	{
		objectTypes = Arrays.asList(types);
		return objectTypes;
	}

	public void setObjectTypes(Collection<String> objectTypes)
	{
		this.objectTypes = objectTypes;
	}



}
