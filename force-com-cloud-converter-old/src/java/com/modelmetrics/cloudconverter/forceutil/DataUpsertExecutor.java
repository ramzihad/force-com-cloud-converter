package com.modelmetrics.cloudconverter.forceutil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.common.sforce.dao.Sproxy;

public class DataUpsertExecutor extends AbstractDataExecutor {

	private static final Log log = LogFactory.getLog(DataInsertExecutor.class);

	public void execute(MigrationContext migrationContext) throws Exception {

		log.debug("starting data transfer (upsert)...");
		
		dao.setSalesforceSession(migrationContext.getSalesforceSession());
		
		Collection<Sproxy> toUpsert = new ArrayList<Sproxy>();
		
		ResultSet rs = migrationContext.getResultSet();
		ResultSetMetaData rsmd = migrationContext.getResultSetMetaData();
		
		if (rs == null) {
			log.info("result set is null");
		}
		
		while (rs.next()) {
			
			Sproxy current = sproxyBuilder.buildEmpty(migrationContext.getCustomObject().getFullName());
			
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				current.setValue(migrationContext.getFieldMap().get(rsmd.getColumnName(i+1)), rs.getObject(i+1));
			}
		
			toUpsert.add(current);

			if (toUpsert.size() == MAX_SPROXY_BATCH_SIZE) {
				dao.upsert(migrationContext.getExternalIdForUpsert(), toUpsert);
				toUpsert = new ArrayList<Sproxy>();
			}
			
		}
		
		log.debug("starting the upsert..." + migrationContext.getExternalIdForUpsert());
		
		dao.upsert(migrationContext.getExternalIdForUpsert(), toUpsert);
		
		log.debug("insert complete...");
		


	}

}
