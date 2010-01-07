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
package com.modelmetrics.cloudconverter.forceutil;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.sforce.soap.partner.Field;

public class MetadataReadinessCheckerTest extends TestCase {

	public void testContainsSucceeds() throws Exception {
		
		List<MetadataProxy> proxies = new ArrayList<MetadataProxy>();
		
		MetadataProxy metadataProxy = new MetadataProxy();
		metadataProxy.setName("Name1");
		
		proxies.add(metadataProxy);
		
		metadataProxy = new MetadataProxy();
		metadataProxy.setName("Name2");
		
		proxies.add(metadataProxy);
		
		Field[] fields = new Field[2];
		
		fields[0] = new Field();
		fields[0].setName("Name1");
		
		fields[1] = new Field();
		fields[1].setName("Name2");
		
		MetadataReadinessChecker checker = new MetadataReadinessChecker();
		
		assertTrue(checker.isMetadataReady(proxies, fields));
	}
	
	public void testContainsFails() throws Exception {
		
		List<MetadataProxy> proxies = new ArrayList<MetadataProxy>();
		
		MetadataProxy metadataProxy = new MetadataProxy();
		metadataProxy.setName("Name1");
		
		proxies.add(metadataProxy);
		
		metadataProxy = new MetadataProxy();
		metadataProxy.setName("Name3");
		
		proxies.add(metadataProxy);
		
		Field[] fields = new Field[2];
		
		fields[0] = new Field();
		fields[0].setName("Name1");
		
		fields[1] = new Field();
		fields[1].setName("Name2");
		
		MetadataReadinessChecker checker = new MetadataReadinessChecker();
		
		assertFalse(checker.isMetadataReady(proxies, fields));
	}
}
