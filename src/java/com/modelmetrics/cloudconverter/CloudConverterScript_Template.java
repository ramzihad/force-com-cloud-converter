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

/**
 * CloudConverterScript.java - Move objects and data from your dirt based system to the Force.com cloud.
 * 
 * @author reidcarlberg - rcarlberg@modelmetrics.com
 * 
 * The idea is that this script is something each user can setup with their own dirtdb and salesforce / force.com orgs.
 * 
 */
package com.modelmetrics.cloudconverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.modelmetrics.cloudconverter.dirtdb.DatabaseCredentials;
import com.modelmetrics.cloudconverter.dirtdb.DirtConnectionFactory;
import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.engine.PicklistProvider;
import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.util.SalesforceCredentialsBuilder;
import com.modelmetrics.common.sforce.SalesforceCredentials;

/**
 * CloudConverterScript Template
 * 
 * Use this to create your own scripts.
 * 
 * @author reidcarlberg
 * 
 */
public class CloudConverterScript_Template {

	public static void main(String[] args) throws Exception {

		CloudConverterScript_Template script = new CloudConverterScript_Template();

		try {
			script.execute("yourUsername@yourDomain.com",
					"yourpasswordYOURSECURITYTOKEN");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void execute(String sfdcUsername, String sfdcPassword)
			throws Exception {

		/*
		 * The following are optional components. -- they can be empty but not
		 * null.
		 */
		// setup some known field characteristics -- will be used during custom
		// object creation
		// if there are no picklists you can leave this blank
		Map<String, PicklistProvider> picklistFields = new HashMap<String, PicklistProvider>();
		// key should be the fieldname, value should be the sql the gives you a
		// list of picklist values
		//picklistFields.put("MYPICKLIST",
		//		"select distinct mypicklist from mytable");

		// if there are not external ids, you can leave this blank
		Collection<String> externalIds = new ArrayList<String>();
		// these should be unique strings
		//externalIds.add("MYID");

		/*
		 * ****************************************************************
		 * You should change this to match your target dev org OR
		 * implement an object that works with this.  See specs above.
		 * ****************************************************************
		 */
		// if there are no lookups to other objects, you can leave this blank
		Map<String, LookupSettings> lookupFields = new HashMap<String, LookupSettings>();
		// key should be the field name, value should be how to resolve that on
		// sfdc (object__r:externalObjectName:externalidfieldname)
		//lookupFields.put("MYLOOKUP", new LookupSettings("MYLOOKUP", "AAA__c",
		//		"MYLOOKUP__r:AAA__c:TestExternalId__c"));

		/*
		 * ****************************************************************
		 * the following are required components
		 * ****************************************************************
		 */
		
		/*
		 * ****************************************************************
		 *  setup connection to the dirt db
		 * ****************************************************************
		 */  
		//DatabaseCredentials databaseCredentials = new DatabaseCredentials(
		//		"derby", DatabaseCredentials.DRIVER_DERBY,
		//		"jdbc:derby:./src/sampledbs/derby/sample2", "sa", "",
		//		"Select * from mytable");
		DatabaseCredentials databaseCredentials = null;

		/*
		 * ****************************************************************
		 * setup connection to the salesforce.com / force.com org
		 * FIRST TIME? Start with a DEV org.
		 * ****************************************************************
		 */
		// SalesforceCredentials salesforceCredentials = new
		// SalesforceCredentialsBuilder()
		// .getAnyOrg("your_dev_org@yourdomain.com", "yourpassword");
		SalesforceCredentials salesforceCredentials = new SalesforceCredentialsBuilder()
				.getAnyOrg(sfdcUsername, sfdcPassword);
		
		
		/*
		 * ****************************************************************
		 * The main context and engine.
		 * ****************************************************************
		 */
		// build the context
		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(salesforceCredentials);

		// add field traits to the context
		migrationContext.setLookupFields(lookupFields);
		migrationContext.setExternalIds(externalIds);
		migrationContext.setPicklistFields(picklistFields);
		migrationContext.setDirtConnection(new DirtConnectionFactory()
				.build(databaseCredentials));

		/*
		 * ****************************************************************
		 * If you are upserting, you need to specify which external ID
		 * you want to upsert on.  If you are not upserting you can leave
		 * this null.
		 * ****************************************************************
		 */
		// external id
		//migrationContext.setExternalIdForUpsert("MYID__c");

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build(migrationContext);

		migrationEngineIF.setMigrationContext(migrationContext);

		// execute it.
		migrationEngineIF.execute();

	}
}
