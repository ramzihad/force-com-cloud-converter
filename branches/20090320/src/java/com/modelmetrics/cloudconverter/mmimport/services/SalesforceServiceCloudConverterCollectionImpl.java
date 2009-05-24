package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.MigrationContextFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineFactory;
import com.modelmetrics.cloudconverter.engine.MigrationEngineIF;
import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;

public class SalesforceServiceCloudConverterCollectionImpl extends
		AbstractSalesforceService {

	public void execute(UploadContext uploadContext) throws Exception {

		MigrationContext migrationContext = new MigrationContextFactory()
				.buildMigrationContext(this.getSalesforceSession());

		for (CloudConverterObject current : uploadContext
				.getCloudConverterObjects()) {

			migrationContext.setCloudConverterObject(current);
			MigrationEngineIF migrationEngineIF = new MigrationEngineFactory()
					.build(migrationContext);
			migrationEngineIF.execute();

		}

	}

}
