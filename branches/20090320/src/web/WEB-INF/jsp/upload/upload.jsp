<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Upload</title>
		<script type="text/javascript">
		
		function showLoader(){
			var div = document.getElementById('loading');
			var formDiv = document.getElementById('form');
			if (div.style.display == "none"){
				div.style.display = "";
				formDiv.style.display = "none";
			} else {
				div.style.display = "none";
				formDiv.style.display = "";
			} 
		}
		function hideLoader(){
			var div = document.getElementById('loading');
			var formDiv = document.getElementById('form');
			div.style.display = "none";		
			formDiv.style.display = "";
		}
		</script>
	</head>

	<body onload="hideLoader()">

		<s:actionerror />
		<s:fielderror />
		<div id="form">
			<s:form action="upload" method="POST" enctype="multipart/form-data">

				<h3>
					Upload your Excel File
				</h3>

				<table>
					<tr>

						<td>
							<s:textfield name="username" label="Username" />
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
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr style="color:#AB0000">
						<td colspan="2">
							<s:actionmessage />
						</td>
					</tr>

				</table>

			</s:form>
		</div>
		<div id="loading" style="display:none">
			
			<h3>
				Please wait while we process your request
			</h3>
			<br /><br />
			Creating the object...
			<br />
			Adding fields...
			<br />
			Building a custom tab...
			<br />
			Modifying the page layout...
			<br />
			Moving data...
			<br />
			<br />
			<img src="img/loader.gif">
		</div>

	</body>
</html>
