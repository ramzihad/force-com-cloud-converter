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

/**
 * Sproxy is a simple way of interacting with Salesforce.com's SObjects. 
 * 
 */

package com.modelmetrics.common.sforce.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public abstract class AbstractSproxy implements Sproxy {

	private static final SimpleDateFormat FORCE_DATE = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static final SimpleDateFormat FORCE_DATETIME = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'-06:00'");

	protected Map<String, Object> map = new HashMap<String, Object>();

	protected Collection<String> nullFields = new TreeSet<String>();

	protected String type;

	protected String id;

	protected Sproxy parent;

	protected Map<String, Sproxy> children = new HashMap<String, Sproxy>();

	protected boolean dirty;

	public Map<String, Object> getValues() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getId() {
		return id;
	}

	public void setId(String salesforceId) {
		this.id = salesforceId;
	}

	public String getType() {
		return type;
	}

	public void setType(String typeName) {
		this.type = typeName;
	}

	/**
	 * requires a little effort to be sure we return data in a format suitable
	 * for Force.com.
	 */
	public String getValue(String key) {
		key = key.toLowerCase();

		String ret = null;

		Object value = this.getValues().get(key);

		if (value instanceof java.sql.Timestamp) {
			// 2008-12-30 need to be sure the datetime comes up in format useful
			// to FORCE.COM
			// 2009-01-04 Timestamp is before Date since Timestamp is a subclass
			// of date.
			ret = FORCE_DATETIME.format(value);

		} else if (value instanceof java.util.Date
				|| value instanceof java.sql.Date) {
			Date dateValue = (Date) value;

			Calendar c = GregorianCalendar.getInstance();
			c.setTime(dateValue);

			if (c.get(Calendar.HOUR) == 0 && c.get(Calendar.MINUTE) == 0
					&& c.get(Calendar.SECOND) == 0
					&& c.get(Calendar.MILLISECOND) == 0) {

				ret = FORCE_DATE.format(value);

			} else {
				ret = FORCE_DATETIME.format(value);
			}

//			ret = FORCE_DATE.format(value);

		} else if (value instanceof java.lang.Double) {
			// 2008-12-30 rsc specially called out since we had some trouble
			// with Doubles early on.
			ret = ((Double) value).toString();

		} else {
			ret = value.toString();
		}

		return ret;

	}

	// 2008-12-30 RSC removed to clean up code since we shouldn't need this any
	// more.
	// public Object getValueObject(String key) {
	// key = key.toLowerCase();
	// return this.getValues().get(key);
	// }

	public void removeValue(String key) {
		key = key.toLowerCase();
		this.getValues().remove(key);
	}

	public void removeNull(String key) {
		key = key.toLowerCase();
		this.getNullKeys().remove(key);
	}

	public void setNull(String key) {
		key = key.toLowerCase();
		if (this.map.containsKey(key)) {
			this.map.remove(key);
		}
		this.nullFields.add(key);
		/*
		 * setting a field null means it's dirty.
		 */
		this.setDirty(true);
	}

	/*
	 * 2007-06-27 keys within null and value sets are exclusive.
	 */
	public void setValue(String key, Object value) {

		key = key.toLowerCase();

		if (key.equalsIgnoreCase("id")) {
			this.setId(value.toString());
		} else {
			if (this.nullFields.contains(key)) {
				this.nullFields.remove(key);
			}
			if (this.getValueKeys().contains(key)
					&& this.getValues().get(key) != null) {
				if (this.getValues().get(key).equals(value)) {
					// do nothing, do not mark as dirty
					return;
				}
			}
			this.getValues().put(key, value);
		}

		/*
		 * the builder sets this to false when originally constructing. any
		 * other setValue should mark as dirty.
		 */
		this.setDirty(true);
	}

	public Collection<String> getNullKeys() {
		return this.nullFields;
	}

	public Collection<String> getValueKeys() {
		Collection<String> ret = new TreeSet<String>();
		ret.addAll(this.getValues().keySet());
		return ret;
	}

	public Collection<Sproxy> getChildren() {
		return children.values();
	}

	public Sproxy getChild(String key) {
		key = key.toLowerCase();
		return children.get(key);
	}

	public void putChild(String key, Sproxy sproxy) {
		key = key.toLowerCase();
		children.put(key, sproxy);
	}

	public Sproxy getParent() {
		return parent;
	}

	void setParent(Sproxy parent) {
		this.parent = parent;
	}

	public boolean hasParent() {
		return this.parent != null;
	}

	public boolean hasChildren() {
		return this.children.size() > 0;
	}

	public boolean isDirty() {
		return dirty;
	}

	void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	public boolean hasNull(String key) {
		return this.getNullKeys().contains(key);
	}

	public boolean hasValue(String key) {
		return this.getValueKeys().contains(key)
				&& this.getValues().get(key) != null;
	}

}
