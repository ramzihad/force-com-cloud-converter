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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.cloudconverter.util.OperationStatusSubscriber;
import com.sforce.soap.partner.DescribeSObjectResult;

public class DescribeContext {

//	private Collection<String> objectTypes;
	
	private String[] typesArray;

	private Collection<String> types;
	
	private String target;

	private Map<String, DescribeSObjectResult> descriptions = new HashMap<String, DescribeSObjectResult>();
	
	private DescribeSObjectResult lastResult;

	private String lastMessage;
	
	private OperationStatusSubscriber statusSubscriber;
	
	private HSSFWorkbook workbook;
	
	static Pattern escaper = Pattern.compile("([^a-zA-Z0-9_])");
	
	public OperationStatusSubscriber getStatusSubscriber() {
		return statusSubscriber;
	}

	public void setStatusSubscriber(OperationStatusSubscriber statusSubscriber) {
		this.statusSubscriber = statusSubscriber;
	}

	public void initialize() {

		this.typesArray = null;


		this.descriptions = new HashMap<String, DescribeSObjectResult>();
	}

	public String[] getTypesArray() {
		return typesArray;
	}

	public void setTypesArray(String[] types) {
		this.typesArray = types;
	}

	public Map<String, DescribeSObjectResult> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Map<String, DescribeSObjectResult> descriptions) {
		this.descriptions = descriptions;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) throws InvalidTypeException {
		target = escaper.matcher(target).replaceAll("");
		if (this.getTypes() == null || !this.getTypes().contains(target)) {
			// Throw invalid type exception
			throw new InvalidTypeException();
		}
		this.target = target;
	}

	public DescribeSObjectResult getLastResult() {
		return lastResult;
	}

	public void setLastResult(DescribeSObjectResult lastResult) {
		this.lastResult = lastResult;
	}

//	public Collection<String> getObjectTypes()
//	{
//		objectTypes = Arrays.asList(typesArray);
//		return objectTypes;
//	}
//
//	public void setObjectTypes(Collection<String> objectTypes)
//	{
//		this.objectTypes = objectTypes;
//	}

	public String getLastMessage() {
		return lastMessage;
	}
	
	public String getLastMessageWithReset() {
		String ret = lastMessage;
		lastMessage = null;
		return ret;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

	public Collection<String> getTypes() {
		return types;
	}

	public void setTypes(Collection<String> types) {
		this.types = types;
	}

	public boolean isWorkbookPresent() {
		return this.workbook != null;
	}
	public HSSFWorkbook getWorkbook() {
//		HSSFWorkbook ret = this.workbook;
		
//		this.workbook = null;
		
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}



}
