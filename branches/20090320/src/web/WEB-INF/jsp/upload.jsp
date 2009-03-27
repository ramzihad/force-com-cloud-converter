<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>

		<script>
			function showLoader(){
				var div = document.getElementById('loading');
				
				div.style.display = "";
				
			}
			function hideLoader(){
				var div = document.getElementById('loading');
			
				div.style.display = "none";
			
			}
		</script>
	</head>

	<body onload="hideLoader()">

		<s:actionerror />
		<s:fielderror />
		<s:form action="upload" method="POST" enctype="multipart/form-data">

			<h3>
				Upload your Excel File
			</h3>

			<table>
				<tr>
					
					<td>
						<s:textfield name="username" label="Username"/>
					</td>
				</tr>
				<tr>
					
					<td>
						<s:password name="password" label="Password" />
					</td>
				</tr>
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
				<tr>
					<td colspan="2">
						<div id="loading" style="display:none;float: right">
							<img src="img/loader.gif">
						</div>
					</td>
				</tr>
			</table>

		</s:form>
	</body>
</html>
