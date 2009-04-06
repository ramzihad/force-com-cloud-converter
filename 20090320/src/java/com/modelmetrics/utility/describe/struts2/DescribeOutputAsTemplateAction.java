package com.modelmetrics.utility.describe.struts2;

import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.common.poi.ExcelSupport;
import com.modelmetrics.utility.describe.DescribeExcelBuilderDelegate;
import com.opensymphony.xwork2.Action;

public class DescribeOutputAsTemplateAction extends DescribeAction
{
	private String submit;
	private Collection<String> selectedObjects;
	private HSSFWorkbook workbook;
	
	public String execute() throws Exception 
	{
		if (this.getSubmit() == null)
			return Action.INPUT;
		
		
		ExcelSupport excelSupport = new ExcelSupport();

		HSSFWorkbook workbook = excelSupport.getWorkbook();
		
		DescribeExcelBuilderDelegate delegate = new DescribeExcelBuilderDelegate();
		
		for (Iterator iter = selectedObjects.iterator(); iter.hasNext();)
		{
			String objectType = (String) iter.next();
			this.setTarget(objectType);
			super.execute();

			
			delegate.handleBuild(this.getResults(), excelSupport, workbook, this.getTarget());
		}
		
		this.setWorkbook(workbook);
		return Action.SUCCESS;
	}
	
	public String getSubmit()
	{
		return submit;
	}

	public void setSubmit(String submit)
	{
		this.submit = submit;
	}

	public Collection<String> getSelectedObjects()
	{
		return selectedObjects;
	}

	public void setSelectedObjects(Collection<String> selectedObjects)
	{
		this.selectedObjects = selectedObjects;
	}
	
	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

}
