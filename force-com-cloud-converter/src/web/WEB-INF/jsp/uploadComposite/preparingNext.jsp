<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Loading objects...</title>
		<meta http-equiv="refresh" content="5;url=<s:url includeParams="all" />"/>
	</head>

	<body>

	<h2>Advanced Options: Preparing Next Object. Please Wait a Moment.</h2>

	<p>Currently fetching information from salesforce.com for use on the next screen.  If you have a large number of custom objects, this may take a bit longer.
	
	<p>This page refreshes automatically every five seconds.  Please be patient.</p>

	<p>
	
	<s:iterator value="uploadContext.statusSubscriber.status">
		- <s:property /><br/>
	</s:iterator>
	
	</p>

	<h1>More Information</h1>
	
	<p>Have a suggestion on how to improve this application? Visit <a href="http://modelmetrics.com" target="_blank">Model Metrics</a> on the web to learn more about our services or provide feedback.</p>
	

	</body>
</html>

