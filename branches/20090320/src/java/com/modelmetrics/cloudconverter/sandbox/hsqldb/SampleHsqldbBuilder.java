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
package com.modelmetrics.cloudconverter.sandbox.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleHsqldbBuilder {

	public static void main(String[] args) throws Exception {
		try {
			new SampleHsqldbBuilder().execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void execute() throws Exception {
		
		Class.forName("org.hsqldb.jdbcDriver" );
		
		Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "sa", "");
		
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
