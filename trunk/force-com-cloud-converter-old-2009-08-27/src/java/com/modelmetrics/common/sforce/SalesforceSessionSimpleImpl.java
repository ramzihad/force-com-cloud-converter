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

package com.modelmetrics.common.sforce;

import com.sforce.soap._2006._04.metadata.MetadataBindingStub;
import com.sforce.soap.partner.SoapBindingStub;

public class SalesforceSessionSimpleImpl implements SalesforceSession {

	public void initialize() throws Exception {
		throw new RuntimeException("Reid is lazy and didn't implement");
	}

	public MetadataBindingStub getMetadataService() throws Exception {
		throw new RuntimeException("Reid is lazy & didn't implement");
	}

	public String getMetadataUrl() {
		throw new RuntimeException("Reid is lazy & didn't implement");
	}

	private SoapBindingStub sforce;

	public SoapBindingStub getSalesforceService() {
		return sforce;
	}

	public void setSforce(SoapBindingStub sforce) {
		this.sforce = sforce;
	}

	public String getUrl() {

		return null;
	}

	public SalesforceCredentials getSalesforceCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

}
