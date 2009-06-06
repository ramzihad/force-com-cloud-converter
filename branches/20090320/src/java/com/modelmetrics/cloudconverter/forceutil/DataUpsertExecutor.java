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
package com.modelmetrics.cloudconverter.forceutil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cc.importxls.svcs.ExcelWorksheetWrapperBean;
import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.modelmetrics.common.sforce.dao.Sproxy;


public class DataUpsertExecutor extends AbstractDataExecutor {

	private static final Log log = LogFactory.getLog(DataInsertExecutor.class);

	public void execute(MigrationContext migrationContext) throws Exception {
		try {
			if (migrationContext.getResultSet() == null
					&& migrationContext.getWrapperBean() == null) {
				throw new RuntimeException(
						"no result set and no wrapper bean ERGO no sproxy building bonanza.");
			} else if (migrationContext.getResultSet() != null) {
				this.executeWithResultSet(migrationContext);
			} else {
				this.executeWithWrapper(migrationContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}

	public void executeWithResultSet(MigrationContext migrationContext)
			throws Exception {

		log.debug("starting data transfer (upsert)...");

		dao.setSalesforceSession(migrationContext.getSalesforceSession());

		Collection<Sproxy> toUpsert = new ArrayList<Sproxy>();

		ResultSet rs = migrationContext.getResultSet();
		ResultSetMetaData rsmd = migrationContext.getResultSetMetaData();

		if (rs == null) {
			log.info("result set is null");
		}

		while (rs.next()) {

			Sproxy current = sproxyBuilder.buildEmpty(migrationContext
					.getCustomObject().getFullName());

			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				current.setValue(migrationContext.getFieldMap().get(
						rsmd.getColumnName(i + 1)), rs.getObject(i + 1));
			}

			toUpsert.add(current);

			if (toUpsert.size() == MAX_SPROXY_BATCH_SIZE) {
				dao.upsert(migrationContext.getExternalIdForUpsert(), toUpsert);
				toUpsert = new ArrayList<Sproxy>();
			}

		}

		log.debug("starting the upsert..."
				+ migrationContext.getExternalIdForUpsert());

		dao.upsert(migrationContext.getExternalIdForUpsert(), toUpsert);

		log.debug("insert complete...");

	}

	public void executeWithWrapper(MigrationContext migrationContext)
			throws Exception {

		log.debug("starting data transfer (upsert)...");

		dao.setSalesforceSession(migrationContext.getSalesforceSession());

		Collection<Sproxy> toUpsert = new ArrayList<Sproxy>();

		// ResultSet rs = migrationContext.getResultSet();
		// ResultSetMetaData rsmd = migrationContext.getResultSetMetaData();

		ExcelWorksheetWrapperBean wrapperBean = migrationContext
				.getWrapperBean();

		for (Iterator<List<Object>> iterator = wrapperBean.getData().iterator(); iterator
				.hasNext();) {
			List<Object> type = (List<Object>) iterator.next();
			Sproxy current = sproxyBuilder.buildEmpty(migrationContext
					.getCustomObject().getFullName());
			int i = 0;
			for (Iterator<MetadataProxy> iterator2 = migrationContext
					.getMetadataProxies().iterator(); iterator2.hasNext();) {
				MetadataProxy metadataProxy = iterator2.next();

				if (type.size() < i + 1 || type.get(i) == null) {
					current.setNull(migrationContext.getFieldMap().get(
							metadataProxy.getName()));
				} else {
					current.setValue(migrationContext.getFieldMap().get(
							metadataProxy.getName()), type.get(i));
				}
				
				/*
				 * some work for names that aren't about autonumber
				 */
				if (!migrationContext.getCloudConverterObject().isNameUseAutonumber()) {
					if (metadataProxy.getName().equalsIgnoreCase(migrationContext.getCloudConverterObject().getNameUseField())) {
						current.setValue("Name", type.get(i));
					}
				}


				i++;
			}

			toUpsert.add(current);

			if (toUpsert.size() == MAX_SPROXY_BATCH_SIZE) {
				migrationContext.getMigrationStatusPublisher().publishStatus(
						"executing data insert");
				dao.upsert(migrationContext.getExternalIdForUpsert(),toUpsert);
				toUpsert = new ArrayList<Sproxy>();
			}
		}

		log.debug("starting the insert...");

		dao.upsert(migrationContext.getExternalIdForUpsert(),toUpsert);

		log.debug("insert complete...");

	}

}
