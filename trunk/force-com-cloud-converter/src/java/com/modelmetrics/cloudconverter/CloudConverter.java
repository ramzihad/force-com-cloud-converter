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
 * CloudConverter.java - Move objects and data from your dirt based system to the Force.com cloud.
 * 
 * @author reidcarlberg - rcarlberg@modelmetrics.com
 * 
 * History
 * 
 * Originally adapted from a Salesforce.com provided meta data sample.  Then heavily refactored.
 * 
 */
package com.modelmetrics.cloudconverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.util.SalesforceCredentialsBuilder;
import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;

public class CloudConverter {

	private static final Log log = LogFactory.getLog(CloudConverter.class);

	static BufferedReader rdr = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) throws Exception {
		// RunUISWTInterface wind = new RunUISWTInterface();
		// wind.runUI();

		System.out.println("Force.com CloudConverter by Model Metrics Inc.");
		System.out
				.println("Create objects, customize the default layout and move data in one quick step.");
		System.out
				.println("This utility offered AS IS without warranty or support of any kind.\n\n");
		System.out
				.println("*****\nThis is an example script. Edit the class CloudConverterScript to create your own.\nBe sure to read ReadMe.txt.\n*****\n");

		CloudConverter samples1 = new CloudConverter();

		try {
			samples1.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// RSC 2009-01-04 This is included from the original SFDC provided sample file.
	// The sample client application retrieves the user's login credentials.
	// Helper function for retrieving user input from the console
	String getUserInput(String prompt) {
		System.out.print(prompt);
		try {
			return rdr.readLine();
		} catch (IOException ex) {
			return null;
		}
	}

	/**
	 * The login call is used to obtain a token from Salesforce. This token must
	 * be passed to all other calls to provide authentication.
	 */
	private MigrationContext getMigrationContextWithSalesforceSession()
			throws ServiceException {
		System.out
				.println("Force.com credentials - first time you're running this? You should start with a DEV org.\n");

		String userName = getUserInput("Enter username: ");
		String password = getUserInput("Enter password: ");

		// SalesforceCredentials salesforceCredentials =
		// SalesforceCredentialsBuilder
		// .getReidsDevOrg();

		SalesforceCredentials salesforceCredentials = new SalesforceCredentialsBuilder()
				.getAnyOrg(userName, password);

		SalesforceSession salesforceSession = new SalesforceSessionFactory()
				.build(salesforceCredentials);

		MigrationContext migrationContext = new MigrationContext();
		migrationContext.setSalesforceSession(salesforceSession);
		migrationContext.setSalesforceCredentials(salesforceCredentials);

		return migrationContext;

	}

	private void run() throws ServiceException {

		MigrationContext migrationContext = getMigrationContextWithSalesforceSession();

		log.debug("Migration context initialized...");

		String runType = getUserInput("Enter dirt db type (Fist time? Use 'derby'.) ('derby', 'hsql', 'notes','mysql'): ");

		// MigrationEngine engine = new MigrationEngine();
		MigrationEngineIF engine = new MigrationEngineFactory().build(runType);

		engine.setMigrationContext(migrationContext);

		try {

			engine.execute();
		} catch (Exception e) {
			log.error("Error executing migration", e);
		}

		log.debug("Cloud Converter execution complete.");
	}
}
