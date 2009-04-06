<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
	</head>

	<body onload="hideLoader()">

		<s:actionerror />
		<s:fielderror />
		<s:form action="upload" method="POST">

			<h3>
				Object exists
			</h3>
			<br/><br/>
			The object exists in Salesforce.<br /> 
			Do you want to continue and delete it?
			<br />
			<br />
			<a href="advanceOptionsOne.action">Go back</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="override.action">Continue</a>

		</s:form>
	</body>
</html>
