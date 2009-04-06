package com.modelmetrics.cloudconverter.sandbox.derbydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.modelmetrics.common.util.TestCaseWithLog;

public class SampleDbTest extends TestCaseWithLog {

	public void testSelectDistinctSyntax() throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		// Connection c =
		// DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "sa",
		// "");

		Connection c = DriverManager.getConnection(
				"jdbc:derby:./src/sampledbs/derby/sample2;create=true", "sa",
				"");

Statement s0 = c.createStatement();
ResultSet rs0 = s0.executeQuery("select * from mytable");

		Statement s = c.createStatement();

		ResultSet rs = s.executeQuery("select distinct mypicklist from mytable");
		
		rs.close();
		
		s.close();

		rs0.close();
		
		s0.close();
		
		c.close();
	}
}
