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
package com.modelmetrics.cloudconverter.migrate.struts2;

import java.util.Collection;
import java.util.TreeSet;

import org.springframework.core.CollectionFactory;
import org.springframework.util.StringUtils;

import com.modelmetrics.common.sforce.util.FieldComparator;
import com.opensymphony.xwork2.Action;
import com.sforce.soap.partner.Field;

public class MigrateSetupAction extends AbstractMigrateContextAware {

	private String name;
	
	private String preview;

	private String source;

	private String target;

	private String resolution;
	
	private String disposition;

	private String concatenator;

	private String submit;
	
	private Collection<Field> fields;

	public String execute() throws Exception {

		if (this.getSubmit() == null) {
			this.setConcatenator(this.getMigrateContext().getConcatenator());
			this.setPreview(this.getMigrateContext().getPreview());
			if (this.getMigrateContext().getConflict() != null) {
				this.setResolution(this.getMigrateContext().getConflict()
						.getName());
			}
			if (this.getMigrateContext().getDisposition()!= null) {
				this.setDisposition(this.getMigrateContext().getDisposition()
						.getName());
			}
			this.setSource(this.getMigrateContext().getSource());
			this.setTarget(this.getMigrateContext().getTarget());
			this.setName(this.getMigrateContext().getName());
			return Action.INPUT;
		}

		if (this.getResolution().indexOf("concat") > -1) {
			if (this.getConcatenator() == null) {
				return Action.INPUT;
			}
		}
		
		if (!StringUtils.hasText(this.getName() )) {
			return Action.INPUT;
		}

		this.getMigrateContext().setPreview(this.getPreview());
		this.getMigrateContext().setSource(this.getSource());
		this.getMigrateContext().setTarget(this.getTarget());
		this.getMigrateContext().setConflict(
				ConflictResolutionType.getType(this.getResolution()));
		this.getMigrateContext().setDisposition(SourceDispositionType.getType(this.getDisposition()));
		this.getMigrateContext().setConcatenator(this.getConcatenator());
		this.getMigrateContext().setName(this.getName());

		return Action.SUCCESS;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Collection<ConflictResolutionType> getConflictResolutionTypes() {
		return ConflictResolutionType.getTypes();
	}
	
	public Collection<SourceDispositionType> getSourceDispositionTypes() {
		return SourceDispositionType.getTypes();
	}	

	public String getConcatenator() {
		return concatenator;
	}

	public void setConcatenator(String concatenator) {
		this.concatenator = concatenator;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public Collection<Field> getFields() {
		
		if (this.fields == null) {
			fields = new TreeSet<Field>(new FieldComparator());
			for (int i = 0; i < this.getDescribeContext().getLastResult().getFields().length; i++) {
				fields.add(this.getDescribeContext().getLastResult().getFields()[i]);
			}
		}
		return this.fields;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
