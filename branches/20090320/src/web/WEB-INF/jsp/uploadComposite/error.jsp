<%@ taglib prefix="s" uri="/struts-tags"%>


<html>


	<head>
		<title>Error</title>

	</head>

	<body>
		<h1>An Error Has Occurred</h1>
		
		<p>Message: <s:property value="uploadContext.errorMessage" /></p>
		
		<p><a href="startUpload.action">Try Again.</a></p>

		<p>Questions? Contact Model Metrics - <a href="mailto:rcarlberg@modelmetrics.com">rcarlberg@modelmetrics.com</a></p>


	</body>
</html>
