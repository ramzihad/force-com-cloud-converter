<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h1>Describe</h1>
<p><s:iterator value="describeContext.types"><a href="<s:url action="describe"><s:param name="target" value="[0].top" /></s:url>"><s:property /></a> | </s:iterator></p>
