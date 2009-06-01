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
package com.modelmetrics.utility.migrate.struts2;

import java.util.ArrayList;
import java.util.Collection;

public class SourceDispositionType extends org.apache.commons.lang.enums.Enum {

	public static final SourceDispositionType SET_TO_NULL = new SourceDispositionType("Set To Null");
	
	public static final SourceDispositionType DO_NOTHING = new SourceDispositionType("Ignore");
	
	private static Collection<SourceDispositionType> types = new ArrayList<SourceDispositionType>();
	
	public static Collection<SourceDispositionType> getTypes() {
		return SourceDispositionType.getEnumList(SourceDispositionType.class);
	}
	
	public static SourceDispositionType getType(String name) {
		return (SourceDispositionType) SourceDispositionType.getEnum(SourceDispositionType.class, name);
	}
	protected SourceDispositionType(String arg0) {
		super(arg0);
		
	}
	
	


	
}
