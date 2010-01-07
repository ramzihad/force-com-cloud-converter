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
package com.modelmetrics.cloudconverter.forceutil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.modelmetrics.cloudconverter.util.OperationStatusPublisher;
import com.sforce.soap.partner.Field;

/*
 * 2009-04-15
 * 
 * checks to see if the metadata API reflects all the field changes.
 * 
 * useful since layout builder occasionally gets exceptions thrown at it.
 * 
 */
public class MetadataReadinessChecker {

	public boolean isMetadataReady(MigrationContext migrationContext)
			throws Exception {

		Field[] fields = migrationContext.getSalesforceSession()
				.getSalesforceService().describeSObject(
						migrationContext.getCustomObject().getFullName())
				.getFields();

		return this.isMetadataReady(migrationContext.getMetadataProxies(),
				fields, migrationContext.getMigrationStatusPublisher());
	}

	public boolean isMetadataReady(List<MetadataProxy> metadataProxies,
			Field[] fields, OperationStatusPublisher publisher)
			throws Exception {

		Set<String> potential = new TreeSet<String>();

		String knownFields = "knowns: ";
		
		for (int i = 0; i < fields.length; i++) {
			potential.add(fields[i].getName().toLowerCase());
			knownFields += ", " + fields[i].getName().toLowerCase();
		}

		boolean ret = true;

		for (Iterator<MetadataProxy> iterator = metadataProxies.iterator(); iterator
				.hasNext();) {
			MetadataProxy current = iterator.next();

			if (current.getExistingField() == null && !potential.contains(current.getName().toLowerCase() + "__c")) {
				if (publisher != null) {
					publisher.publishStatus("(still missing "
							+ current.getName().toLowerCase() + "__c; " + knownFields);
				}

				ret = false;
				break;
			}

		}

		return ret;

	}
}
