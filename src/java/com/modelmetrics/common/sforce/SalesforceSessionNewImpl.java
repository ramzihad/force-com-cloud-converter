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
import com.sforce.soap._2006._04.metadata.MetadataServiceLocator;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.SessionHeader;
import com.sforce.soap.partner.SforceServiceLocator;
import com.sforce.soap.partner.SoapBindingStub;

/**
 * SalesforceSessionNewImpl
 * 
 * @author Reid Carlberg rcarlberg@modelmetrics.com
 * @since May 17, 2007
 */

public class SalesforceSessionNewImpl implements SalesforceSession {

	private SalesforceCredentials salesforceCredentials;

	private SoapBindingStub sforce;

	private MetadataBindingStub metadata;

	private String url;

	private String metadataUrl;

	public String getMetadataUrl() {
		return metadataUrl;
	}

	public void setMetadataUrl(String metadataUrl) {
		this.metadataUrl = metadataUrl;
	}

	private void initializeConnection() throws Exception {

		SforceServiceLocator locator = new SforceServiceLocator();

		sforce = (SoapBindingStub) locator.getSoap(new java.net.URL(
				this.salesforceCredentials.getWsdlUrl()));

		LoginResult lr = sforce.login(this.salesforceCredentials.getUsername(),
				this.salesforceCredentials.getPassword());

		this.setUrl(lr.getServerUrl());

		this.setMetadataUrl(lr.getMetadataServerUrl());

		sforce._setProperty(SoapBindingStub.ENDPOINT_ADDRESS_PROPERTY, lr
				.getServerUrl());

		SessionHeader hdr = new SessionHeader();

		hdr.setSessionId(lr.getSessionId());

		sforce.setHeader(locator.getServiceName().getNamespaceURI(),
				"SessionHeader", hdr);

		metadata = (MetadataBindingStub) new MetadataServiceLocator()
				.getMetadata();
		metadata._setProperty(MetadataBindingStub.ENDPOINT_ADDRESS_PROPERTY,
				this.getMetadataUrl());

		metadata.setHeader(new MetadataServiceLocator().getServiceName()
				.getNamespaceURI(), "SessionHeader", hdr);
	}

	public SoapBindingStub getSalesforceService() throws Exception {

		if (sforce == null) {
			throw new RuntimeException("sforce connection is invalid.");
		}

		return this.sforce;
	}

	public SalesforceCredentials getSalesforceCredentials() {
		return salesforceCredentials;
	}

	public void setSalesforceCredentials(
			SalesforceCredentials salesforceCredentials) {
		this.salesforceCredentials = salesforceCredentials;

		if (!this.salesforceCredentials.hasSettings()) {
			throw new RuntimeException("Salesforce credentials are invalid.");
		}

		try {
			initializeConnection();
		} catch (Exception e) {
			throw new RuntimeException(
					"Couldn't initialize Salesforce Session", e);
		}

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MetadataBindingStub getMetadataService() {
		return metadata;
	}

	public void setMetadata(MetadataBindingStub metadata) {
		this.metadata = metadata;
	}
}
