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
package com.modelmetrics.cloudconverter.util;

import com.sforce.soap._2006._04.metadata.FieldType;

public class MetadataProxy {

	private int index; 
	
	private String name;
	
	private String label;
	
	private FieldType type;
	
	private int length;
	
	private int scale;
	
	private int precision;
	
	private boolean uniqueExternalId;
	
	private String defaultValue;
	
	private String example;
	
	private String lookupObject;
	
	private String lookupField;
	
	private String existingField;

	public String getExample() {
		return example;
	}

	public void setExample(String sourceExample) {
		this.example = sourceExample;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType fieldType) {
		this.type = fieldType;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isUniqueExternalId() {
		return uniqueExternalId;
	}

	public void setUniqueExternalId(boolean uniqueExternalId) {
		this.uniqueExternalId = uniqueExternalId;
	}
	
	public String getTypeString() {
		return this.getType().getValue();
	}
	
	public void setTypeString(String typeString) {
		this.setType(FieldType.fromString(typeString));
		
	}

	public String getLookupObject() {
		return lookupObject;
	}

	public void setLookupObject(String lookupObject) {
		this.lookupObject = lookupObject;
	}

	public String getLookupField() {
		return lookupField;
	}

	public void setLookupField(String lookupField) {
		this.lookupField = lookupField;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getExistingField() {
		return existingField;
	}

	public void setExistingField(String existingField) {
		this.existingField = existingField;
	}
	
	
}
