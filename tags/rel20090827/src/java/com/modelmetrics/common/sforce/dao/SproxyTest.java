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

package com.modelmetrics.common.sforce.dao;

import junit.framework.TestCase;

public class SproxyTest extends TestCase {

	public void testDirtyWithValue() throws Exception {
		
		Sproxy sample = SproxySampleFactory.build();
		
		assertFalse(sample.isDirty());
		
		sample.setValue("someKey", "someValue");
		
		assertTrue(sample.isDirty());		
		
	}
	
	public void testDirtyWithNulls() throws Exception {
		
		Sproxy sample = SproxySampleFactory.build();
		
		assertFalse(sample.isDirty());
		
		sample.setNull("someKey");
		
		assertTrue(sample.isDirty());
		
	}
	
	public void testNotDirtyWhenReplacingSampleValue() throws Exception {
		
		Sproxy sample = SproxySampleFactory.build(5, 0);
		
		String targetKey = (String) sample.getValueKeys().toArray()[0];
		
		String newTargetValue = sample.getValue(targetKey);
		
		assertFalse(sample.isDirty());
		
		sample.setValue(targetKey, newTargetValue);
		
		assertFalse(sample.isDirty());
		
		sample.setValue(targetKey, newTargetValue+"11");
		
		assertTrue(sample.isDirty());
	}
	
	
}
