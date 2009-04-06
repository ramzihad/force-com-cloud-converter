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

public class SproxySampleFactory {

	private static int count = 0;
	
	public static final String TYPE = "Account";
	
	public static Sproxy build() {
		
		count++;
		
		SproxyStandardImpl ret = new SproxyStandardImpl();
		
		ret.setType(TYPE);
		
		ret.setId("0000000" + count);
		
		ret.setValue("one", "one"+count);
		ret.setValue("two", "two"+count);
		ret.setValue("three", "three"+count);
		
		/*
		 * set dirty false
		 */
		
		ret.setDirty(false);
		
		return ret;
		
	}

	public static Sproxy build(int values, int nulls) {
		
		count++;
		
		SproxyStandardImpl ret = new SproxyStandardImpl();
		
		ret.setType(TYPE);
		
		ret.setId("0000000" + count);
		
		for (int i = 0; i< values; i++) {
			ret.setValue("key"+i+count, "value"+i+count);
		}

		for (int i = 0; i< nulls; i++) {
			ret.setNull("null"+i+count);
		}
		
		/*
		 * make sure it is not dirty
		 */
		ret.setDirty(false);
		
		return ret;
		
		
	}
	
	public static Sproxy buildDirty(int values, int nulls) {
		
		SproxyStandardImpl ret = (SproxyStandardImpl) build(values,nulls);
		ret.setDirty(true);
		return ret;
		
	}	
}
