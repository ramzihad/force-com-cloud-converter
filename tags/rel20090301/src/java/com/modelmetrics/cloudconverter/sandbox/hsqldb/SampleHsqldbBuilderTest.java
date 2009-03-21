package com.modelmetrics.cloudconverter.sandbox.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import junit.framework.TestCase;

public class SampleHsqldbBuilderTest extends TestCase {

	public void testPreviousData() throws Exception {
		
		//new SampleHsqldbBuilder().execute();
		
		Class.forName("org.hsqldb.jdbcDriver" );
		
		//Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "sa", "");
		
		Connection c = DriverManager.getConnection("jdbc:hsqldb:file:./src/sample-hsql-dbs/sample1/sampledb1", "sa", "");

		Statement s = c.createStatement();

		ResultSet rs = s.executeQuery("SELECT * FROM MyTable;");
		
		while (rs.next()) {
			System.out.println(rs.getString("myname"));
		}
		
		rs.close();
		
		s.close();
		
		c.close();
	}
}
