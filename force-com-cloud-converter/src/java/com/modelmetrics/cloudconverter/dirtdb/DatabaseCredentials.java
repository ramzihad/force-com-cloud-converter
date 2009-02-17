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

public class DatabaseCredentials 
{
	

	
	
	public static final String DRIVER_DERBY = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String DRIVER_JDBC_ODBC = "sun.jdbc.odbc.JdbcOdbcDriver";
	public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	
	private String databaseType;
	private String driverName;
	private String databaseName;
	private String username;
	private String password;
	private String sql;
	
	public DatabaseCredentials() {
		
	}
	
	public DatabaseCredentials(String databaseType, String databaseName, String username, String password, String sql) {
		this.setDatabaseType(databaseType);
		this.setDatabaseName(databaseName);
		this.setUsername(username);
		this.setPassword(password);
		this.setSql(sql);
	}
	
	public DatabaseCredentials(String databaseType, String driverName, String databaseName, String username, String password, String sql) {
		this.setDatabaseType(databaseType);
		this.setDriverName(driverName);
		this.setDatabaseName(databaseName);
		this.setUsername(username);
		this.setPassword(password);
		this.setSql(sql);
	}
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setDatabaseType(String _databaseType)
	{
		this.databaseType = _databaseType;
		if (_databaseType.equalsIgnoreCase("derby")) {
			this.setDriverName(DatabaseCredentials.DRIVER_DERBY);
		} else if (_databaseType.equalsIgnoreCase("odbc") || _databaseType.equalsIgnoreCase("notes")) {
			this.setDriverName(DatabaseCredentials.DRIVER_JDBC_ODBC);
		} else if (_databaseType.equalsIgnoreCase("mysql")) {
			this.setDriverName(DatabaseCredentials.DRIVER_MYSQL);
		} else {
			throw new RuntimeException("unsupported database type -- if you know the driver name, set the driver name and ignore database type.");
		}
	}
	
	public void setDatabaseName(String _databaseName)
	{
		this.databaseName = _databaseName;
	}
	
	public void setUsername(String _userName)
	{
		this.username = _userName;
	}
	
	public void setPassword(String _passWord)
	{
		this.password = _passWord;
	}
	
	public String getDatabaseType()
	{
		return databaseType;
	}
	
	public String getDatabaseName()
	{
		return databaseName;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}
