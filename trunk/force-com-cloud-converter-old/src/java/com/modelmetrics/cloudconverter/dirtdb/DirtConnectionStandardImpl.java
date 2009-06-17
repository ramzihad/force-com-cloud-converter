package com.modelmetrics.cloudconverter.dirtdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class DirtConnectionStandardImpl extends AbstractDirtConnection {

	public DirtConnectionStandardImpl(DatabaseCredentials databaseCredentials) {
		this.setDatabaseCredentials(databaseCredentials);
		
		if (databaseCredentials.getDriverName() == null) {
			throw new RuntimeException("can't use standard impl with a blank driver name");
		}
		
		if (databaseCredentials.getDatabaseName().indexOf("jdbc:") == -1) {
			throw new RuntimeException("database name needs to be fully qualified -- it must start with 'jdbc:', include the driver and the actual database name.");
		}
		
		try {
			Class.forName(databaseCredentials.getDriverName()).newInstance();
			
			Connection con = DriverManager.getConnection(databaseCredentials.getDatabaseName(), databaseCredentials.getUsername(), databaseCredentials
					.getPassword());

			this.setConnection(con);

			this.setSql(databaseCredentials.getSql());
			
			this.setDriver(databaseCredentials.getDriverName());
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to initialze dirt connection based on the info in your database credentials", e);
		}
		
	}
	
}
