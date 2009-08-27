<%@ taglib prefix="s" uri="/struts-tags"%>


<s:form action="confirm" method="POST"
	enctype="multipart/form-data" theme="simple">

Are the advance options OK?
	<br />
	<s:radio list="optionsList" name="selectedOption">
	</s:radio>
	<br />
	<br />
	<s:submit value="Next" />
	<br/>
	<p><s:actionmessage /></p>
</s:form>