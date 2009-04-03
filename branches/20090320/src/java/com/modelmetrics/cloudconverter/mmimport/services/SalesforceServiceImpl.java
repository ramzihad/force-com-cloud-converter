package com.modelmetrics.cloudconverter.mmimport.services;

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
import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.mmimport.actions.DbUploadAction;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.DescribeGlobalResult;

public class SalesforceServiceImpl implements SalesforceService {

	private SalesforceSession salesforceSession;

	public void execute(WrapperBean bean) throws Exception {

		// salesforceCredentials.setUsername(username);
		// salesforceCredentials.setPassword(password);

		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(this.getSalesforceSession());

		migrationContext.setWrapperBean(bean);

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build(migrationContext);

		migrationEngineIF.setMigrationContext(migrationContext);

		// execute it.
		migrationEngineIF.execute();
	}

	public boolean checkObject(WrapperBean bean) throws Exception {

		return containsObject(salesforceSession, bean.getSheetName());

	}

	private boolean containsObject(SalesforceSession salesforceSession,
			String objectName) throws Exception {
		DescribeGlobalResult result = salesforceSession.getSalesforceService()
				.describeGlobal();

		boolean foundType = false;
		objectName += "__c";
		for (int i = 0; i < result.getTypes().length; i++) {
			String name = result.getTypes(i);
			if (name.equalsIgnoreCase(objectName)) {
				foundType = true;
			}
		}

		return foundType;
	}

	public void generateObjectFromDB(DbUploadAction action, String path) throws Exception {

		String[] picklists = action.getPicklistFields().split(",|;");
		Map<String, String> picklistFields = new HashMap<String, String>();
		for (String picklist : picklists) {
			picklistFields.put(picklist, "select distinct " + picklist
					+ " from " + action.getDbTable());
		}

		String[] ids = action.getExternalIds().split(",|;");
		Collection<String> externalIds = new ArrayList<String>();
		for (String id : ids) {
			externalIds.add(id);
		}

		String[] lookfields = action.getLookupFields().split(",|;");
		Map<String, LookupSettings> lookupFields = new HashMap<String, LookupSettings>();
		for (String lookfield : lookfields) {
			lookupFields.put(lookfield, new LookupSettings(lookfield,
					"AAA__c", lookfield+"__r:AAA__c:TestExternalId__c"));
		}

		String driver = "";
		if ("derby".equalsIgnoreCase(action.getDbName())) {
			driver = DatabaseCredentials.DRIVER_DERBY;
		} else if ("mysql".equalsIgnoreCase(action.getDbName())) {
			driver = DatabaseCredentials.DRIVER_MYSQL;
		} else if ("odbc".equalsIgnoreCase(action.getDbName())) {
			driver = DatabaseCredentials.DRIVER_JDBC_ODBC;
		}

		String dbUrl = "jdbc:derby:";
		dbUrl+=path+"sampledbs/";
		dbUrl+=action.getDbUrl();
		DatabaseCredentials databaseCredentials = new DatabaseCredentials(
				action.getDbName(), driver, dbUrl, action
						.getDbUser(), action.getDbPassword(), "select * from "
						+ action.getDbTable());

		// build the context
		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(this.getSalesforceSession());

		// add field traits to the context
		migrationContext.setLookupFields(lookupFields);
		migrationContext.setExternalIds(externalIds);
		migrationContext.setPicklistFields(picklistFields);
		migrationContext.setDirtConnection(new DirtConnectionFactory()
				.build(databaseCredentials));

		// external id
		//TODO: what id goes here?
		migrationContext.setExternalIdForUpsert(ids[0]+"_c");

		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build(migrationContext);

		migrationEngineIF.setMigrationContext(migrationContext);

		// execute it.
		migrationEngineIF.execute();

	}

	public SalesforceSession getSalesforceSession() {
		return salesforceSession;
	}

	public void setSalesforceSession(SalesforceSession salesforceSession) {
		this.salesforceSession = salesforceSession;
	}

}
