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

public class SproxyStandardImplTest extends TestCase {

	public void testBasic() throws Exception {
		
		
		SproxyStandardImpl impl = new SproxyStandardImpl();
		
		impl.setId("id");
		impl.setType("account");
		impl.setValue("key1", "value1");
		impl.setNull("null1");
		
		assertEquals(1, impl.getValueKeys().size());
		assertTrue(impl.getValueKeys().contains("key1"));
		assertEquals("value1", impl.getValue("key1"));
		
		assertFalse(impl.getValueKeys().contains("missingKye"));
		assertNull(impl.getValue("missingKey"));
		
		assertEquals(1, impl.getNullKeys().size());
		assertTrue(impl.getNullKeys().contains("null1"));
		
		
	}
	
	public void testKeyExclusivity() throws Exception {
		/*
		 * tests exclusivity between value keys and null keys
		 */
		SproxyStandardImpl impl = new SproxyStandardImpl();
		
		impl.setValue("key1", "value1");
		impl.setNull("null1");
		
		assertEquals(1, impl.getValueKeys().size());
		assertEquals(1, impl.getNullKeys().size());
		
		impl.setNull("key1");

		assertFalse(impl.getValueKeys().contains("key1"));
		assertEquals(0, impl.getValueKeys().size());
		assertEquals(2, impl.getNullKeys().size());
		
		impl.setValue("null1", "notnull");
		
		assertEquals(1, impl.getValueKeys().size());
		assertEquals(1, impl.getNullKeys().size());

		assertTrue(impl.getValueKeys().contains("null1"));
		assertFalse(impl.getNullKeys().contains("null1"));
		
		
	}
}
