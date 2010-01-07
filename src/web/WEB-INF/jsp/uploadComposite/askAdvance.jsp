<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>Standard Import</title>
</head>
<body>

<s:form action="importBranch" method="POST"
	enctype="multipart/form-data" theme="simple">

<h1>Standard Import</h1>

<p>Perfect for one-click creation of objects and data in salesforce.com.</p>

<p><s:submit name="submit" value="Standard Import" /></p>

<h1>Advanced Import</h1>

<p>Review worksheet settings before creating objects in salesforce.com.  Change field names, data types, specify external ID's, lookups and picklists.</p>

<p><s:submit name="submit" value="Show Advanced Options" /></p>

</s:form>

</body>

</html>