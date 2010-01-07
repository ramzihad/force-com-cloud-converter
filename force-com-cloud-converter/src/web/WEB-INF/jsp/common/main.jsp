<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Main Menu</title>



</head>

<body>

<div id="puHeader" style="float:left; text-align: left;">

<h1>Main Menu</h1>

<p><a href="<s:url action="import"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Import Your App from Excel</a></p>
<p><a href="<s:url action="select"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Explore Your Metadata</a></p>
<p><a href="<s:url action="migrate"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Migrate A Field</a></p>

<s:if test="salesforceSessionContext.admin">
	<p><a href="<s:url action="admin"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Admin</a></p>
</s:if>

</div>

<div id="puHeader" style="float:right; text-align: center;">


<h2>CloudConverter on YouTube</h2>

<p><object width="480" height="385"><param name="movie" value="http://www.youtube.com/p/B82E027A6915FB20&amp;hl=en_US&amp;fs=1"></param><param name="allowFullScreen" value="true"></param><param name="allowscriptaccess" value="always"></param><embed src="http://www.youtube.com/p/B82E027A6915FB20&amp;hl=en_US&amp;fs=1" type="application/x-shockwave-flash" width="480" height="385" allowscriptaccess="always" allowfullscreen="true"></embed></object></p>
</div>

</body>
</html>