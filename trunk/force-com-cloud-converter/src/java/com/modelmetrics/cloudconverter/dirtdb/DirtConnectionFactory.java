package com.modelmetrics.cloudconverter.dirtdb;

public class DirtConnectionFactory {

	public DirtConnectionIF build(DatabaseCredentials databaseCredentials) {
		
		DirtConnectionIF ret = null;
		
		if (databaseCredentials.getDriverName() != null) {
			ret = new DirtConnectionStandardImpl(databaseCredentials);
		} else {
			throw new RuntimeException("database type not recognized -- " + databaseCredentials.getDatabaseType());
		}
		
		return ret;
	}
}
