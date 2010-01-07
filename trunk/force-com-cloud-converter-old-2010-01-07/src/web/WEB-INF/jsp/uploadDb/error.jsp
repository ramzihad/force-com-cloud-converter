<%@ taglib prefix="s" uri="/struts-tags"%>
<html>


	<head>
		<title>Error</title>
		<script type="text/javascript">
		
	</script>
	</head>

	<body>
		<h3>
			${message}
		</h3>
		
		<br />
		<br />
		<s:actionmessage />
		<br />
		<br />
		<a href="dbinit.action">Start fresh again</a>
	</body>
</html>
