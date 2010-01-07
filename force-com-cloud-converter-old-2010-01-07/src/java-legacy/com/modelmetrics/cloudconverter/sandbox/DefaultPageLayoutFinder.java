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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.engine.AbstractMigrationContextAware;
import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.sforce.soap._2006._04.metadata.Layout;
import com.sforce.soap.partner.DescribeLayout;
import com.sforce.soap.partner.DescribeLayoutResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.RecordTypeInfo;

public class DefaultPageLayoutFinder extends AbstractMigrationContextAware {

	private static final Log log = LogFactory
			.getLog(DefaultPageLayoutFinder.class);

	public DefaultPageLayoutFinder(MigrationContext migrationContext) {
		this.setMigrationContext(migrationContext);
	}

	public Layout getLayout() throws Exception {

		DescribeSObjectResult[] results = this.getMigrationContext()
				.getSalesforceSession().getSalesforceService()
				.describeSObjects(
						new String[] { this.getMigrationContext()
								.getCustomObject().getFullName() });

		log.debug("Describe sobject results in");

		if (results.length != 1) {
			throw new RuntimeException(
					"Describe SObjects has the wrong number of results - should be one - is "
							+ results.length);
		}

		if (results[0].getRecordTypeInfos().length != 1) {
			throw new RuntimeException(
					"Wrong number of record types - should be one - is "
							+ results[0].getRecordTypeInfos().length);
		}

		RecordTypeInfo recordTypeInfo = results[0].getRecordTypeInfos()[0];

		log.debug("RecordTypeInfo " + recordTypeInfo.getName() + ", "
				+ recordTypeInfo.getRecordTypeId());

		DescribeLayoutResult describeLayoutResult = this.getMigrationContext()
				.getSalesforceSession().getSalesforceService().describeLayout(
						this.getMigrationContext().getCustomObject()
								.getFullName(),
						new String[] { recordTypeInfo.getRecordTypeId() });

		log.debug("DescribeLayoutResult " + describeLayoutResult.toString());

		if (describeLayoutResult.getLayouts().length != 1) {
			throw new RuntimeException(
					"Describe Layouts - wrong number - should be 1 - is "
							+ describeLayoutResult.getLayouts().length);
		}
		
		DescribeLayout describeLayout = describeLayoutResult.getLayouts()[0];

		log.debug("Layout Id is : " + describeLayout.getId());
		
		
		return null;
	}
}
