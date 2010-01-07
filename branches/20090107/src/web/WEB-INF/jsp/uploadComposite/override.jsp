<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>

<html>
	<head>
		<title>Upload</title>
		<script type="text/javascript" charset="UTF-8" src="js/loader.js"></script>
	</head>

	<body onload="hideLoader()">
		<div id="form">
			<s:actionerror />
			<s:fielderror />
			<s:form action="upload" method="POST">

				<h3>
					Object/s exist/s
				</h3>
				<br />
				<br />
			These objects already exist.
			<ul>
				<c:forEach items="${sheets}" var="sheet">
					<li>
						${sheet}
					</li>
				</c:forEach>
			
			</ul>
		
			Do you want to continue and delete it/them?
			<br />
				<br />
				<a href="${backPage}.action">Go back</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="importOverride.action" >Continue</a>

			</s:form>
		</div>
	
	</body>
</html>
