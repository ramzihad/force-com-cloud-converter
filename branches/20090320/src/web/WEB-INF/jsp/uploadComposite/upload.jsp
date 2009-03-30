<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
	</head>

	<body onload="hideLoader()">

		<s:actionerror />
		<s:fielderror />
		<s:form action="import2" method="POST" enctype="multipart/form-data">

			<h3>
				Upload your Excel File
			</h3>

			<table>

				<tr>
					<td>
						<s:file name="upload" label="File" />
					</td>
				</tr>
				
				<tr>
					<td>
						<s:submit value="Upload" id="butSubmit" onclick="showLoader()" />
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr style="color:#AB0000" ><td colspan="2"><s:actionmessage /></td></tr>
				
			</table>

		</s:form>
	</body>
</html>
