
<%@page import="java.io.StringWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.mmimport.exceptions.ParseException"%>
<%
	String stackTrace = "";
	Exception e = (Exception) request.getAttribute("exception");
	if (e != null) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		printWriter.flush();
		stackTrace = stringWriter.toString();
	}
%>

<html>


	<head>
		<title>Error</title>
		<script type="text/javascript">
		function showHideDiv(){
			var div = document.getElementById('divError');
			if (div.style.display == "none"){
				div.style.display = "";
			} else {
				div.style.display = "none";
			} 
		}
	</script>
	</head>

	<body>
		<h3>
			Error
		</h3>
		<%=request.getAttribute("message")%>
		<br />
		<br />

		<a style="cursor: pointer;" href="#" onclick="showHideDiv()"> [See technical
			details]</a>

		<div id="divError" style="display:none">
			<ul>
				<li>
					Request
					<ul>

						<li>
							<b>QueryString</b>=
							<%=request.getQueryString()%>
						</li>
						<li>
							<b>SessionID</b>=
							<%=request.getSession().getId()%>
						</li>
						<li>
							<b>Path</b>=
							<%=request.getContextPath()%>
						</li>
					</ul>
				</li>
				<%
					if (e != null) {
				%>
				<li>
					Original Exception
					<ul>
						<li>
							<b>Message</b>=
							<%=e.getMessage()%>
						</li>
						<li>
							<b>StackTrace</b> =
							<br />
							<%=stackTrace%>
						</li>
						<li>
							<b>Name</b>=
							<%=e.getClass().getName()%>
						</li>

						<li>
							<b>Cause</b>=
							<%=e.getCause()%>
						</li>

					</ul>
				</li>
				<%
					}
				%>
			</ul>

		</div>
		<br />
		<br />
		<a href="init.action">Start fresh again</a>
	</body>
</html>
