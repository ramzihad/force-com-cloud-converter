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
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.FieldType;
import com.sforce.soap._2006._04.metadata.Picklist;
import com.sforce.soap._2006._04.metadata.PicklistValue;

public class CustomFieldBuilder {

	private static final Log log = LogFactory.getLog(CustomFieldBuilder.class);

	public CustomField[] build(MigrationContext migrationContext)
			throws Exception {

		ResultSetMetaData rsmd = migrationContext.getResultSetMetaData();
		CustomObject newCustomObject = migrationContext.getCustomObject();

		// standard fields
		Collection<CustomField> customFieldsCollection = new ArrayList<CustomField>();
		Map<String, String> fieldMap = new HashMap<String, String>();
		Collection<String> customFieldShortNames = new ArrayList<String>();

		// Lookup fields
		Collection<CustomField> customLookupFieldsCollection = new ArrayList<CustomField>();

		migrationContext.setFieldMap(fieldMap);

		for (int i = 0; i < rsmd.getColumnCount(); i++) {

			boolean isPicklist = migrationContext.getPicklistFields() != null && migrationContext.getPicklistFields()
					.containsKey(rsmd.getColumnName(i + 1));

			CustomField field = new CustomField();
			String sfdcColumnName = rsmd.getColumnName(i + 1)
					+ "__c".toLowerCase();
			customFieldShortNames.add(sfdcColumnName);
			field = new CustomField();
			field.setFullName(newCustomObject.getFullName() + "."
					+ sfdcColumnName);
			field.setLabel(rsmd.getColumnName(i + 1));

			// rsc need this for later use with DAO / Sproxy
			// fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);

			if (isPicklist) {

				field.setType(FieldType.Picklist);
				Picklist picklist = new Picklist();

				try {

					log.debug("dirtconnection? "
							+ migrationContext.getDirtConnection()
									.getConnection().getClass().getName());

					Statement statement = migrationContext.getDirtConnection()
							.getConnection().createStatement();

					String sql = (String) migrationContext.getPicklistFields()
							.get(rsmd.getColumnName(i + 1));

					log.info("Picklist sql: " + sql);

					ResultSet rs = statement.executeQuery(sql);

					if (rs.getMetaData().getColumnCount() != 1) {
						rs.close();
						statement.close();
						throw new RuntimeException(
								"Column count not right on picklist; should be 1 but is "
										+ rs.getMetaData().getColumnCount());
					}
					ArrayList<String> values = new ArrayList<String>();

					while (rs.next()) {
						log.debug("picklist value is: " + rs.getString(1));
						values.add(rs.getString(1));
					}

					rs.close();
					statement.close();

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
							+ rsmd.getColumnName(i + 1), e);
				}

				field.setPicklist(picklist);
				customFieldsCollection.add(field);
				fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
			} else if (migrationContext.getExternalIds() != null && migrationContext.getExternalIds().contains(
					rsmd.getColumnName(i + 1))) {

				field.setType(FieldType.Text);
				field.setExternalId(Boolean.TRUE);
				field.setUnique(Boolean.TRUE);
				field.setLength(rsmd.getPrecision(i + 1));
				field.setCaseSensitive(Boolean.FALSE);
				customFieldsCollection.add(field);
				fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
			} else if (migrationContext.getLookupFields() != null && migrationContext.getLookupFields().containsKey(
					rsmd.getColumnName(i + 1))) {
				LookupSettings lookupSettings = migrationContext
						.getLookupFields().get(rsmd.getColumnName(i + 1));
				field.setType(FieldType.Lookup);
				field.setReferenceTo(lookupSettings.getRelationshipObject());
				field.setRelationshipName("AAAs");
				field.setRelationshipLabel("Lookup1");

				// field.setType(FieldType.Lookup);
				// field.setReferenceTo("AAA__c");
				// field.setFullName("MYTABLE__c.NEWLOOKUP1__c");
				// field.setRelationshipName("AAAs");
				// field.setRelationshipLabel("Lookup1");
				// field.setLabel("Lookup1");

				// sfdcColumnName = lookupSettings.getRelationshipFields();

				// customFieldShortNames.remove(sfdcColumnName);
				//				
				// sfdcColumnName =
				// lookupSettings.getRelationshipObject().toLowerCase();
				//								
				// customFieldShortNames.add(sfdcColumnName);
				//
				// field.setFullName(newCustomObject.getFullName() + "."
				// + lookupSettings.getRelationshipObject());

				customLookupFieldsCollection.add(field);
				fieldMap.put(rsmd.getColumnName(i + 1), lookupSettings.getRelationshipFields());
			} else {
				switch (rsmd.getColumnType(i + 1)) {
				case Types.BIGINT:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));

					if (field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));

					if (field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.BINARY:
					field.setType(FieldType.Checkbox);
					field.setDefaultValue("false");
					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.BOOLEAN:
					field.setType(FieldType.Checkbox);
					field.setDefaultValue("false");
					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.CHAR:
					field.setType(FieldType.Text);
					field.setLength(rsmd.getPrecision(i + 1));
					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.DATE:
					field.setType(FieldType.Date);
					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.DOUBLE:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));

					if (field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));

					if (field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.DECIMAL:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));

					if (field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));

					if (field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.FLOAT:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));

					if (field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));

					if (field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.INTEGER:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));

					if (field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));

					if (field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.LONGVARBINARY:
					field.setType(FieldType.Checkbox);
					field.setDefaultValue("false");
					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.LONGVARCHAR:
					field.setType(FieldType.LongTextArea);
					// rsc don't need precision for textarea, do for a
					// longtextarea
					field.setLength(32000);
					field.setVisibleLines(5); // rsc hard coding for now since
					// this isn't metadata driven
					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.REAL:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));

					if (field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));

					if (field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.NUMERIC:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));

					if (field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));

					if (field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.SMALLINT:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));

					if (field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));

					if (field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.TIME:
					field.setType(FieldType.DateTime);
					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.TIMESTAMP:
					field.setType(FieldType.DateTime);
					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.TINYINT:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));

					if (field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));

					if (field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				case Types.VARCHAR:
					field.setType(FieldType.Text);
					field.setLength(rsmd.getPrecision(i + 1));

					// 2008-12-28 RSC double check the value
					if (field.getLength().intValue() > 255) {
						throw new RuntimeException(
								"value of the field length is too large.  Max is 255 but the DB metadata shows "
										+ rsmd.getPrecision(i + 1));
					}

					// customFieldsCollection.add(field);
					// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
					break;

				}
				customFieldsCollection.add(field);
				fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
			}

			//fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);

		}

		migrationContext.setCustomFields(customFieldsCollection
				.toArray(new CustomField[] {}));

		migrationContext.setCustomLookupFields(customLookupFieldsCollection
				.toArray(new CustomField[] {}));

		migrationContext.setCustomFieldShortNames(customFieldShortNames
				.toArray(new String[] {}));

		return migrationContext.getCustomFields();
	}
}
