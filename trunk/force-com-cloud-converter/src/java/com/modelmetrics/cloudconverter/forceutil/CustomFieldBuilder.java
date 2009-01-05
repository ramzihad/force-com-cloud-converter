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

import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.FieldType;

public class CustomFieldBuilder {

	public CustomField[] build(MigrationContext migrationContext) throws Exception {
		
		ResultSetMetaData rsmd = migrationContext.getResultSetMetaData();
		CustomObject newCustomObject = migrationContext.getCustomObject();
		
		Collection <CustomField> customFieldsCollection = new ArrayList<CustomField>();

		Map<String, String> fieldMap = new HashMap<String, String>();
		
		Collection <String> customFieldShortNames = new ArrayList<String>();
		
		migrationContext.setFieldMap(fieldMap);
		
		for (int i = 0; i < rsmd.getColumnCount(); i++) {

			CustomField field = new CustomField();
			String sfdcColumnName = rsmd.getColumnName(i + 1) + "__c".toLowerCase();
			customFieldShortNames.add(sfdcColumnName);
			field = new CustomField();
			field.setFullName(newCustomObject.getFullName() + "."
					+ sfdcColumnName);
			field.setLabel(rsmd.getColumnName(i + 1));

			//rsc need this for later use with DAO / Sproxy
//			fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
			

			switch (rsmd.getColumnType(i + 1)) 
			{
				case Types.BIGINT:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));
					
					if(field.getPrecision() > 18)
						field.setPrecision(18);
					
					field.setScale(rsmd.getScale(i + 1));
					
					if(field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);
						
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
	
				case Types.BINARY:
					field.setType(FieldType.Checkbox);
					field.setDefaultValue("false");
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;

				case Types.BOOLEAN:
					field.setType(FieldType.Checkbox);
					field.setDefaultValue("false");
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
					
				case Types.CHAR:
					field.setType(FieldType.Text);
					field.setLength(rsmd.getPrecision(i + 1));
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
				
				case Types.DATE:
					field.setType(FieldType.Date);
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
					
				case Types.DOUBLE:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));
					
					if(field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));
					
					if(field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);
					
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
					
				case Types.DECIMAL:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));
					
					if(field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));
					
					if(field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);
					
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
					
				case Types.FLOAT:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));
					
					if(field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));
					
					if(field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);
					
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
					
				case Types.INTEGER:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));
					
					if(field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));
					
					if(field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);
					
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;

				case Types.LONGVARBINARY:
					field.setType(FieldType.Checkbox);
					field.setDefaultValue("false");
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;

				case Types.LONGVARCHAR:
					field.setType(FieldType.LongTextArea);
					//rsc don't need precision for textarea, do for a longtextarea
					field.setLength(32000);
					field.setVisibleLines(5); //rsc hard coding for now since this isn't metadata driven
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
	
				case Types.REAL:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));
					
					if(field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));
					
					if(field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);
					
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;

				case Types.NUMERIC:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));
					
					if(field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));
					
					if(field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);
					
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
				
				case Types.SMALLINT:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));
					
					if(field.getPrecision() > 18)
						field.setPrecision(18);

					field.setScale(rsmd.getScale(i + 1));
					
					if(field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);
					
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
	
				case Types.TIME:
					field.setType(FieldType.DateTime);
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
					
				case Types.TIMESTAMP:
					field.setType(FieldType.DateTime);
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
					
				case Types.TINYINT:
					field.setType(FieldType.Number);
					field.setPrecision(rsmd.getPrecision(i + 1));
					
					if(field.getPrecision() > 18)
						field.setPrecision(18);
					
					field.setScale(rsmd.getScale(i + 1));
					
					if(field.getPrecision() < field.getScale())
						field.setScale(field.getPrecision() - 1);
					
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;
	
				case Types.VARCHAR:
					field.setType(FieldType.Text);
					field.setLength(rsmd.getPrecision(i + 1));
					
					//2008-12-28 RSC double check the value
					if (field.getLength().intValue() > 255) {
						throw new RuntimeException("value of the field length is too large.  Max is 255 but the DB metadata shows " + rsmd.getPrecision(i + 1));
					}
					
					customFieldsCollection.add(field);
					fieldMap.put(rsmd.getColumnName(i+1), sfdcColumnName);
					break;


			}
		}
				
		migrationContext.setCustomFields(customFieldsCollection.toArray(new CustomField[] {}));
		
		migrationContext.setCustomFieldShortNames(customFieldShortNames.toArray(new String[] {}));
		
		return migrationContext.getCustomFields();
	}
}
