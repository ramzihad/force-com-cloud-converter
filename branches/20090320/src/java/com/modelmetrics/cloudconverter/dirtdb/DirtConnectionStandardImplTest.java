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
