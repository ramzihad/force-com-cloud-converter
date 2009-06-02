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

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.engine.PicklistProvider;
import com.modelmetrics.cloudconverter.util.ExternalIdBean;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.FieldType;
import com.sforce.soap._2006._04.metadata.Picklist;
import com.sforce.soap._2006._04.metadata.PicklistValue;

public class CustomFieldBuilder {

	private static final Log log = LogFactory.getLog(CustomFieldBuilder.class);

	public CustomField[] build(MigrationContext migrationContext)
			throws Exception {

		// 2009-03-21 RSC Refactoring to MetadataProxy
		// ResultSetMetaData rsmd = migrationContext.getResultSetMetaData();

		List<MetadataProxy> metadataProxies = migrationContext
				.getMetadataProxies();

		// 2009-03-21 RSC probably needs some MetadataProxy style refactoring as
		// well.
		// built in migration engine
		CustomObject newCustomObject = migrationContext.getCustomObject();

		// standard fields
		Collection<CustomField> customFieldsCollection = new ArrayList<CustomField>();
		Map<String, String> fieldMap = new HashMap<String, String>();
		Collection<String> customFieldShortNames = new ArrayList<String>();

		// Lookup fields
		Collection<CustomField> customLookupFieldsCollection = new ArrayList<CustomField>();

		migrationContext.setFieldMap(fieldMap);

		/*
		 * 2009-03-20 RSC Will need to find a way to handle External ID,
		 * Lookups, etc., with non-SQL datasources (Excel). For now, we can just
		 * leave these collections empty and the rest of the engine will ignore
		 * them.
		 */
		for (MetadataProxy current : metadataProxies) {

			if (!StringUtils.hasText(current.getName())) {
				throw new RuntimeException("Empty field name.  Check row 1, the column at position " + (current.getIndex() + 1) + " appears to be blank.");
			}
			boolean isPicklist = migrationContext.getPicklistFields() != null
					&& migrationContext.getPicklistFields().containsKey(
							current.getName());

			CustomField field = new CustomField();
			String sfdcColumnName = current.getName() + "__c".toLowerCase();
			customFieldShortNames.add(sfdcColumnName);
			field.setFullName(newCustomObject.getFullName() + "."
					+ sfdcColumnName);
			field.setLabel(current.getLabel());

			// rsc need this for later use with DAO / Sproxy
			// fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);

			if (isPicklist) {

				field.setType(FieldType.Picklist);
				Picklist picklist = new Picklist();

				try {

					PicklistProvider picklistProvider = migrationContext
							.getPicklistFields().get(current.getName());

					List<String> values = picklistProvider.getPicklistValues();

					PicklistValue[] picklistValues = new PicklistValue[values
							.size()];

					int counter = 0;
					for (Iterator<String> valuesIterator = values.iterator(); valuesIterator
							.hasNext();) {
						String string = (String) valuesIterator.next();
						picklistValues[counter] = new PicklistValue();
						picklistValues[counter].setFullName(string);
						counter++;
					}

					picklist.setPicklistValues(picklistValues);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Couldn't generate picklist info for "
							+ current.getName(), e);
				}

				field.setPicklist(picklist);
				customFieldsCollection.add(field);
				fieldMap.put(current.getName(), sfdcColumnName);
			} else if (migrationContext.getExternalIds() != null
					&& migrationContext.getExternalIds().contains(
							current.getName())) {
				field.setType(FieldType.Text);
				field.setExternalId(Boolean.TRUE);
				// RSC 2009-05-23 Modified to not use the bean - should always
				// be unique (even though I thought it might be OK to allow them
				// to select it).
				field.setUnique(Boolean.TRUE);
				field.setLength(current.getLength());
				field.setCaseSensitive(Boolean.FALSE);
				field.setLabel(current.getLabel());
				customFieldsCollection.add(field);
				fieldMap.put(current.getName(), sfdcColumnName);

			} else if (migrationContext.getLookupFields() != null
					&& migrationContext.getLookupFields().containsKey(
							current.getName())) {
				LookupSettings lookupSettings = migrationContext
						.getLookupFields().get(current.getName());
				field.setType(FieldType.Lookup);
				field.setReferenceTo(lookupSettings.getRelationshipObject());

				// RSC 2009-05-23 Modified to pick the name out rather than hard
				// code it.

				String relName = lookupSettings.getRelationshipObject();

				if (relName.endsWith("__c")) {
					relName = relName.substring(0, relName.length() - 3);
				}

				field.setRelationshipName(migrationContext
						.getCloudConverterObject().getObjectName().substring(
								0,
								migrationContext.getCloudConverterObject()
										.getObjectName().length() - 3)
						+ relName + "s");
				field.setRelationshipLabel(relName + "s");

				customLookupFieldsCollection.add(field);
				fieldMap.put(current.getName(), lookupSettings
						.getApiResolutionString());
			} else {

				field.setType(current.getType());

				if (current.getType() != FieldType.Text
						&& current.getType() != FieldType.Date
						&& current.getType() != FieldType.DateTime
						&& current.getType() != FieldType.Checkbox
						&& current.getType() != FieldType.TextArea
						&& current.getType() != FieldType.LongTextArea
						&& current.getType() != FieldType.Url
						&& current.getType() != FieldType.Email
						&& current.getType() != FieldType.Phone) {
					field.setPrecision(current.getPrecision());
					field.setScale(current.getScale());
				}

				if (current.getType() == FieldType.Text
						|| current.getType() == FieldType.LongTextArea
						|| current.getType() == FieldType.TextArea) {
					field.setLength(current.getLength());
				}

				if (current.getType() == FieldType.Checkbox) {
					field.setDefaultValue(current.getDefaultValue());
				}

				if (current.getLength() == 32000) {
					field.setVisibleLines(5);
				}

				customFieldsCollection.add(field);
				fieldMap.put(current.getName(), sfdcColumnName);
			}

		}

		migrationContext.setCustomFields(customFieldsCollection
				.toArray(new CustomField[] {}));

		migrationContext.setCustomLookupFields(customLookupFieldsCollection
				.toArray(new CustomField[] {}));

		migrationContext.setCustomFieldShortNames(customFieldShortNames
				.toArray(new String[] {}));

		return migrationContext.getCustomFields();
	}

	private ExternalIdBean foundInList(Collection<ExternalIdBean> externalIds,
			String name) {
		for (ExternalIdBean externalIdBean : externalIds) {
			if (externalIdBean.getName().equals(name)) {
				return externalIdBean;
			}
		}
		return null;
	}
}
