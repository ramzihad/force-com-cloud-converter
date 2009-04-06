package com.modelmetrics.cloudconverter.forceutil;

import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.modelmetrics.common.util.TestCaseWithDevOrg;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.FieldType;
import com.sforce.soap._2006._04.metadata.Metadata;

public class CreateExecutorCustomFieldTest extends TestCaseWithDevOrg {

	public void testAddLookup() throws Exception {
		
		CustomField field = new CustomField();
		field.setType(FieldType.Lookup);
		field.setReferenceTo("AAA__c");
		field.setFullName("MYTABLE__c.NEWLOOKUP1__c");
		field.setRelationshipName("AAAs");
		field.setRelationshipLabel("Lookup1");
		field.setLabel("Lookup1");
		
		Metadata m[] = new Metadata[] { field };
		
		
		new CreateExecutor(SalesforceSessionFactory.factory
				.build(this.salesforceCredentials).getMetadataService(),m).execute(); 
		
	}
}
