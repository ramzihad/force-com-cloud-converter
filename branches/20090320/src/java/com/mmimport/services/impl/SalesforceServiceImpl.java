package com.mmimport.services.impl;

import com.mmimport.beans.WrapperBean;
import com.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.common.sforce.SalesforceCredentials;

public class SalesforceServiceImpl implements SalesforceService {

	protected SalesforceCredentials salesforceCredentials;

	public void execute(WrapperBean bean, String username, String password)
			throws Exception {

		salesforceCredentials.setUsername(username);
		salesforceCredentials.setPassword(password);
		
		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(salesforceCredentials);

		migrationContext.setWrapperBean(bean);
		
		MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
				.build();

		migrationEngineIF.setMigrationContext(migrationContext);

		// execute it.
		migrationEngineIF.execute(bean);
	}

	public void setSalesforceCredentials(
			SalesforceCredentials salesforceCredentials) {
		this.salesforceCredentials = salesforceCredentials;
	}
}
