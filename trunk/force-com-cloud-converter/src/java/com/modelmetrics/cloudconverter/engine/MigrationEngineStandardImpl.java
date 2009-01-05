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

package com.modelmetrics.cloudconverter.engine;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.dirtdb.DirtConnectionIF;
import com.modelmetrics.cloudconverter.forceutil.CreateExecutor;
import com.modelmetrics.cloudconverter.forceutil.CustomFieldBuilder;
import com.modelmetrics.cloudconverter.forceutil.CustomObjectBuilder;
import com.modelmetrics.cloudconverter.forceutil.CustomTabBuilder;
import com.modelmetrics.cloudconverter.forceutil.InsertExecutor;
import com.modelmetrics.cloudconverter.forceutil.LayoutBuilder;
import com.modelmetrics.cloudconverter.forceutil.UpdateExecutor;
import com.modelmetrics.cloudconverter.sandbox.DefaultPageLayoutFinder;
import com.modelmetrics.cloudconverter.util.AbstractMigrationEngine;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.CustomTab;
import com.sforce.soap._2006._04.metadata.Layout;

public class MigrationEngineStandardImpl extends AbstractMigrationEngine {

	private static final Log log = LogFactory
			.getLog(MigrationEngineStandardImpl.class);

	private DirtConnectionIF engineConnectorIF;

	public DirtConnectionIF getEngineConnectorIF() {
		return engineConnectorIF;
	}

	public void setEngineConnectorIF(DirtConnectionIF engineConnectorIF) {
		this.engineConnectorIF = engineConnectorIF;
	}

	public void execute() throws Exception {
		this.createCustomObject();
	}

	private void createCustomObject() throws Exception {
//		RunUISWTInterface.setLabelAndBar("Connecting to source", 20);
		if (this.getEngineConnectorIF() == null)
			log.debug("Connecting to source...");
		
//		RunUISWTInterface.setLabelAndBar("Creating Query Statement", 24);
		Statement statement = this.getEngineConnectorIF().getConnection()
				.createStatement();
//		RunUISWTInterface.setLabelAndBar("Getting Result Set from DB", 28);
		ResultSet rs = statement.executeQuery(this.getEngineConnectorIF()
				.getSql());
		
//		RunUISWTInterface.setLabelAndBar("Getting Column Count from DB", 32);
		log.debug("Source column count  "
				+ rs.getMetaData().getColumnCount());

//		RunUISWTInterface.setLabelAndBar("Setting up DB Metadata", 36);
		ResultSetMetaData rsmd = rs.getMetaData();

//		RunUISWTInterface.setLabelAndBar("Initialize new Salesforce Object", 40);
		CustomObject co = new CustomObjectBuilder().build(rsmd);

//		RunUISWTInterface.setLabelAndBar("Set Custom Object based on DB Table", 44);
		this.getMigrationContext().setResultSetMetaData(rsmd);

//		RunUISWTInterface.setLabelAndBar("Set DB Data into Custom Object", 48);
		this.getMigrationContext().setResultSet(rs);

//		RunUISWTInterface.setLabelAndBar("Finalize Object Creation", 52);
		this.getMigrationContext().setCustomObject(co);

//		RunUISWTInterface.setLabelAndBar("Reexecute Object Creation", 56);
		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService(), new CustomObject[] { co }).execute();

//		RunUISWTInterface.setLabelAndBar("Generating Fields for Object", 60);
		CustomField[] fields = new CustomFieldBuilder().build(this
				.getMigrationContext());

//		RunUISWTInterface.setLabelAndBar("Setting Fields in Object", 64);
		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService(), fields).execute();

		// reset the session
		// this.getMigrationContext().resetSession();

		// add a custom tab
		
//		RunUISWTInterface.setLabelAndBar("Creating Tab for Object", 68);
		CustomTab customTab = new CustomTabBuilder().build(co);
		log.debug("CustomTab - local definition complete - " + customTab.getFullName());

//		RunUISWTInterface.setLabelAndBar("Setting Tab into SFDC", 72);
		new CreateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService(), new CustomTab[] { customTab }).execute();

//		RunUISWTInterface.setLabelAndBar("Creating Layout for Object", 76);
		LayoutBuilder layoutBuilder = new LayoutBuilder();
		layoutBuilder.setMigrationContext(this.getMigrationContext());
		Layout layout = layoutBuilder.build();

//		RunUISWTInterface.setLabelAndBar("Setting Layout in SFDC", 80);
		new UpdateExecutor(this.getMigrationContext().getSalesforceSession()
				.getMetadataService()).executeSimpleUpdate(layout);

		// wait for 10 seconds
//		RunUISWTInterface.setLabelAndBar("Waiting for 10 sec", 80);
		log.debug("waiting for 10 seconds...");
		Thread.sleep(10000);

		// reset the session - if we don't the session won't see the fields it
		// needs to upsert to
//		RunUISWTInterface.setLabelAndBar("Resetting Session", 84);
		this.getMigrationContext().resetSession();

//		RunUISWTInterface.setLabelAndBar("Insert Data from Migration", 88);
		new InsertExecutor().execute(this.getMigrationContext());

		// go ahead and close out the DB
//		RunUISWTInterface.setLabelAndBar("Close Out Database Connection", 92);
		rs.close();
		statement.close();
		this.getEngineConnectorIF().getConnection().close();

		// reset the session again -
//		RunUISWTInterface.setLabelAndBar("Restarting Session", 96);
		this.getMigrationContext().resetSession();

//		RunUISWTInterface.setLabelAndBar("Verifying Creations", 99);
		new DefaultPageLayoutFinder(this.getMigrationContext()).getLayout();

	}

}
