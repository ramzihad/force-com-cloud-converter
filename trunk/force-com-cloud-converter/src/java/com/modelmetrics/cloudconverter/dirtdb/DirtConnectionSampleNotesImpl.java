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

/**
 * DirtConnectionSampleNotesImpl.java -- a connection to a Lotus Notes ODBC provider.
 * 
 * @author Reid Carlberg rcarlberg@modelmetrics.com
 * 
 * For this to work, you need to have a Lotus Notes client installed on the running machine as well as NoteSQL.  NoteSQL 
 * creates a handy ODBC data connection which you can query and then inspect the results for metadata.
 * 
 */


package com.modelmetrics.cloudconverter.dirtdb;

import java.sql.Connection;
import java.sql.DriverManager;


public class DirtConnectionSampleNotesImpl implements DirtConnectionIF {

	private Connection connection;
	
	private String sql;
	
	public DirtConnectionSampleNotesImpl() {
		
		try {
	       Class.forName
	        (DatabaseCredentials.DRIVER_JDBC_ODBC).newInstance();
	       Connection con = DriverManager.getConnection(
	        "jdbc:odbc:NotesVacation","Reid Carlberg/modelmetrics","blah1234"
	         );
	       
	       this.connection = con;

		} catch (Exception e) {
			throw new RuntimeException("Failed in initialization",e);
		}
//	       String sql = "SELECT Vacation_Request.Date_Begin, Vacation_Request.Date_Ends FROM Vacation_Request Vacation_Request";
	       
	       
	       this.sql = "SELECT Vacation_Request.Date_Begin, Vacation_Request.Date_Ends, Vacation_Request.Department, Vacation_Request.\"From\", Vacation_Request.Manager, Vacation_Request.Notes, Vacation_Request.Status, Vacation_Request.Approval_Status FROM Vacation_Request Vacation_Request";

		
	}
	
	public DirtConnectionSampleNotesImpl(DatabaseCredentials dbCreds) {
		
		try {
	       Class.forName
	        ("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
	       Connection con = DriverManager.getConnection(
	        "jdbc:odbc:"+dbCreds.getDatabaseName(),dbCreds.getUsername(),dbCreds.getPassword()
	         );
	       
	       this.connection = con;

		} catch (Exception e) {
			throw new RuntimeException("Failed in initialization",e);
		}
	       this.sql = "SELECT Vacation_Request.Date_Begin, Vacation_Request.Date_Ends, Vacation_Request.Department, Vacation_Request.\"From\", Vacation_Request.Manager, Vacation_Request.Notes, Vacation_Request.Status, Vacation_Request.Approval_Status FROM Vacation_Request Vacation_Request";
	}
	
	public Connection getConnection() {
		return this.connection;
	}

	public String getSql() {
		return this.sql;
	}

}
