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
import java.util.Iterator;

import org.apache.axis.message.MessageElement;

import com.modelmetrics.common.sforce.util.MessageElementBuilder;
import com.sforce.soap.partner.sobject.SObject;

/*
 * converts from intermediate class to SObject
 */
public class SobjectBuilder {

	public SObject build(Sproxy target) throws Exception {

		SObject ret = new SObject();

		ret.setType(target.getType());

		ret.setId(target.getId());

		// determine non-null size
		int nonNullSize = 0;
		for (Iterator iter = target.getValueKeys().iterator(); iter.hasNext();) {
			if (target.hasValue((String) iter.next())) {
				nonNullSize++;
			}
		}

		MessageElement[] elements = new MessageElement[nonNullSize];

		int count = 0;

		for (Iterator iter = target.getValueKeys().iterator(); iter.hasNext();) {

			String element = (String) iter.next();

			// Object value = target.getValueObject(element);

			// rsc 11/13/08 changed to getValueObject - had problems with
			// Doubles.

			if (target.getValue(element) != null) {

				if (element.indexOf(":") > -1) {
					 String[] names = element.split(":");
					
					Sproxy child =new  SproxyBuilder().buildEmpty(names[1]);
					child.setValue(names[2], target.getValue(element));
					
					SObject childSobject = this.build(child);
					
					elements[count] = MessageElementBuilder.getMessageElement(names[0], childSobject);
				} else {
					elements[count] = MessageElementBuilder.getMessageElement(
							element, target.getValue(element));
				}

				count++;

			} else {
				target.getNullKeys().add(element);
			}

			// if (value instanceof Double) {
			// String valueString = ((Double) value).toString();
			// } else {
			// elements[count] = MessageElementBuilder.getMessageElement(
			// element, target.getValue(element));
			// }
			// count++;

		}

		ret.set_any(elements);
		

		String[] nullKeys = {};

		nullKeys = target.getNullKeys().toArray(nullKeys);

		ret.setFieldsToNull(nullKeys);

		return ret;

	}

	public SObject[] build(Collection<Sproxy> targets) throws Exception {

		Collection<SObject> ret = new ArrayList<SObject>();

		for (Iterator iter = targets.iterator(); iter.hasNext();) {
			Sproxy element = (Sproxy) iter.next();
			ret.add(this.build(element));
		}

		SObject[] template = new SObject[0];

		SObject[] toReturn = ret.toArray(template);

		return toReturn;
	}
}
