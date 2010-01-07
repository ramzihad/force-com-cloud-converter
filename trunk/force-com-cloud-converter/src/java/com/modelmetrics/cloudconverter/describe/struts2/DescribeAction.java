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
package com.modelmetrics.cloudconverter.describe.struts2;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.common.struts2.CompositeLoginAction;
import com.modelmetrics.cloudconverter.describe.DisplayableFieldMetadataBean;
import com.modelmetrics.cloudconverter.describe.DisplayableSobjectFieldMetadataBeanBuilder;
import com.modelmetrics.cloudconverter.describe.FieldComparator;
import com.modelmetrics.cloudconverter.describe.SobjectFieldPropertyBean;
import com.opensymphony.xwork2.Action;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

public class DescribeAction extends AbstractDescribeContextAware {

	private String target;

	private DescribeSObjectResult results;
	
	private Set<Field> objectFields;
	
	private Collection<SobjectFieldPropertyBean> fields = SobjectFieldPropertyBean.getFieldBeans();
	
	private Collection<DisplayableFieldMetadataBean> displayableFields;
	
	private boolean showAll;
	
	private static Log log = LogFactory.getLog(DescribeAction.class);

	public String execute() throws Exception {

	
		if (this.getTarget() != null) {
			try {
				this.getDescribeContext().setTarget(this.getTarget());
			}
			catch (InvalidTypeException ite) {
				this.addActionMessage("Invalid SObject Type.");
				return Action.ERROR;
			}
		}

		DescribeSObjectResult r = null;
		
		r = this.getSalesforceSessionContext().getSalesforceSession()
				.getSalesforceService().describeSObject(
						this.getDescribeContext().getTarget());
		
		this.setResults(r);
		
		if (r != null) {

			Field[] fields = r.getFields();

			Set<Field> results = new TreeSet<Field>(new FieldComparator());

			for (int i = 0; i < fields.length; i++) {
				results.add(fields[i]);
			}

			this.displayableFields = new DisplayableSobjectFieldMetadataBeanBuilder().build(SobjectFieldPropertyBean.getFieldBeans(), results);

			this.getDescribeContext().setLastResult(r);

			//used for data template as excel
			this.objectFields = results;
			
		}
		
		

		return Action.SUCCESS;

	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String targetSObject) {
		this.target = targetSObject;
	}

	public Set<Field> getObjectFields() {
		return objectFields;
	}

	public void setObjectFields(Set<Field> results) {
		this.objectFields = results;
	}

	public DescribeSObjectResult getResults() {
		return results;
	}

	public void setResults(DescribeSObjectResult results) {
		this.results = results;
	}

	public Collection<DisplayableFieldMetadataBean> getDisplayableFields() {
		return displayableFields;
	}

	public void setDisplayableFields(
			Collection<DisplayableFieldMetadataBean> displayableFields) {
		this.displayableFields = displayableFields;
	}

	public Collection<SobjectFieldPropertyBean> getFields() {
		return fields;
	}

	public void setFields(Collection<SobjectFieldPropertyBean> fields) {
		this.fields = fields;
	}

	public boolean isShowAll() {
		return showAll;
	}

	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

}
