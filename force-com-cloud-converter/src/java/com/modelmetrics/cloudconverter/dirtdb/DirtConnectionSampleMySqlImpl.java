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

package com.modelmetrics.cloudconverter.dirtdb;

import java.sql.Connection;
import java.sql.DriverManager;


public class DirtConnectionSampleMySqlImpl implements DirtConnectionIF {

	private Connection connection;

	private String sql;

	public DirtConnectionSampleMySqlImpl() {

		try {
			Class.forName(DatabaseCredentials.DRIVER_MYSQL).newInstance();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/test", "root", "");

			this.connection = con;

			this.sql = "Select * from table1";

		} catch (Exception e) {
			throw new RuntimeException("failed to initialize in constrcutor", e);
		}
	}
	
	public DirtConnectionSampleMySqlImpl(DatabaseCredentials dbCreds)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/"+dbCreds.getDatabaseName(), dbCreds.getUsername(), dbCreds.getPassword());

			this.connection = con;

			this.sql = "Select * from table1";

		} catch (Exception e) {
			throw new RuntimeException("failed to initialize in constrcutor", e);
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	public String getSql() {
		return this.sql;
	}

}
