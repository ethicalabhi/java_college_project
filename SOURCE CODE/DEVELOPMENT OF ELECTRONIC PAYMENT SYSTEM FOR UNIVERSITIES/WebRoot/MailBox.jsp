<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int count = 0;
%>
<%
	if (session.getAttribute("role") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
%>
<%
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
		<form name='mails' method='post' action='DeleteMailsAction'>
			<table border='1'>
				<tr bgcolor='white'>
					<td></td>


					<td align='center' width='200'>
						<b>MailHead</b>
					</td>
					<td align='center' width='100'>
						<b>Attachments</b>
					</td>

					<td align='center' width='100'>
						<b>Date</b>
					</td>
				</tr>

				<c:forEach var="mails" items="${mails}">
					<tr>

						<td>
							<input name="ch" type="checkbox" id="checkbox2" onClick="check1()" value="${mails.messageid }" />
						</td>

						<td align='center'>
							<b><a
								href="./ViewMailBody?messageid=${mails.messageid}&mailbox=${mails.mailbox}">${mails.mailsub
									}</a> </b>
						</td>
						<td align='center'>
							<b> <a
								href="./ViewMailAttachmentAction?messageid=${mails.messageid}&mailbox=${mails.mailbox}">${mails.attachcount}</a>
							</b>
						</td>
						<td align='center'>
							<b> ${mails.maildate}</b>
						</td>
						<input type='hidden' name='mailbox' value='${mails.mailbox}'>
					</tr>
				</c:forEach>
				<tr>
				</tr>
				<tr>
					<td align='center' colspan='8'>
						<input type="submit" value="Delete" />
					</td>
				</tr>
			</table>
		</form>
		</center>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
