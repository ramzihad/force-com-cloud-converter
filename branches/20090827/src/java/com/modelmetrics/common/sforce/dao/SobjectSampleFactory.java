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

import org.apache.axis.message.MessageElement;

import com.modelmetrics.common.sforce.util.MessageElementBuilder;
import com.sforce.soap.partner.sobject.SObject;

public class SobjectSampleFactory {

	public static final String TYPE = "ACCOUNT";

	public static final String ID = "0000000000000";

	private static int count = 0;

	public static SObject build() throws Exception {
		count++;

		SObject ret = new SObject();

		ret.setType(TYPE);
		ret.setId(ID);

		MessageElement[] any = new MessageElement[4];

		any[0] = MessageElementBuilder.getMessageElement("Name", "account"
				+ count);
		any[1] = MessageElementBuilder.getMessageElement("BillingStreet",
				"123 anystreet" + count);
		any[2] = MessageElementBuilder.getMessageElement("BillingCity", ""
				+ count + "ville");
		any[3] = MessageElementBuilder.getMessageElement("BillingState", ""
				+ count + "ST");

		ret.set_any(any);

		return ret;
	}

	public static SObject build(int fields) throws Exception {
		count++;

		SObject ret = new SObject();

		ret.setType(TYPE);
		ret.setId(ID);

		MessageElement[] any = new MessageElement[fields];

		for (int i = 0; i < fields; i++) {
			any[i] = MessageElementBuilder.getMessageElement("field" + i + count,
					"value" + i + count);
		}

		ret.set_any(any);

		return ret;
	}
}
