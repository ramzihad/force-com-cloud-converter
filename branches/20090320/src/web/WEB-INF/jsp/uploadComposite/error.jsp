<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>


	<head>
		<title>Error</title>

	</head>

	<body>
		<h1>Error</h3>
		
		<p>Message: <s:property value="errorMessage" /></p>
		
	<p><a href="import.action">Start fresh again</a></p>
	</body>
</html>
