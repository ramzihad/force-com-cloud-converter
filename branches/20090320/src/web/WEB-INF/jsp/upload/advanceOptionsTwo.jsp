
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>

<html>
	<head>
		<title>Advance Options</title>
		<script type="text/javascript" charset="UTF-8"
			src="js/jquery-1.3.1.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("select.salesforceObjects").change(function() {
					
					var form = $("#advForm");
					var form_elements = form.find('select');
					form_elements.attr('disabled', 'disabled');
					form.attr("disabled","disabled");
					var parent = $(this).parent().parent();
					parent.find("img.loader").css('display','');
					$.getJSON("loadObjectFields.action",{id: $(this).val()}, function(j){
				    	var options = '';
				    	for (var i = 0; i < j.length; i++) {
				        	options += '<option value="' + j[i].value + '">' + j[i].value + '</option>';
				      	}
				      	parent.find("select.objectFields").html(options);
				      	parent.find("img.loader").css('display','none');
				      	form_elements.attr('disabled', '');
				    })
				});
				$("#btnsubmit").click(function() {
					//validate here
					var error=false;
					$("select.salesforceObjects").each(function(){
						if ($(this).val()==''){
							$("#mge").show();
							error=true;
						}
					});
					if (!error){
						$("#advForm").submit();
					}
				});
			});
		</script>
	</head>

	<body>
		<h3>
			Advance Options page 2
		</h3>
		<s:form action="checkExistance" method="POST" id="advForm"
			disabled="disabled" theme="simple">
			<a href="backToPageOne.action">Back</a>
			<input type="button" id="btnsubmit" value="Next" />
			
			
			<br />
			<br />
			<s:iterator value="lookupIdWrapperList" var="lookupIdWrapper"
				status="parentStatus">
				
				<b>Object ${parentStatus.index+1}</b>
				<br /><br />
				External ID Settings
				<br />
				<table border="1">
					<tr>
						<td>
							Field
						</td>
							<td>
							Label
						</td>
						<td colspan="2">
							Unique
						</td>
					</tr>
					<s:iterator value="#lookupIdWrapper.externalIds" var="externalIdBean" status="status">

						<tr>
							<td>
								${externalIdBean.label}
							</td><td>
								<s:textfield id="lookupIdWrapperList[%{#parentStatus.index}].externalIds[%{#status.index}].label"
									name="lookupIdWrapperList[%{#parentStatus.index}].externalIds[%{#status.index}].label"
									value="%{lookupIdWrapperList.[#parentStatus.index].externalIds[#status.index].label}" theme="simple" />
							</td>
							<td>
								<s:select list="uniques" listKey="id" listValue="value"
									theme="simple" name="lookupIdWrapperList[%{#parentStatus.index}].externalIds[%{#status.index}].unique"
									value="%{lookupIdWrapperList.[#parentStatus.index].externalIds[#status.index].unique}" />

							</td>
						</tr>
					</s:iterator>
				</table>
				<br />
				<br />

				<br />
		
	
				Lookup Field Settings
				<table border="1">
					<tr>
						<td>
							Field
						</td>
						<td>
							Label
						</td>
						<td>
							Source Object
						</td>
						<td>
							Source Field
						</td>
					</tr>

					<s:iterator value="#lookupIdWrapper.lookups" var="lookupdBean" status="status">
						<tr>
							<td>
								${lookupdBean.label}
							</td>
							<td>
								<s:textfield id="lookupIdWrapperList[%{#parentStatus.index}].lookups[%{#status.index}].label"
									name="lookupIdWrapperList[%{#parentStatus.index}].lookups[%{#status.index}].label"
									value="%{lookupIdWrapperList.[#parentStatus.index].lookups[#status.index].label}" theme="simple" />
							</td>
							<td>
								<s:select cssClass="salesforceObjects" list="salesforceObjects"
									listKey="id" listValue="value" theme="simple"
									name="lookupIdWrapperList[%{#parentStatus.index}].lookups[%{#status.index}].sourceObject"
									value="%{lookupIdWrapperList.[#parentStatus.index].lookups[#status.index].sourceObject}" />
								<img class="loader" style="display: none;"
									src="./img/loading.gif" />
							</td>
							<td>
								<select name="fields" class="objectFields"></select>
							</td>
						</tr>
					</s:iterator>

				</table>

				<br />
				<br />
				

			</s:iterator>
		</s:form>


		<div id="mge" style="display: none">
			<br />
			<br />
			You must select an object for each lookup
		</div>


		<br />
		<br />
		<a href="backToPageOne.action">Back</a>

	</body>
</html>

