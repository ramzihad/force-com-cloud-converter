package com.modelmetrics.cloudconverter.dirtdb;

public class DirtConnectionFactory {

	public DirtConnectionIF build(DatabaseCredentials databaseCredentials) {
		
		DirtConnectionIF ret = null;
		
		if (databaseCredentials.getDatabaseType().equalsIgnoreCase("derby")) {
			ret= new DirtConnectionSampleDerbyOneImpl(databaseCredentials);
		} else if (databaseCredentials.getDatabaseType().equalsIgnoreCase("mysql")) {
			ret = new DirtConnectionSampleMySqlImpl(databaseCredentials);
		} else {
			throw new RuntimeException("database type not recognized -- " + databaseCredentials.getDatabaseType());
		}
		
		return ret;
	}
}
