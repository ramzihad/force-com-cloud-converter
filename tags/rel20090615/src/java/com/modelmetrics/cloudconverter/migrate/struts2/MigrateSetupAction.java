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
import java.util.Set;
import java.util.TreeSet;

import org.springframework.util.StringUtils;

import com.modelmetrics.common.sforce.util.FieldComparator;
import com.opensymphony.xwork2.Action;
import com.sforce.soap.partner.Field;

public class MigrateSetupAction extends AbstractMigrateContextAware {



	private String previewField;

	private String sourceField;

	private String targetField;

	private String resolution;

	private String disposition;

	private String concatenator;

	private String submit;

	private Collection<Field> fields;
	
	private int updateBatchSize = 100;

	public String execute() throws Exception {

		if (this.getSubmit() == null) {
			//2009-06-15 RSC
			this.setConcatenator(this.getMigrateContext().getConcatenator());
			this.setPreviewField(this.getMigrateContext().getPreviewField());
			if (this.getMigrateContext().getConflict() != null) {
				this.setResolution(this.getMigrateContext().getConflict()
						.getName());
			}
			if (this.getMigrateContext().getDisposition()!= null) {
				this.setDisposition(this.getMigrateContext().getDisposition()
						.getName());
			}
			this.setSourceField(this.getMigrateContext().getSourceField());
			this.setTargetField(this.getMigrateContext().getTargetField());
			

			return Action.INPUT;
		}

		if (this.getResolution().indexOf("concat") > -1) {
			if (this.getConcatenator() == null) {
				this.addActionMessage("If you are concatenating, you much enter a concatenation character.");
				return Action.INPUT;
			}
		}
		
		if (!this.isValid()) {
			return Action.INPUT;
		}

		this.getMigrateContext().setPreviewField(this.getPreviewField());
		this.getMigrateContext().setSourceField(this.getSourceField());
		this.getMigrateContext().setTargetField(this.getTargetField());
		this.getMigrateContext().setConflict(
				ConflictResolutionType.getType(this.getResolution()));
		this.getMigrateContext().setDisposition(SourceDispositionType.getType(this.getDisposition()));
		this.getMigrateContext().setConcatenator(this.getConcatenator());
		

		return Action.SUCCESS;
	}

	public boolean isValid() {
		
		Set<String> fields = new TreeSet<String>();
		fields.add(this.getPreviewField());
		fields.add(this.getSourceField());
		fields.add(this.getTargetField());
		
		if (fields.size() != 3) {
			this.addActionMessage("Preview, Source and Target must be different fields.");
		}
		
		if (!StringUtils.hasText(this.getPreviewField())) {
			this.addActionMessage("You must select a preview field.");
		}
		
		if (!StringUtils.hasText(this.getSourceField())) {
			this.addActionMessage("You must select a source field.");
		}
		if (!StringUtils.hasText(this.getTargetField())) {
			this.addActionMessage("You must select a target field.");
		}
		if (!StringUtils.hasText(this.getResolution())) {
			this.addActionMessage("You must select a conflict resolution type.");
		}
		if (!StringUtils.hasText(this.getDisposition())) {
			this.addActionMessage("You must select a source disposition value.");
		}
		
		if (this.getUpdateBatchSize() < 5 || this.updateBatchSize > 200) {
			this.addActionMessage("You must enter a batch size between 5 and 200.");
		}
		

		return !this.hasActionMessages();

		
		
	}
	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String source) {
		this.sourceField = source;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getTargetField() {
		return targetField;
	}

	public void setTargetField(String target) {
		this.targetField = target;
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

	public String getPreviewField() {
		return previewField;
	}

	public void setPreviewField(String preview) {
		this.previewField = preview;
	}

	public Collection<Field> getFields() {

		if (this.fields == null) {
			if (this.getDescribeContext().getLastResult() == null) {
				try {
					this.getDescribeContext().setLastResult(
							this.getSalesforceSessionContext()
									.getSalesforceSession()
									.getSalesforceService().describeSObject(
											this.getDescribeContext().getTarget()));
				} catch (Exception e) {
e.printStackTrace();
				}
			}
			fields = new TreeSet<Field>(new FieldComparator());
			for (int i = 0; i < this.getDescribeContext().getLastResult()
					.getFields().length; i++) {
				fields.add(this.getDescribeContext().getLastResult()
						.getFields()[i]);
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

	public int getUpdateBatchSize() {
		return updateBatchSize;
	}

	public void setUpdateBatchSize(int updateBatchSize) {
		this.updateBatchSize = updateBatchSize;
	}

}
