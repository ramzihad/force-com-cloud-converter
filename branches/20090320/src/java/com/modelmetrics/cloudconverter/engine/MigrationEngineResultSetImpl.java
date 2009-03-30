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
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.forceutil.CreateExecutor;
import com.modelmetrics.cloudconverter.forceutil.CustomFieldBuilder;
import com.modelmetrics.cloudconverter.forceutil.CustomObjectBuilder;
import com.modelmetrics.cloudconverter.forceutil.CustomTabBuilder;
import com.modelmetrics.cloudconverter.forceutil.DataInsertExecutor;
import com.modelmetrics.cloudconverter.forceutil.DataUpsertExecutor;
import com.modelmetrics.cloudconverter.forceutil.DeleteExecutor;
import com.modelmetrics.cloudconverter.forceutil.LayoutBuilder;
import com.modelmetrics.cloudconverter.forceutil.UpdateExecutor;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.modelmetrics.cloudconverter.util.MetadataProxyCollectionBuilder;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.CustomTab;
import com.sforce.soap._2006._04.metadata.Layout;

public class MigrationEngineResultSetImpl extends AbstractMigrationEngine {



	public void execute() throws Exception {
		this.createCustomObject();
	}


	private void createCustomObject() throws Exception {

		/*
		 * start by getting the basic DB connection
		 */
		Statement statement = this.getMigrationContext().getDirtConnection()
				.getConnection().createStatement();

		ResultSet rs = statement.executeQuery(this.getMigrationContext()
				.getDirtConnection().getSql());

		log.debug("Source column count  " + rs.getMetaData().getColumnCount());

		ResultSetMetaData rsmd = rs.getMetaData();

		/*
		 * 2009-03-21 RSC Eventually we'll want to avoid this -- right now we
		 * probably need to keep it.
		 */
		this.getMigrationContext().setResultSetMetaData(rsmd);

		/*
		 * 2009-03-21 RSC Convert that over to a MetadataProxy
		 */
		List<MetadataProxy> metadataProxies = new MetadataProxyCollectionBuilder()
				.build(rsmd);

		this.getMigrationContext().setMetadataProxies(metadataProxies);

		/*
		 * 2009-03-21 RSC //TODO rs should probably be a little more generic as
		 * well but not changing for right now.
		 */

		this.getMigrationContext().setResultSet(rs);

		/*
		 * build the basic custom object
		 */
		CustomObject co = new CustomObjectBuilder().build(rsmd);

		//in the super
		this.executeCommon(co);
		
		/*
		 * Move the data
		 */
		try {
			if (this.getMigrationContext().getExternalIdForUpsert() == null) {
				new DataInsertExecutor().execute(this.getMigrationContext());
			} else {
				new DataUpsertExecutor().execute(this.getMigrationContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		rs.close();
		statement.close();
		this.getMigrationContext().getDirtConnection().getConnection().close();

		this.pauseSession();

		// new DefaultPageLayoutFinder(this.getMigrationContext()).getLayout();

		log.info("complete");
	}

}
