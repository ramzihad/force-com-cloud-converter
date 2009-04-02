<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Main Menu</title>



</head>

<body>

<h1>Main Menu</h1>

<p><a href="<s:url action="import1"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Import Your App</a></p>
<p><a href="<s:url action="selectTarget"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Metadata Explorer</a></p>

</body>
</html>