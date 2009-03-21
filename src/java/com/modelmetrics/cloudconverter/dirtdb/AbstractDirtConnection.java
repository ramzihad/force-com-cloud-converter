package com.modelmetrics.cloudconverter.dirtdb;

import java.sql.Connection;

public abstract class AbstractDirtConnection implements DirtConnectionIF {

	private Connection connection;

	private String sql;
	
	private String driver;
	
	private DatabaseCredentials databaseCredentials;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public DatabaseCredentials getDatabaseCredentials() {
		return databaseCredentials;
	}

	public void setDatabaseCredentials(DatabaseCredentials databaseCredentials) {
		this.databaseCredentials = databaseCredentials;
	}

}
