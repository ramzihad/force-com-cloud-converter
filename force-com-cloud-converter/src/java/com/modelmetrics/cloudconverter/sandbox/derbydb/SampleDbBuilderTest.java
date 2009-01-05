package com.modelmetrics.cloudconverter.sandbox.derbydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.modelmetrics.common.util.TestCaseWithLog;

import junit.framework.TestCase;

public class SampleDbBuilderTest extends TestCaseWithLog {

	String[] sqls = new String[] {
			"Create table mytable (myname varchar(5), mynumber int, mydate date, mytimestamp timestamp, mylongtext long varchar)",
			"INSERT INTO mytable VALUES ('Reid',5,'2008-11-10','2008-12-30 10:15:00.0', 'this is a long var char')",
			"INSERT INTO mytable VALUES ('Bob',10,'2008-11-11','2008-12-31 10:25:00.0', 'this is another long var char')",
			"INSERT INTO mytable VALUES ('Jerry',10500,'2008-11-12','2009-01-01 10:35:00.0', 'this is yet another long var char')" };

	public void testPreviousData() throws Exception {

		// new SampleHsqldbBuilder().execute();

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		// Connection c =
		// DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "sa",
		// "");

		Connection c = DriverManager.getConnection(
				"jdbc:derby:./src/sampledbs/derby/sample1;create=true", "sa",
				"");

		Statement s = c.createStatement();

		for (int i = 0; i < sqls.length; i++) {
			try {
				s.execute(sqls[i]);
			} catch (Exception e) {
				log.debug(sqls[i]);
				throw e;
			}
		}

		ResultSet rs = s.executeQuery("SELECT * FROM MyTable");

		while (rs.next()) {
			System.out.println(rs.getString("myname"));
		}

		rs.close();

		s.close();

		c.close();
	}
}
