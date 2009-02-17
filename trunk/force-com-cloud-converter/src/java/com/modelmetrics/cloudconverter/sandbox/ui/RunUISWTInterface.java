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

package com.modelmetrics.cloudconverter.sandbox.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.CloudConverter;
import com.modelmetrics.cloudconverter.dirtdb.DatabaseCredentials;
import com.modelmetrics.common.sforce.SalesforceCredentials;

/**
 * this is on the //TODO list and is commented out for now.
 * 
 * @author reidcarlberg
 *
 */
public final class RunUISWTInterface implements ConverterStatusListenerIF {

	private static final Log log = LogFactory.getLog(CloudConverter.class);

	private SalesforceCredentials salesforceCredentials;
	private DatabaseCredentials dbCredentials;

	private final ConverterSettingsUI ui;

	public RunUISWTInterface() {
		ui = new ConverterSettingsUI(this);
	}

	public void runUI() {

	}

	// public void intializeProcess() {
	// try {
	// if (ui.getUsername().getText().length() > 0
	// && ui.getPassword().getText().length() > 0) {
	// salesforceCredentials = new SalesforceCredentialsBuilder().getAnyOrg(
	// ui.getUsername().getText(), ui.getPassword().getText());
	// } else {
	// // salesforceCredentials = SalesforceCredentialsBuilder
	// // .getReidsDevOrg();
	// }
	// if (ui.getSelections().getText().length() > 0) {
	// if (ui.getDatausername().getText().length() > 0
	// && ui.getDatabasename().getText().length() > 0) {
	// dbCredentials = DatabaseCredentialsBuilder.getSetInfo(ui
	// .getSelections().getText(), ui.getDatabasename()
	// .getText(), ui.getDatausername().getText(), ui
	// .getDatapassword().getText(), null);
	// runProcess(dbCredentials, salesforceCredentials);
	// } else {
	// dbCredentials = DatabaseCredentialsBuilder.getDefaultInfo();
	// runProcess(dbCredentials, salesforceCredentials);
	// }
	// }
	//
	// } catch (ServiceException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// }
	//
	// private void runProcess(DatabaseCredentials dbCredentials,
	// SalesforceCredentials sfCredentials) throws ServiceException {
	//
	// // setLabelAndBar("Logging into SFDC.....", 4);
	// MigrationContext migrationContext = new MigrationContextFactory()
	// .buildMigrationContext(sfCredentials);
	// // setLabelAndBar("Logged into SFDC", 8);
	// log.debug("Migration context initialized...");
	//
	// try {
	// // MigrationEngine engine = new MigrationEngine();
	// // setLabelAndBar("Logging into Database....", 12);
	// final MigrationEngineIF engine = new MigrationEngineFactory()
	// .build(dbCredentials);
	// // setLabelAndBar("Setting Migration Variables", 16);
	// engine.setMigrationContext(migrationContext);
	// // engine.execute();
	// new Thread() {
	// public void run() {
	// try {
	// engine.execute();
	// // setLabelAndBar("Done", 100);
	// log.debug("Sample migration runner complete.");
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// if (!Thread.currentThread().isInterrupted())
	// Thread.currentThread().interrupt();
	// }
	// }
	// }.start();
	//
	// } catch (Exception e) {
	// log.error("Error executing migration", e);
	// }
	// }

	public void setStatus(String status) {
		this.ui.setLabelAndBar(status, 26);

	}

	// static BufferedReader rdr = new BufferedReader(new InputStreamReader(
	// System.in));

}
