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

import org.springframework.util.StringUtils;

/**
 * SalesforceCredentials
 * @author Reid Carlberg rcarlberg@modelmetrics.com
 * @since May 17, 2007
 */

public class SalesforceCredentials {

	private String productionUrl = "https://www.salesforce.com/services/Soap/u/18.0";
	
	private String sandboxUrl = "https://test.salesforce.com/services/Soap/u/18.0";
	
	private String wsdlUrl = null;
	
	private String username;
	
	private String password;
	
	private String token;

	public SalesforceCredentials() {
		super();
		this.wsdlUrl = this.productionUrl;
	}
	
	public SalesforceCredentials(String username, String password) {
		super();
		this.wsdlUrl = this.productionUrl;
		this.username = username;
		this.password = password;
	}
	
	public void setUseSandbox() {
		wsdlUrl = sandboxUrl;
	}
	
	public boolean hasSettings() {
		
		return StringUtils.hasText(this.wsdlUrl) &&
			StringUtils.hasText(this.username) &&
			StringUtils.hasText(this.password);
		
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWsdlUrl() {
		return wsdlUrl;
	}

	public void setWsdlUrl(String wsdlUrl) {
		this.wsdlUrl = wsdlUrl;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
