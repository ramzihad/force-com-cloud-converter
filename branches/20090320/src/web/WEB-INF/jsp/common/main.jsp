<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Main Menu</title>



</head>

<body>


<h1>Main Menu - Beta</h1>

<p><a href="<s:url action="import"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Import Your App from Excel</a></p>
<p><a href="<s:url action="select"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Explore Your Metadata</a></p>
<p><a href="<s:url action="migrate"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Migrate A Field</a></p>





</body>
</html>