/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.modelmetrics.cloudconverter.engine;

import java.util.Set;
import java.util.TreeSet;

import com.sforce.soap.partner.DescribeSObjectResult;
import com.temp.CloudConverterObject;

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
