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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.common.sforce.dao.SalesforceDAO;
import com.modelmetrics.common.sforce.dao.Sproxy;
import com.modelmetrics.common.sforce.dao.SproxyBuilder;

public class InsertExecutor implements DataExecutor {

	private static final Log log = LogFactory.getLog(InsertExecutor.class);
	
	public void execute(MigrationContext migrationContext) throws Exception {
		
		log.debug("starting data transfer (insert)...");
		
		SalesforceDAO dao = new SalesforceDAO();
		dao.setSalesforceSession(migrationContext.getSalesforceSession());
		
		Collection<Sproxy> toInsert = new ArrayList<Sproxy>();
		
		ResultSet rs = migrationContext.getResultSet();
		ResultSetMetaData rsmd = migrationContext.getResultSetMetaData();
		
		SproxyBuilder sproxyBuilder = new SproxyBuilder();
		
		if (rs == null) {
			log.info("result set is null");
		}
		
		while (rs.next()) {
			
			Sproxy current = sproxyBuilder.buildEmpty(migrationContext.getCustomObject().getFullName());
			
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				current.setValue(migrationContext.getFieldMap().get(rsmd.getColumnName(i+1)), rs.getObject(i+1));
			}
		
			toInsert.add(current);
			
			
		}
		
		log.debug("starting the insert...");
		
		dao.insert(toInsert);
		
		log.debug("insert complete...");
		
		
	}
}
