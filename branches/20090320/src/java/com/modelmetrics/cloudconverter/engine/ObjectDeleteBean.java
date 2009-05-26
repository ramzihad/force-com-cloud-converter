package com.modelmetrics.cloudconverter.engine;

import java.util.Set;
import java.util.TreeSet;

import com.modelmetrics.cloudconverter.mmimport.services.CloudConverterObject;
import com.sforce.soap.partner.DescribeSObjectResult;

public class ObjectDeleteBean {

	private CloudConverterObject original;
	
	private int refToOtherObjectCount;
	
	private Set<String> otherObjectRef = new TreeSet<String>();
	
	private DescribeSObjectResult describeSObjectResult;

	
	@Override
	public boolean equals(Object obj) {
		return false;
	}

	public DescribeSObjectResult getDescribeSObjectResult() {
		return describeSObjectResult;
	}

	public void setDescribeSObjectResult(DescribeSObjectResult describeSObjectResult) {
		this.describeSObjectResult = describeSObjectResult;
	}

	public CloudConverterObject getOriginal() {
		return original;
	}

	public void setOriginal(CloudConverterObject original) {
		this.original = original;
	}

	public int getRefToOtherObjectCount() {
		return refToOtherObjectCount;
	}

	public void setRefToOtherObjectCount(int refToOtherObjectCount) {
		this.refToOtherObjectCount = refToOtherObjectCount;
	}

	public Set<String> getOtherObjectRef() {
		return otherObjectRef;
	}

	public void setOtherObjectRef(Set<String> otherObjectRef) {
		this.otherObjectRef = otherObjectRef;
	}
	
	
}
