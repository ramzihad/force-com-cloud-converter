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
package com.modelmetrics.cloudconverter.sandbox;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestNotesSqlOdbc {

    public static void main(String[] args) {
        try {

            Driver d = (Driver)Class.forName
            ("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
           Connection con = DriverManager.getConnection(
            "jdbc:odbc:NotesVacation","Reid Carlberg/modelmetrics","blah1234"
             );

//           String sql = "SELECT Vacation_Request.Date_Begin, Vacation_Request.Date_Ends FROM Vacation_Request Vacation_Request";
           
           
           String sql = "SELECT Vacation_Request.Date_Begin, Vacation_Request.Date_Ends, Vacation_Request.Department, Vacation_Request.\"From\", Vacation_Request.Manager, Vacation_Request.Notes, Vacation_Request.Status, Vacation_Request.Approval_Status FROM Vacation_Request Vacation_Request";
           
   		System.out.println("Connected!");

		Statement statement = con.createStatement();

		ResultSet rs = statement.executeQuery(sql);

		System.out.println("Selected!" + rs.getMetaData().getColumnCount());

		ResultSetMetaData rsmd = rs.getMetaData();
		
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			
			System.out.println(rsmd.getColumnName(i+1) + ", Type:" + rsmd.getColumnType(i+1) + ", Prec: " + rsmd.getPrecision(i+1));
			
		}

			// CustomObject co = new CustomObjectBuilder().build(rsmd);
			//		
			// new
			// CreateExecutor(this.getMigrationContext().getMetadataBindingStub(),
			// new CustomObject[] { co })
			// .execute();
			//
			// CustomField[] fields = new CustomFieldBuilder().build(co, rsmd);

		rs.close();
		statement.close();
		con.close();
           
           
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
