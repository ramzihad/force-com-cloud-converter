<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Layouts</title>
			<link rel="stylesheet" type="text/css" media="all" href="./css/describe.css" />

<style>
.found {
	background-color: #0F0;
}
</style>
</head>

<body>

<h1>Layouts V2</h1>


<s:if test="summary != null">
<h2><s:property value="target" /></h2>

<p>Need excel?  Switch to the <a href="<s:url action="layouts"><s:param name="target" value="target" /></s:url>">original version of layouts</a>. | 

<a href="<s:url action="describe"><s:param name="target" value="target" /></s:url>">Switch to Describe</a> |
<a href="<s:url action="layoutsv2form"><s:param name="target" value="target" /></s:url>">W2A Form</a> | </p>

<p>IMPORTANT: remember to cut and paste the standard lines at the end of this from a W2A action.</p>

<! -- START CUTTING HERE -->
<script>

var fields={<s:iterator value="summary.rows" status="all">'<s:property value='field.name' />':'<s:property value='field.label' />'<s:if test="!#all.last">,</s:if></s:iterator>};

var multi=[<s:iterator value="multipicklists" status="multi">'<s:property  />'<s:if test="!#multi.last">,</s:if></s:iterator>];

var required=[<s:iterator value="requiredFields" status="required">'<s:property  />'<s:if test="!#required.last">,</s:if></s:iterator>];

function handleSubmit() {

	if (!validate()) {
		return false;
	}
	
	processMultivalue();

	return false;
}

function validate() {

	var ret = true;

	for (var i = 0; i < required.length; i++) {
		if (document.getElementById("WEBObjectParserServlet_"+required[i]).value == '') {
			alert(fields[required[i]] + " is required.");
			document.getElementById("WEBObjectParserServlet_"+required[i]).focus();
			ret = false;
			break;
		}
	}

	return ret;

}

function processMultivalue() {

	var field; 
	var hiddenField;
	var selected;

	for (var i = 0; i < multi.length; i++) {
		selected = "";
		field = document.getElementById("WEBObjectParserServlet_"+multi[i]+"_multi");
		hiddenField = document.getElementById("WEBObjectParserServlet_"+multi[i]);

		for (var j = 0; j < field.options.length; j++) {
			if (field.options[j].selected) {
				if (selected != "" ) {
					selected = selected + ";";
				}
				selected = selected + field.options[j].value;
			}
		}
		
		hiddenField.value = selected;		
	}	
}


</script>

</p>

	<s:form action="https://www.modelmetricssoftware.com/web2anything/servlet/WEBObjectParserServlet" onsubmit="return handleSubmit()" >

	<s:iterator value="summary.rows">

		<s:set name="required" value="false" />
		
		<s:iterator value="layouts">
			<s:if test="present">
				<s:if test="required">
					<s:set name="required" value="true" />
				</s:if>
			</s:if>
		</s:iterator>	
			
		<s:if test="'${field.type}' == 'string'">
			<s:if test="'${field.name}' != 'Name'" >
				<s:textfield name="${field.name}" label="${field.label}" required="#required"  />
			</s:if>
		</s:if>
		
		<s:if test="'${field.type}' == 'double'">
			<s:textfield name="${field.name}" label="${field.label}" required="#required"   />
		</s:if>
		
		<s:if test="'${field.type}' == 'currency'">
			<s:textfield name="${field.name}" label="${field.label}" required="#required"   />
		</s:if>
		
		<s:if test="'${field.type}' == 'picklist'">
			<s:select name="${field.name}" label="${field.label}" list="field.picklistValues" listKey="value" listValue="value" required="#required" emptyOption="true" />
		</s:if>
		
		<s:if test="'${field.type}' == 'multipicklist'"  >
			<s:select name="${field.name}_multi" label="${field.label}" list="field.picklistValues" listKey="value" listValue="value" multiple="true"  required="#required"/>
			<s:hidden key="${field.name}" />
		</s:if>
		
		<s:if test="'${field.type}' == 'reference'"></s:if>
		
		<s:if test="'${field.type}' == 'date'">
			<s:textfield name="${field.name}" label="${field.label}"  required="#required" />
		</s:if>	
	
		
	</s:iterator>
	
	<s:submit />


		
	<!-- INSERT STANDARD ORG RELATED FIELDS HERE -->


	<!-- END FORM -->

	</s:form>


</s:if>

</body>
</html>