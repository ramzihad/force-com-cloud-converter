package com.modelmetrics.cloudconverter.forceutil;

public class LookupSettings {

	private String localName;
	
	private String relationshipObject;
	
	private String relationshipFields;

	public LookupSettings(String localName, String relationshipObject, String relationshipFields) {
		this.localName = localName;
		this.relationshipFields = relationshipFields;
		this.relationshipObject = relationshipObject;
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

	public String getRelationshipFields() {
		return relationshipFields;
	}

	public void setRelationshipFields(String relationshipFields) {
		this.relationshipFields = relationshipFields;
	}
	
	
}
