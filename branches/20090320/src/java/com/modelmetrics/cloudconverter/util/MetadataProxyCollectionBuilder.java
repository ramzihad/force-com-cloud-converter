package com.modelmetrics.cloudconverter.util;

import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.modelmetrics.cloudconverter.mmimport.services.Constants;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.sforce.soap._2006._04.metadata.FieldType;

public class MetadataProxyCollectionBuilder {

	/*
	 * 2009-03-21 RSC added so we could get this out of the custom field
	 * builder.
	 * 
	 */
	// TODO add some tests.
	public List<MetadataProxy> build(ResultSetMetaData rsmd) throws Exception {

		List<MetadataProxy> ret = new ArrayList<MetadataProxy>();

		for (int i = 0; i < rsmd.getColumnCount(); i++) {

			MetadataProxy field = new MetadataProxy();

			field.setName(rsmd.getColumnName(i + 1));
			field.setLabel(rsmd.getColumnName(i + 1));

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
				// field.setVisibleLines(5); // rsc hard coding for now since
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
				if (field.getLength() > 255) {
					throw new RuntimeException(
							"value of the field length is too large.  Max is 255 but the DB metadata shows "
									+ rsmd.getPrecision(i + 1));
				}

				// customFieldsCollection.add(field);
				// fieldMap.put(rsmd.getColumnName(i + 1), sfdcColumnName);
				break;

			}

			ret.add(field);

		}

		return ret;
	}

	public List<MetadataProxy> build(WrapperBean bean) throws Exception {

		List<MetadataProxy> ret = new ArrayList<MetadataProxy>();
		for (int i = 0; i < bean.getNames().size(); i++) {
			MetadataProxy field = new MetadataProxy();

			field.setName(bean.getNames().get(i));
			field.setLabel(bean.getLabels().get(i));
			field.setExample(bean.getExamples().get(i));
			String value = bean.getTypes().get(i);
			if (Constants.STRING.equals(value)) {
				field.setType(FieldType.Text);
				field.setLength(255);
			} else if (Constants.EMAIL.equals(value)) {
				field.setType(FieldType.Email);
			} else if (Constants.URL.equals(value)) {
					field.setType(FieldType.Url);
			} else if (Constants.PHONE_NUMBER.equals(value)) {
				field.setType(FieldType.Phone);
				field.setLength(15);
			} else if (Constants.INT.equals(value)) {
				field.setType(FieldType.Number);
				field.setScale(0);
				field.setPrecision(18);
			} else if (Constants.DOUBLE.equals(value)) {
				field.setType(FieldType.Number);
				field.setScale(8);
				field.setPrecision(18);
			} else if (Constants.FLOAT.equals(value)) {
				field.setType(FieldType.Number);
				field.setScale(8);
				field.setPrecision(18);
			} else if (Constants.PERCENTAGE.equals(value)) {
				field.setType(FieldType.Percent);
				field.setScale(8);
				field.setPrecision(18);
			} else if (Constants.CURRENCY.equals(value)) {
				field.setType(FieldType.Currency);
				field.setScale(2);
				field.setPrecision(18);

			} else if (Constants.DATE.equals(value)) {
				field.setType(FieldType.Date);
			} else if (Constants.DATETIME.equals(value)) {
				field.setType(FieldType.DateTime);
			} 
			else if (Constants.LOOKUP.equals(value)) {
				field.setType(FieldType.Lookup);
			} 
			else if (Constants.EXTERNAL_ID.equals(value)) {
				field.setType(FieldType.ExternalId);
			} 
			
			
			ret.add(field);
		}
		return ret;
	}
}
