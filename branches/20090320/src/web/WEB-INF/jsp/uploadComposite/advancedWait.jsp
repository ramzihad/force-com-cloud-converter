<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Loading objects...</title>
		<meta http-equiv="refresh" content="5;url=<s:url includeParams="none" />"/>
	</head>

	<body>

	<h2>Advanced Options: Importing Object <s:property value="uploadContext.currentCloudConverterObjectIndex + 1" /> of <s:property value="uploadContext.cloudConverterObjects.size" /> - <s:property value="uploadContext.currentCloudConverterObject.objectLabel" /></h2>
	
	<p>Once this object is complete, you will be able to set options for the next.</p>
	
	<h2>Current Status, Newest First</h2>
	
	<p>This page refreshes automatically every five seconds.  Please be patient.</p>
	
	<p>
	
	<s:iterator value="uploadContext.statusSubscriber.status">
		- <s:property /><br/>
	</s:iterator>
	
	</p>

	<h1>What Do You Think?</h1>
	
	<p>Have a suggestion on how to improve this application? Contact Reid Carlberg at <a href="mailto:rcarlberg@modelmetrics.com">rcarlberg@modelmetrics.com</a> or on Twitter at <a href="http://Twitter.com/ReidCarlberg" target="_blank">@ReidCarlberg</a>.</p>
	
	<p>Visit <a href="http://modelmetrics.com" target="_blank">Model Metrics</a> on the web to learn more about our services.</p>
	

	</body>
</html>

