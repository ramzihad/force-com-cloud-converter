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
				<br/><br/>
				<a href="dbinit.action">Upload DB information</a>
			</s:form>
		</div>
		
		<%@ include
			file="/WEB-INF/jsp/includes/loader.jsp"%>

	</body>
</html>
