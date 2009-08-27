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
package com.modelmetrics.cloudconverter.migrate.struts2;

import java.util.ArrayList;
import java.util.Collection;

public class ConflictResolutionType extends org.apache.commons.lang.enums.Enum {

	public static final ConflictResolutionType FAIL_WHEN_BOTH_HAVE_DATA = new ConflictResolutionType("Fail When Both Have Data");
	
	public static final ConflictResolutionType ALWAYS_OVERWRITE_TARGET_WITH_SOURCE = new ConflictResolutionType("Always Overwrite Target With Source");
	
	public static final ConflictResolutionType OVERWITE_WHEN_NOT_EMPTY = new ConflictResolutionType("Overwrite Target When Source Not Empty");
	
	public static final ConflictResolutionType BOOLEAN_OVERWITE_WHEN_TRUE = new ConflictResolutionType("Boolean Overwrite Target When Source True");
	
	public static final ConflictResolutionType CONCATENATE_SOURCE_TO_TARGET = new ConflictResolutionType("Concatenate Source to Target");
	
	public static final ConflictResolutionType CONCATENATE_TARGET_TO_SOURCE = new ConflictResolutionType("Concatenate Target to Source");

	private static Collection<ConflictResolutionType> types = new ArrayList<ConflictResolutionType>();
	
	public static Collection<ConflictResolutionType> getTypes() {
		return ConflictResolutionType.getEnumList(ConflictResolutionType.class);
	}
	
	public static ConflictResolutionType getType(String name) {
		return (ConflictResolutionType) ConflictResolutionType.getEnum(ConflictResolutionType.class, name);
	}
	protected ConflictResolutionType(String arg0) {
		super(arg0);
		
	}
	
	


	
}
