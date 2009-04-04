<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>


	<head>
		<title>Error</title>

	</head>

	<body>
		<h1>Error</h1>
		
		<p><s:actionmessage /></p>
		
		<p>Message: <s:property value="errorMessage" /></p>
		
		<p><a href="import1.action">Please try again./a></p>
	</body>
</html>
