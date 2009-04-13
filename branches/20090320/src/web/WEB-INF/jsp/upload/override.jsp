<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
		<script type="text/javascript" charset="UTF-8"
			src="js/loader.js"></script>
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
			<a href="${backPage}.action">Go back</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="override.action" onclick="showLoader()" >Continue</a>

		</s:form>
			<%@ include
			file="/WEB-INF/jsp/includes/loader.jsp"%>
	</body>
</html>
