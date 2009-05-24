<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Main Menu</title>



</head>

<body>

<h1>Main Menu - Beta</h1>

<p><a href="<s:url action="import"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Import Your App</a></p>
<p><a href="<s:url action="select"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Explore Your Metadata</a></p>

</body>
</html>