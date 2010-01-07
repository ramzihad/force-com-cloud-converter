<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Troubleshooting Tips</title>
	</head>

	<body>

	<h1><a name="top">Troubleshooting</a></h1>

	<p>Have a question other than those listed below?  Please contact <a href="mailto:cloudconverter@modelmetrics.com">cloudconverter@modelmetrics.com</a>.</p>
	
	<ul>
		<li><a href="#notvaliddata">'[Some Text]' is not a valid value for the type xsd:date</a></li>
		<li><a href="#storage">Storage Limit Exceeded</a></li>
		<li><a href="#nofield">Field ObjectName__c.FieldName__c Doesn't Exist</a></li>
		<li><a href="#admin">Admin Action Already In Process</a></li>
	</ul>
	
	<h2><a name="#notvaliddata">'[Some Text]' is not a valid value for the type xsd:date</a></h2>
	
	<p>A cell in your spreadsheet contains data that does not match the data type for that column.</p>
	
	<p>Correct by using Advanced Options and selecting the data type manually.</p>
	
	<p><a href="#top">Top</a></p>
	
	<h2><a name="storage">Storage Limit Exceeded</a></h2>
	
	<p>Occurs when you have exceeded your storage limit within Salesforce.com.  Note that
	Cloud Converter will still be able to create your new object.  This error only occurs 
	when attempting to move data.</p>
	
	<p>In Salesforce.com, check <strong>Setup > Administration Setup > Data Management > Storage Usage</strong>
	to check your storage limit and current usage.</p>
	
	<p>Free up storage space by deleting records or objects.  Note that when you delete an
	object, that object is not 100% removed from the system.  It goes into a deleted objects 
	folder along with all of the data associated with it.  In order to free up the space, 
	you need to remove it from the deleted objects folder as well.</p>
	
	<p><a href="#top">Top</a></p>
	
	<h2><a name="nofield">Field ObjectName__c.FieldName__c Doesn't Exist</a></h2>
	
	<p>From time to time, the metadata command to execute a field insert will complete successfully 
	but the field will not yet be visible to other internal metadata processes.  The easiest way to correct
	this is to simply try again.</p>  
	
	<p><a href="#top">Top</a></p>
	
	<h2><a name="admin">Admin Action Already In Process</a></h2>
	
	<p>"Admin Lock" can occur on larger orgs with complex security rules.  Unfortunately, there is no fix for it.  You must wait and try again.</p>   
		
	<p><a href="#top">Top</a></p>

	</body>
</html>

