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

public class MigrateContext {

	private String name;
	
	private String previewField;
	
	private String sourceField;
	
	private String targetField;
	
	private ConflictResolutionType conflict;
	
	private SourceDispositionType disposition;
	
	private String concatenator;
	
	private int previewQuantity;
	
	private int executeQuantity;

	public int getExecuteQuantity() {
		return executeQuantity;
	}

	public void setExecuteQuantity(int executeQuantity) {
		this.executeQuantity = executeQuantity;
	}

	public int getPreviewQuantity() {
		return previewQuantity;
	}

	public void setPreviewQuantity(int previewQuantity) {
		this.previewQuantity = previewQuantity;
	}

	public String getConcatenator() {
		return concatenator;
	}

	public void setConcatenator(String concatenator) {
		this.concatenator = concatenator;
	}

	public ConflictResolutionType getConflict() {
		return conflict;
	}

	public void setConflict(ConflictResolutionType conflict) {
		this.conflict = conflict;
	}

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String source) {
		this.sourceField = source;
	}

	public String getTargetField() {
		return targetField;
	}

	public void setTargetField(String target) {
		this.targetField = target;
	}

	public String getPreviewField() {
		return previewField;
	}

	public void setPreviewField(String preview) {
		this.previewField = preview;
	}

	public SourceDispositionType getDisposition() {
		return disposition;
	}

	public void setDisposition(SourceDispositionType disposition) {
		this.disposition = disposition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
