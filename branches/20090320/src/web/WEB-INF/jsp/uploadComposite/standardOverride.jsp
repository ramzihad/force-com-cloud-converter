<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Confirm</title>
		
		
<script language="javascript">

function areYouSure() {
	return confirm("Are you sure.");
}

</script>
	</head>

	<body>

			<h1>Please Confirm:</h1>

			<p>These objects already exist in your org.</p>
			<ul>
				<s:iterator value="uploadContext.cloudConverterObjects" var="object">
					<s:if test="existsInSalesforce" >
						<li><s:property value="objectLabel" /> (<s:property value="objectName" />)</li>
					</s:if>
				</s:iterator>
			</ul>

			<s:form action="importStandardOverride" method="POST" onsubmit="return areYouSure();">
		
			<p>If you continue, the current objects and data will be deleted.</p>
			
			<p>Do you want to continue?</p>

			<p><s:submit name="submit" value="No - Start Over" />	
			<s:submit name="submit" value="Yes - Continue" /></p>

			</s:form>
	
	</body>
</html>
