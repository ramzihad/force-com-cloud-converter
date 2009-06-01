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

import org.springframework.util.StringUtils;

public class LookupSettings {

	/*
	 * Syntax required for SFDC: 
	 * 
	 * "{localRelationshipName}:{parentObjectName}:{parentExternalIdName}"
	 * 
	 * Example:
	 * 
	 * "MYLOOKUP__r:AAA__c:TestExternalId__c"
	 */
	private String localName;
	
	private String relationshipObject;
	
	private String localRelationshipName;
	
	private String parentObjectName;
	
	private String parentExternalIdName;
	
	//this class generates this.
	private String apiResolutionString;

	public LookupSettings(String localName, String relationshipObject, String apiResolutionString) {
		this.localName = localName;
		this.apiResolutionString = apiResolutionString;
		this.relationshipObject = relationshipObject;
	}
	
	public LookupSettings(String localName) {
		this.localName = localName;
	}
	
	public LookupSettings() {
	}
	
	public LookupSettings(String localName, String localRelationshipName,
			String parentObjectName, String targetFieldName) {
		this.localName = localName;
		this.localRelationshipName = localRelationshipName;
		this.parentObjectName = parentObjectName;
		this.parentExternalIdName = targetFieldName;
	}
	
	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getRelationshipObject() {
		return relationshipObject;
	}

	public void setRelationshipObject(String relationshipObject) {
		this.relationshipObject = relationshipObject;
	}

	
	public String getApiResolutionString() {
		if (StringUtils.hasText(this.apiResolutionString)) 
		return apiResolutionString;
		
		if (StringUtils.hasText(this.getLocalRelationshipName()) && StringUtils.hasText(this.getParentObjectName()) && StringUtils.hasText(this.getParentExternalIdName()) ) {
			//should look like
			//"MYLOOKUP__r:AAA__c:TestExternalId__c"
			String ret = this.getLocalRelationshipName() + ":" + this.getParentObjectName() + ":" + this.getParentExternalIdName();
			this.setApiResolutionString(ret);
			return ret;
			
 		} else {
 			throw new RuntimeException("we don't have everything we need");
 		}
	}

	public void setApiResolutionString(String relationshipFields) {
		this.apiResolutionString = relationshipFields;
	}

	public String getParentObjectName() {
		return parentObjectName;
	}

	public void setParentObjectName(String parentObjectName) {
		this.parentObjectName = parentObjectName;
	}

	public String getParentExternalIdName() {
		return parentExternalIdName;
	}

	public void setParentExternalIdName(String targetFieldName) {
		this.parentExternalIdName = targetFieldName;
	}

	public String getLocalRelationshipName() {
		return localRelationshipName;
	}

	public void setLocalRelationshipName(String localRelationshipName) {
		this.localRelationshipName = localRelationshipName;
	}
	
	
}
