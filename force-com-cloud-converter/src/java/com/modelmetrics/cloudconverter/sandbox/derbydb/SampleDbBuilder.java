package com.modelmetrics.cloudconverter.sandbox.derbydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleDbBuilder {

	public static void main(String[] args) throws Exception {
		try {
			new SampleDbBuilder().execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void execute() throws Exception {
		
		Class.forName("org.hsqldb.jdbcDriver" );
		
		Connection c = DriverManager.getConnection("org.apache.derby.jdbc.EmbeddedDriver", "sa", "");
		
		String sqlCreateTable = "CREATE CACHED TABLE MyTable (myname varchar(50));";

//		  (id int(11) NOT NULL," +
//					"name varchar(50) NOT NULL, " +
//					"birthdate date default NULL, " + 
//					"dog_count int(11) NOT NULL, " + 
//					"favoriteColor varchar(10) NOT NULL)
		
		Statement s = c.createStatement();
		
		s.execute(sqlCreateTable);
		
		s.close();
		
		s = c.createStatement();
		
		s.execute("Insert into MyTable (myname) values ('Reid');");
		s.execute("Insert into MyTable (myname) values ('Sachin');");
		s.execute("Insert into MyTable (myname) values ('Ken');");
		
		
		
		ResultSet rs = s.executeQuery("SELECT * FROM MyTable;");
		
		while (rs.next()) {
			System.out.println(rs.getString("myname"));
		}
		
		rs.close();
		
		s.close();
		
		c.close();
		
	}
}
