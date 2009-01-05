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

import com.modelmetrics.cloudconverter.dirtdb.DatabaseCredentials;
import com.modelmetrics.cloudconverter.dirtdb.DatabaseCredentialsBuilder;
import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.util.SalesforceCredentialsBuilder;
import com.modelmetrics.common.sforce.SalesforceCredentials;

public class CloudConverterScript {

	public static void main(String[] args) throws Exception {

		CloudConverterScript script = new CloudConverterScript();

		try {
			script.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void execute() throws Exception {

		// setup connection to the dirt db
		DatabaseCredentials databaseCredentials = DatabaseCredentialsBuilder
				.getSetInfo("derby", "./src/sampledbs/derby/sample1", "sa", "",
						"Select * from mytable");

		// setup connection to the salesforce.com / force.com org
		// FIRST TIME? Start with a DEV org.
		SalesforceCredentials salesforceCredentials = new SalesforceCredentialsBuilder()
				.getAnyOrg("your_dev_org@yourdomain.com", "yourpassword");

		// build the context
		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(salesforceCredentials);

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build(databaseCredentials);

		migrationEngineIF.setMigrationContext(migrationContext);

		// execute it.
		migrationEngineIF.execute();

	}
}
