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

		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js"></script>
		<script language="JavaScript1.1" src="scripts/pass.js">


</script>
		<script type="text/javascript" src="scripts/image.js"> </script>
		<script type="text/javascript" src="scripts/general.js"> </script>
		<script type="text/javascript" src="scripts/adi.js"> </script>
		<script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>

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
		<script type="text/javascript" src="scripts/project.js"></script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>

		<%
			if (request.getParameter("status") != null) {
		%>
		<%=request.getParameter("status")%>
		<%
			}
		%>
		</center>
		<br />

		<form id="form1" method='post' action="./SendMailAction"
			name="register">
			<table width="337" border="0" align="center">
				<c:if test="${not empty msgbody}">
					<c:forEach var="mails" items="${msgbody}">
						<tr>
							<td>
								<b>Date :</b>
							</td>
							<td align='left'>
					
								<b> ${mails.maildate}</b>
							</td>
						</tr>
						<td>
							&nbsp;
						<tr>
							<td align='right'>
								<b>Sub :</b>
							</td>
							<td>
								<input name="mailsub" type="text" id="textfield2" size="48"
									value='${mails.mailsub}' />
							</td>
						</tr>
						<tr>
							<td>
								<span class="style1"><b>Mail body :</b>
							</td>

							<td>
								<textarea name="mailbody" id="textarea" cols="45" rows="5"
									value=''>${mails.mailbody}</textarea>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</form>






	</body>
</html>
