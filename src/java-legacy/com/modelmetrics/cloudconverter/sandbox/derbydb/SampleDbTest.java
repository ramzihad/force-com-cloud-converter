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
