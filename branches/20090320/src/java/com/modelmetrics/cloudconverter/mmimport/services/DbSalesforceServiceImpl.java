package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.HashMap;
import java.util.Map;

import com.modelmetrics.cloudconverter.dirtdb.DatabaseCredentials;
import com.modelmetrics.cloudconverter.dirtdb.DirtConnectionFactory;
import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.mmimport.actions.DbUploadAction;
import com.modelmetrics.cloudconverter.mmimport.actions.PicklistInfo;
import com.modelmetrics.common.sforce.SalesforceSession;

public class DbSalesforceServiceImpl implements DbSalesforceService {

	private SalesforceSession salesforceSession;

	public void generateObjectFromDB(DbUploadAction action)
			throws Exception {

		Map<String, String> picklistFields = new HashMap<String, String>();
		for (PicklistInfo picklist : action.getPicklistInfos()) {
			picklistFields
					.put(picklist.getFieldName(), picklist.getSourceSql());
		}

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
