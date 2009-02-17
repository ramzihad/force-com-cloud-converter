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

package com.modelmetrics.cloudconverter.engine;

import com.modelmetrics.cloudconverter.dirtdb.DatabaseCredentials;
import com.modelmetrics.cloudconverter.dirtdb.DirtConnectionFactory;
import com.modelmetrics.cloudconverter.dirtdb.DirtConnectionSampleDerbyOneImpl;
import com.modelmetrics.cloudconverter.dirtdb.DirtConnectionSampleHsqlOneImpl;
import com.modelmetrics.cloudconverter.dirtdb.DirtConnectionSampleMySqlImpl;
import com.modelmetrics.cloudconverter.dirtdb.DirtConnectionSampleNotesImpl;

/**
 * builds migration engines. as of 2009-01-21 this may not be necessary since
 * there's only one migration engine type.  open ot input either way.
 * 
 * @author reidcarlberg
 * 
 */
public class MigrationEngineFactory {

	public MigrationEngineIF build() {
		return new MigrationEngineStandardImpl();
	}

//	public MigrationEngineIF build(DatabaseCredentials dbCreds) {
//		MigrationEngineStandardImpl ret2 = new MigrationEngineStandardImpl();
//
//		ret2.setDirtConnection(new DirtConnectionFactory().build(dbCreds));
//
//		return ret2;
//	}
}
