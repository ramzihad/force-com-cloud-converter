<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>
	<head>
		<title>View</title>
		
		
	</head>

	<body>
		
		<h1>Successfully Imported "<s:property value="uploadContext.wrapperBean.sheetName" />"</h1>

		<p>Congratulations! You have Imported Your App.</p>
		
		<p>Step 3: Update your permissions to control which profiles can see the object. </p>
		
		<p>Simply edit the profile(s) you want to have access to the object and change tab visibility from "Tab Hidden" to "Default On".</p>
		
		<p>The object you want to change tab visibility for is "<s:property value="uploadContext.wrapperBean.sheetName" />".</p>
		
		<p><a href="<s:property value="salesforceSessionContext.profileListUrl" />" target="_parent">Click here to go to your profile list.</a></p>
		
		<p>Or you can do this step later and <a href="import.action">import another.</a></p>

	</body>
</html>
