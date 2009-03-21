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

package com.modelmetrics.common.sforce.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * accepts a SOQL query. Returns a useful Sproxy object.
 * 
 * f
 * 
 * @author LENOVO USER
 * 
 */
public class MockSproxyBuilder {

	private static int count = 0;

	public static Sproxy build(String sampleSoql) {

		count++;

		SproxyStandardImpl ret = new SproxyStandardImpl();

		String[] parts = sampleSoql.split("[ ,]");

		boolean isSelect = false;
		boolean isFrom = false;
		boolean isWhere = false;

		Collection<String> aliases = new TreeSet<String>();

		for (int i = 0; i < parts.length; i++) {
			// determine which clause I'm in
			if (parts[i].trim().equalsIgnoreCase("select")) {
				isSelect = true;
				isFrom = false;
				isWhere = false;
				continue;
			} else if (parts[i].trim().equalsIgnoreCase("from")) {
				isSelect = false;
				isFrom = true;
				isWhere = false;
				continue;
			} else if (parts[i].trim().equalsIgnoreCase("where")) {
				isSelect = false;
				isFrom = false;
				isWhere = true;
				continue;
			}

			// handle items in the select
			if (isSelect) {

				if (parts[i].trim().length() > 0) {
					// determine if there is an alias.
					String likelyFieldName = parts[i].trim();

					if (parts[i].indexOf(".") > -1) {
						// yes we have an alias
						String[] aliasParts = parts[i].split("[.]");
						aliases.add(aliasParts[0].trim());
						likelyFieldName = aliasParts[1];
					}

					if (likelyFieldName.equalsIgnoreCase("id")) {
						// special field
						ret.setId("id" + count);
					} else {
						ret.setValue(likelyFieldName, "value " + count + i);
					}
				}

			}

			// handle items in the from
			if (isFrom) {
				String likelyObjectName = parts[i].trim();

				if (!aliases.contains(likelyObjectName)) {
					ret.setType(parts[i].trim());
				}
			}

			// handle items in the where
			if (isWhere) {
				// two possibilities: either we have a string with an = or we
				// don't.
				String whereClauseElement = parts[i].trim();

				if (whereClauseElement.equalsIgnoreCase("and")) {
					// do nothing
				} else {

					if (whereClauseElement.length() != 0) {

						String likelyFieldName = null;
						String likelyTargetValue = null;

						if (whereClauseElement.indexOf("=") > -1) {

							String[] fieldParts = whereClauseElement.split("=");

							likelyFieldName = fieldParts[0];
							likelyTargetValue = fieldParts[1];

						} else {

							int j = i;

							while (j < parts.length
									&& (likelyFieldName == null || likelyTargetValue == null)) {

								if (parts[j].trim().equals("=")) {
									// do nothing
								} else if (parts[j].trim().length() > 0
										&& likelyFieldName == null) {
									likelyFieldName = parts[j].trim();
								} else if (parts[j].trim().length() > 0
										&& likelyFieldName != null
										&& likelyTargetValue == null) {
									likelyTargetValue = parts[j].trim();
								}
								j++;
							}

							i = j;

						}

						likelyTargetValue = getClean(likelyTargetValue);
						
						if (likelyTargetValue.indexOf("\\") > -1) {
							likelyTargetValue.replace("\\", "");
						}

						if (likelyFieldName.equalsIgnoreCase("id")) {
							// throw to id field
							ret.setId(likelyTargetValue);
						} else {

							ret.setValue(likelyFieldName, likelyTargetValue);
						}
					}
				}

			}

		}

		return ret;

	}

	static String getClean(String withQuotes) {

		String ret = withQuotes.trim();

		ret = ret.substring(1, ret.length() - 1);

		return ret;

	}

