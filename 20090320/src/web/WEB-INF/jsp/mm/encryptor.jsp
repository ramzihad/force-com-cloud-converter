<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<title>Encryptor</title>

</head>
<body bgcolor="black">
<h2>Encrypt Utility</h2>
<br/>
<i>Note:  AES is used for the SFDC password.  MD5 is used for the Web2Admin portal password.</i>
<s:form action="encrypt.action">
    <s:textfield label="Password" key="password"/>
    <s:label label="Encrypted Password" key="encryptedPassword" />
    <s:select label="Type" key="type" list="#{'AES':'AES','MD5':'MD5'}"/>
    <s:submit name="submit" />
</s:form>
</body>
</html>