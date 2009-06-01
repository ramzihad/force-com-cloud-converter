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
package com.modelmetrics.cloudconverter.dbimport.services;

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
import com.modelmetrics.cloudconverter.mmimport.services.PicklistInfo;
import com.modelmetrics.common.sforce.SalesforceSession;

public class DbSalesforceServiceImpl implements DbSalesforceService {

	private SalesforceSession salesforceSession;

	public void generateObjectFromDB(DbUploadAction action)
			throws Exception {

		Map<String, PicklistProvider> picklistFields = new HashMap<String, PicklistProvider>();
//		for (PicklistInfo picklist : action.getPicklistInfos()) {
//			picklistFields
//					.put(picklist.getFieldName(), picklist.getSourceSql());
//		}

		Map<String, LookupSettings> lookupFields = new HashMap<String, LookupSettings>();
		for (LookupSettings lookup : action.getLookupSettings()) {
			lookupFields.put(lookup.getLocalName(), lookup);
		}

		
		DatabaseCredentials databaseCredentials = new DatabaseCredentials(
				action.getDbTypeName(), action.getDbDriver(), action.getDbConnection(), action
						.getDbUser(), action.getDbPassword(), action
						.getDbSelect());

		// build the context
		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(this.getSalesforceSession());

		// add field traits to the context
		// migrationContext.setLookupFields(lookupFields);
		//migrationContext.setExternalIds(action.getExternalIds());
		migrationContext.setPicklistFields(picklistFields);
		migrationContext.setDirtConnection(new DirtConnectionFactory()
				.build(databaseCredentials));

		// external id
		// TODO: what id goes here?
		migrationContext.setExternalIdForUpsert(action.getExternalIds().get(0)
				+ "_c");

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build(migrationContext);

		migrationEngineIF.setMigrationContext(migrationContext);

		// execute it.
		migrationEngineIF.execute();

	}

	public void setSalesforceSession(SalesforceSession salesforceSession) {
		this.salesforceSession = salesforceSession;
	}

	public SalesforceSession getSalesforceSession() {
		return salesforceSession;
	}

}