	// This method returns a Sproxy object built from simpleSoqlString
	public static Sproxy buildOld(String simpleSoqlString) {
		count++;

		SproxyStandardImpl ret = new SproxyStandardImpl();

		int lastFromBegins = simpleSoqlString.toLowerCase().lastIndexOf(
				" from ");
		int whereBegins = simpleSoqlString.toLowerCase().lastIndexOf(" where ");
		int whereEnds = whereBegins + 7;
		int fromEnds = lastFromBegins + 6;
		String typeString = simpleSoqlString.substring(fromEnds,
				simpleSoqlString.length()).trim();

		String fieldsString = simpleSoqlString.substring(7, lastFromBegins)
				.trim();

		if (typeString.indexOf(' ') != -1) {
			typeString = typeString.substring(0, typeString.indexOf(' '));
		}

		ret.setType(typeString.trim());

		String afterWhereString = simpleSoqlString.substring(whereEnds);
		int equalsPosInt = afterWhereString.indexOf("=");

		String field = "", value = "";
		int startInt = 0;
		ArrayList aList = new ArrayList();
		// ""Select Id, Name from s where Name='O\\'Mally'";
		// for (int i = 0; i < 2; i++)
		while (equalsPosInt > -1) {
			field = afterWhereString.substring(startInt, equalsPosInt).trim();
			value = afterWhereString.substring(equalsPosInt).trim();
			afterWhereString = value;

			int firstQuoteInt = value.indexOf("'");
			int lastQuoteInt = value.indexOf("'", firstQuoteInt + 1);

			if (value.indexOf("\\") > -1) {
				lastQuoteInt = value.indexOf("'", lastQuoteInt + 1);
			}
			value = value.substring(firstQuoteInt + 1, lastQuoteInt).trim();
			if (value.indexOf("\\") > -1) {
				value = value.replace("\\", "");
			}
			if (field.lastIndexOf(" ") != -1)
				field = field.substring(field.lastIndexOf(" ")).trim();

			if (field.lastIndexOf(" ") != -1) {

			}
			aList.add(new String[] { field, value });
			equalsPosInt = afterWhereString.indexOf("=", lastQuoteInt + 1);
			startInt = lastQuoteInt + 1;
		}

		fieldsString = fieldsString.trim();
		StringTokenizer tokenizer = new StringTokenizer(fieldsString, ",");

		int totaltokensInt = tokenizer.countTokens();

		for (int i = 0; i < totaltokensInt; i++) {
			String fieldName = tokenizer.nextToken().trim();

			int periodPositionInt = fieldName.indexOf('.');
			if (periodPositionInt != -1) {
				fieldName = fieldName.substring(periodPositionInt + 1).trim();
			}
			ret.setValue(fieldName, "value" + count + i);
		}

		String[] array = new String[2];
		for (int i = 0; i < aList.size(); i++) {
			array = (String[]) (aList.get(i));
			ret.setValue(array[0], array[1]);

		}

		return ret;
	}

	/*
	 * /public static void main (String [] args) { String simpleSoqlString =
	 * "Select Id, Name, BillingState from Account where Name='Farhan' and
	 * BillingState='MIfds'"; int lastfromInt =
	 * simpleSoqlString.toLowerCase().lastIndexOf(" from "); int whereInt =
	 * simpleSoqlString.toLowerCase().lastIndexOf(" where "); int afterwhereInt =
	 * whereInt + 7; int afterfromInt = lastfromInt + 6; String typeString =
	 * simpleSoqlString.substring(afterfromInt,
	 * simpleSoqlString.length()).trim();
	 * 
	 * String fieldsString = simpleSoqlString.substring(7, lastfromInt).trim();
	 * 
	 * if(typeString.indexOf(' ') != -1) { typeString = typeString.substring(0,
	 * typeString.indexOf(' ')); } // ret.setType(typeString.trim());
	 * 
	 * String afterWhereString = simpleSoqlString.substring(afterwhereInt); int
	 * equalsPosInt = afterWhereString.indexOf("=");
	 * 
	 * String field = "", value = ""; int startInt = 0; ArrayList aList = new
	 * ArrayList(); int firstQuoteInt; int lastQuoteInt;
	 * 
	 * //while (equalsPosInt > -1) for (int i = 0; i < 5 ; i++) { field =
	 * afterWhereString.substring(startInt, equalsPosInt).trim(); value =
	 * afterWhereString.substring(equalsPosInt).trim(); firstQuoteInt =
	 * value.indexOf("'"); lastQuoteInt = value.indexOf("'", firstQuoteInt + 1);
	 * value = value.substring(firstQuoteInt + 1, lastQuoteInt).trim();
	 * aList.add(new String [] {field, value}); equalsPosInt =
	 * afterWhereString.indexOf("=", lastQuoteInt + 1); startInt = lastQuoteInt +
	 * 1; System.out.println(lastQuoteInt); } }
	 */

}
