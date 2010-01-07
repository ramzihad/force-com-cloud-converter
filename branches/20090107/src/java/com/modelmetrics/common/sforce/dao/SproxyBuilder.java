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

import org.apache.axis.message.MessageElement;

import com.sforce.soap.partner.sobject.SObject;

/**
 * 2006-06-26 reid carlberg
 * 
 * this cycles through the message element to build a better Java object for us
 * to work with.
 * 
 * 
 * 
 */
public class SproxyBuilder {

	public Collection<Sproxy> build(SObject[] source) {

		Collection<Sproxy> ret = new ArrayList<Sproxy>();

		if (source != null) {
			for (int i = 0; i < source.length; i++) {
				ret.add(build(source[i]));
			}
		}

		return ret;

	}

	public Sproxy build(SObject source) {

		return this.handleBuild(source);

	}
	
	public Sproxy buildEmpty(String objectName) {
		SproxyStandardImpl ret = new SproxyStandardImpl();
		
		ret.setType(objectName);
		ret.setDirty(true);
		
		return ret;
	}
	/*
	 * 2007-07-15 have a handler so its easier to call recursively
	 */
	SproxyStandardImpl handleBuild(SObject source) {
		
		SproxyStandardImpl ret = new SproxyStandardImpl();

		ret.setType(source.getType());
		ret.setId(source.getId());

		for (int j = 0; j < source.get_any().length; j++) {
			MessageElement me = source.get_any()[j];

			/*
			 * checks to see if this is a joined result.  if so
			 * call this method recursively
			 */
			if (me.getObjectValue() != null) {
				SproxyStandardImpl child = this.handleBuild(((SObject) me.getObjectValue()));
				child.setParent(ret);
				ret.putChild(me.getName(), child);
//				ret.getChildren().add(child);
			} else 	if (!this.isSkipKey(me.getName())) {
				ret.setValue(me.getName().toLowerCase(), me.getValue());
			}

		}

		/*
		 * mark as not dirty since we just built it.
		 */
		ret.setDirty(false);

		return ret;
	}

	boolean isSkipKey(String key) {

		boolean ret = key.equalsIgnoreCase("id");

		return ret;
	}
}
