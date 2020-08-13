<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Online Wish System</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="robots" content="all" />
		<link href="screen.css" rel="stylesheet" type="text/css"
			media="screen" />
		<script>
function addElement_image() {
	var ni = document.getElementById('myDivImage');
	var numi = document.getElementById('theValue');
	var num = (document.getElementById('theValue').value - 1) + 2;
	numi.value = num;
	var newdiv = document.createElement('div');
	var divIdName = 'my' + num + 'DivImage';
	newdiv.setAttribute('id', divIdName);
	newdiv.innerHTML = '<td><p><input name="image[image_'
			+ num
			+ ']" type="file" value="Add" ><input name="ch" type="checkbox" id="checkbox2"	 value="image[image_'
			+ num + ']" checked/></td>';
	ni.appendChild(newdiv);
}

function removeElement_image(divNum) {
	var d = document.getElementById('myDivImage');
	var olddiv = document.getElementById(divNum);
	d.removeChild(divNum);
}</script>
		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript">
</script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js">
</script>
		<script language="JavaScript1.1" src="scripts/pass.js">

</script>
		<script type="text/javascript" src="scripts/image.js">
</script>
		<script type="text/javascript" src="scripts/general.js">
</script>
		<script type="text/javascript" src="scripts/adi.js">
</script>
		<script type="text/javascript" src="scripts/form_validation.js">
</script>

		<script language="JavaScript" src="images/javascripts.js">
</script>
		<script language="JavaScript" src="images/pop-closeup.js">
</script>

		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>
		<script type="text/javascript" src="scripts/project.js">
</script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>




		<center> <%
 	if (request.getParameter("status") != null) {
 %> <%=request.getParameter("status")%> <%
 	}
 %> </center>
		<br />

		<form id="form1" method='post' action="./SendMailAction" name="mail">
			<table width="337" border="0" align="center">

				<tr>
					<td align='right'>
						<b>To :</b>
					</td>
					<td>
						<select name="empid" id="select">
							<option>
								--SELECT--
							</option>
							<c:if test="${not empty mailcontacts}">
								<c:forEach var="mails" items="${mailcontacts}">
									<option value="${mails.empid}">
										${mails.mailid}
									</option>
								</c:forEach>
							</c:if>
						</select>
					</td></tr>
					<tr>
						<td>
							&nbsp;
							<tr>
								<td align='right'>
									<b>Sub :</b>
								</td>
								<td>
									<input name="mailsub" type="text" id="textfield2" size="48" />
								</td>
							</tr>
							<tr>
								<td>
									<span class="style1"><b>Mail Matter :</b>
								</td>
								<td>
									<textarea name="mailbody" id="textarea" cols="45" rows="5"></textarea>
								</td>
								<input type="hidden" name='frommailid' value="<%=session.getAttribute("userid")%>" />
							</tr>
							<tr>
								<td align='right'>
									Attachments:
								</td>
								<td>
									<input type="button" id="add_more" value="Add More"
										name='addfile' onclick="addElement_image();" />

									<input type="hidden" value="0" id="theValue" />
									<div id="myDivImage"></div>
								</td>
							</tr>
							<tr>
								<td colspan="2">

									<input type="submit" name="button" id="button" value="Send" />

								</td>
							</tr>
			</table>
		</form>

		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("mail");
frmvalidator.addValidation("empid", "dontselect=0");
frmvalidator.addValidation("mailsub", "req", "Please enter your Mail Subject");
frmvalidator.addValidation("mailbody", "req", "Please enter Mail Body");
</script>
		<jsp:include page="Footer.jsp"></jsp:include>




	</body>
</html>
