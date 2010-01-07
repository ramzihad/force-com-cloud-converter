<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>View</title>
		
		
	</head>

	<body>
		
		<h1>Import Successful!</h1>

		<p>Congratulations -- you have Imported Your App.</p>
		
		<p>Step 3: Update your permissions to control which profiles can see the object. </p>
		
		<p>Simply edit the profile(s) you want to have access to the object and change tab visibility from "Tab Hidden" to "Default On".</p>
		
		<p>The objects you will want to change visibility for are:</p>
		
			<ul>
				<s:iterator value="uploadContext.cloudConverterObjects" var="object">
						<s:if test="existingObject == null">
						<li><s:property value="objectLabel" /> (<s:property value="objectName" />)</li>
						</s:if>
				</s:iterator>
			</ul>
		
		<p><a href="<s:property value="salesforceSessionContext.profileListUrl" />" target="_parent">Click here to go to your profile list.</a></p>
		
		<p>Or you can do this step later and <a href="import.action">import another.</a></p>

	</body>
</html>
