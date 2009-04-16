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
