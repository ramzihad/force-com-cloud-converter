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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Provides SQL based values for PicklistValues.
 * 
 * @author reidcarlberg
 * @since 2009-05-25
 */
public class PicklistProviderSqlImpl implements PicklistProvider {

	private Log log = LogFactory.getLog(PicklistProviderSqlImpl.class);
	
	private Connection connection;
	
	private String sql;
	
	public PicklistProviderSqlImpl(Connection connection, String sql) {
		this.connection = connection;
		this.sql = sql;
	}
	
	public List<String> getPicklistValues() throws Exception {

		log.debug("dirtconnection? "
				+ connection.getClass().getName());

		Statement statement = connection.createStatement();

//		String sql = (String) migrationContext.getPicklistFields()
//				.get(current.getName());

		log.info("Picklist sql: " + sql);

		ResultSet rs = statement.executeQuery(sql);

		if (rs.getMetaData().getColumnCount() != 1) {
			rs.close();
			statement.close();
			throw new RuntimeException(
					"Column count not right on picklist; should be 1 but is "
							+ rs.getMetaData().getColumnCount());
		}
		ArrayList<String> values = new ArrayList<String>();

		while (rs.next()) {
			log.debug("picklist value is: " + rs.getString(1));
			values.add(rs.getString(1));
		}

		rs.close();
		statement.close();

		return values;
	
	
	}

}
