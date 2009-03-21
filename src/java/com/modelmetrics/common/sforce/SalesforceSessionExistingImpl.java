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

import com.sforce.soap._2006._04.metadata.MetadataBindingStub;
import com.sforce.soap.partner.SessionHeader;
import com.sforce.soap.partner.SforceService;
import com.sforce.soap.partner.SforceServiceLocator;
import com.sforce.soap.partner.SoapBindingStub;

/**
 * SalesforceSessionExistingImpl
 * @author Reid Carlberg rcarlberg@modelmetrics.com
 * @since May 17, 2007
 */

public class SalesforceSessionExistingImpl implements SalesforceSession {


	public MetadataBindingStub getMetadataService() throws Exception {
		throw new RuntimeException("Reid is lazy & didn't implement");
	}


	public String getMetadataUrl() {
		throw new RuntimeException("Reid is lazy & didn't implement");
	}

	private final String existingSessionId;
	
	private final String existingSessionUrl;
	
	private SoapBindingStub sforce;
	
	public SalesforceSessionExistingImpl(String existingSessionId, String existingSessionUrl) {
		this.existingSessionId = existingSessionId;
		this.existingSessionUrl = existingSessionId;
		
		if ( !StringUtils.hasText(this.existingSessionId) || !StringUtils.hasText(this.existingSessionUrl)) {
			throw new RuntimeException("you must provide an existing session id and URL");
		}
	}
	
	public SoapBindingStub getSalesforceService() throws Exception {

		if (sforce == null) {
			
			SforceService service = new SforceServiceLocator();
			
			sforce = (SoapBindingStub) service.getSoap(new java.net.URL(this.existingSessionUrl));

			SessionHeader hdr = new SessionHeader();
			hdr.setSessionId(this.existingSessionId);
			
			sforce.setHeader(service.getServiceName().getNamespaceURI(),
					"SessionHeader", hdr);

		}
		
		return sforce;
	}

	public String getUrl() {
		
		return this.existingSessionUrl;
	}

	public SalesforceCredentials getSalesforceCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

}
