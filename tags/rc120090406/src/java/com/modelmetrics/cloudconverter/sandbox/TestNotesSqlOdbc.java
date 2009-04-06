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
