package com.modelmetrics.cloudconverter.describe;

import java.util.ArrayList;
import java.util.Collection;

public class SobjectFieldPropertyBean {

	public static Collection<SobjectFieldPropertyBean> fieldBeans;
	
	private String name;
	
	private String label;
	
	private boolean main;
	
	public SobjectFieldPropertyBean(String label, String name, boolean main) {
		this.name = name;
		this.label = label;
		this.main = main;
	}
	
	public static Collection<SobjectFieldPropertyBean> getFieldBeans() {
		if (fieldBeans == null) {
			fieldBeans = new ArrayList<SobjectFieldPropertyBean>();
			
			fieldBeans.add(new SobjectFieldPropertyBean("Name","name",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Label","label",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Type","type",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Length","length",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Digits","digits",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Scale","scale",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Precision","precision",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Unique","unique",true));
//			fieldBeans.add(new SobjectFieldBean("Autonumber","autonumber",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Relationship Name","relationshipName",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Reference To","referenceTo",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Inline Help Text","inlineHelpText",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Nillable","nillable",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Picklist Values","picklistValues",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Calculated","calculated",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Case Sensitive","caseSensitive",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Controller Name","controllerName",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Defaulted On Create","defaultedOnCreate",true));
			fieldBeans.add(new SobjectFieldPropertyBean("Default Value Formula","defaultValueFormula",true));
			
			
//			fieldBeans.add(new SobjectFieldBean("filterable","filterable",false));
//			fieldBeans.add(new SobjectFieldBean("formula","formula",false));
			fieldBeans.add(new SobjectFieldPropertyBean("HTML Formatted","htmlFormatted",false));
			fieldBeans.add(new SobjectFieldPropertyBean("ID Lookup","idLookup",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Name Field","nameField",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Name Pointing","namePointing",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Restricted Picklist","restrictedPicklist",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Byte Length","byteLength",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Soap Type","soapType",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Sortable","sortable",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Createable","createable",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Custom","custom",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Dependent Picklist","dependentPicklist",false));
			fieldBeans.add(new SobjectFieldPropertyBean("Updateable","updateable",false));
			
		}
		
		return fieldBeans;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	
	
}
