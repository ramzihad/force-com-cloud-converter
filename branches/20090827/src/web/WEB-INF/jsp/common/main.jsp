<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Main Menu</title>



</head>

<body>

<table width="100%" border="0">

<tr>

<td valign="top">

<h1>Main Menu</h1>

<p><a href="<s:url action="import"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Import Your App from Excel</a></p>
<p><a href="<s:url action="select"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Explore Your Metadata</a></p>
<p><a href="<s:url action="migrate"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Migrate A Field</a></p>

<s:if test="salesforceSessionContext.admin">
	<p><a href="<s:url action="admin"><s:param name="s" value="existingSessionId" /><s:param name="u" value="existingLocationUrl" /></s:url>">Admin</a></p>
</s:if>

</td>

<td valign="top">

<h1>Four Minutes With CloudConverter</h1>

<object width="480" height="295"><param name="movie" value="http://www.youtube.com/v/BI0_eJbqa8c&hl=en&fs=1&"></param><param name="allowFullScreen" value="true"></param><param name="allowscriptaccess" value="always"></param><embed src="http://www.youtube.com/v/BI0_eJbqa8c&hl=en&fs=1&" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="480" height="295"></embed></object>

<h1>How To Prepare Your Spreadsheet For CloudConverter</h1>

<object width="480" height="295"><param name="movie" value="http://www.youtube.com/v/Tyq1Vm-Xq38&hl=en&fs=1&"></param><param name="allowFullScreen" value="true"></param><param name="allowscriptaccess" value="always"></param><embed src="http://www.youtube.com/v/Tyq1Vm-Xq38&hl=en&fs=1&" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="480" height="295"></embed></object>

</td>

</tr>

</table>


</body>
</html>