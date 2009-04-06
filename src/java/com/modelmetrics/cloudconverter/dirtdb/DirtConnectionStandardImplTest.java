package com.modelmetrics.cloudconverter.dirtdb;

import java.sql.ResultSet;

import com.modelmetrics.common.util.TestCaseWithLog;

public class DirtConnectionStandardImplTest extends TestCaseWithLog {

	public void testSample2Db() throws Exception {
		
		DatabaseCredentials databaseCredentials = new DatabaseCredentials
		("derby", DatabaseCredentials.DRIVER_DERBY, "jdbc:derby:./src/sampledbs/derby/sample2", "sa", "",
				"Select * from mytable");

		
		DirtConnectionStandardImpl conn = new DirtConnectionStandardImpl(databaseCredentials);

		log.debug("connected");
		
		assertNotNull(conn);
		
		ResultSet rs = conn.getConnection().createStatement().executeQuery("select * from mytable");
		
		log.debug("selected * ");
		
		ResultSet rs2 = conn.getConnection().createStatement().executeQuery("select distinct mypicklist2 from mytable");
		
		log.debug("select distinct");
		
		rs2.close();
		
		rs.close();
		
		conn.getConnection().close();
		
	}
}
