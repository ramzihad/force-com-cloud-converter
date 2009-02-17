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

public class DatabaseCredentialsBuilder {
//	public static DatabaseCredentials getMysqlSample() {
//		DatabaseCredentials dbCreds = new DatabaseCredentials();
//		dbCreds.setDatabaseName("test");
//		dbCreds.setDatabaseType("mysql");
//		dbCreds.setUsername("root");
//		dbCreds.setPassword("");
//		return dbCreds;
//	}

	public static DatabaseCredentials getDerbySample() {
		return DatabaseCredentialsBuilder.getSetInfo("derby",
				"jdbc:derby:./src/sampledbs/derby/sample1", "sa", "",
				"Select * from mytable");
	}

	public static DatabaseCredentials getDerbySampleComplex() {
		return DatabaseCredentialsBuilder.getSetInfo("derby",
				"jdbc:derby:./src/sampledbs/derby/sample2", "sa", "",
				"Select * from mytable");
	}
	
	public static DatabaseCredentials getSetInfo(String type, String name,
			String username, String password, String sql) {
		DatabaseCredentials dbCreds = new DatabaseCredentials();
		dbCreds.setDatabaseName(name);
		dbCreds.setDatabaseType(type);
		dbCreds.setUsername(username);
		dbCreds.setPassword(password);
		dbCreds.setSql(sql);
		return dbCreds;
	}

}
