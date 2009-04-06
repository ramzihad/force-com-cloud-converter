<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Migrate Utility</title>
</head>

<body>

<h1>Migrate Setup</h1>

<p>Note: because this is just working quickly, I'm being lazy and forcing you to configure the object in Describe.</p>

<p>If you haven't used this before, you should work it on a dev org first to get used to it.</p>

<p>Also, this technical is supposed to have some rollback functionality, but it doesn't just yet.  SO BE CAREFUL.</p>

<p>FINALLY: this is an aggressive routine.  It will go through every object record in the org.  If you have a million records of the object you're working with, it will attempt to do that.</p>


<s:form action="migrateSetup.action">

<s:select label="Preview Field"
       name="preview"
       list="fields"
       listKey="name"
       listValue="label + ' (' + name + ')'" emptyOption="true"
       required="true"
/>

<s:select label="Source Field"
       name="source"
       list="fields"
       listKey="name"
       listValue="label + ' (' + name + ')'" emptyOption="true"
       required="true"
/>

<s:select label="Target Field"
       name="target"
       list="fields"
       listKey="name"
       listValue="label + ' (' + name + ')'" emptyOption="true"
       required="true"
/>

<s:select label="Conflict Resolution"
       name="resolution"
       list="conflictResolutionTypes"
       listKey="name"
       listValue="name"  emptyOption="true"
       required="true"
/>

<s:select label="Source Disposition"
       name="disposition"
       list="sourceDispositionTypes"
       listKey="name"
       listValue="name"  emptyOption="true"
       required="true"
/>

<s:textfield label="Concatenator" key="concatenator"/>

<s:textfield label="Name (records in database)" key="name" required="true" />

<s:submit name="submit" />

</s:form>

<p>Notes</p>

</body>
</html>