<%@page import="com.college.FormBean.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.mail.Address"%>
<%@page import="javax.mail.*"%>

<body>
	<jsp:include page="Header.jsp"></jsp:include>


	<%
		int id = Integer.parseInt(request.getParameter("id"));
		pageContext.setAttribute("email", (MailDTO) session
				.getAttribute("mail" + id));
	%>


	<table align="center">
		<tr>
			<td colspan="1" width="550" height="300" valign="top">
				<p>
					<br />
				</p>
				<h3>
					<font color="#1D6EFF"><b><i>Welcome <%=(String) session.getAttribute("user")%>,Here
								is ur mail</i> </b> </font>
				</h3>
				<table align="left" width="548" border="1" bordercolor="#FFDEE0"
					bgcolor="#F3F6EF">
					<tr>
						<td width="5" valign="top">
							<font color="blue"><b>From : </b> </font>
						</td>
						<td width="540">
							<b><jsp:getProperty name="email" property="from" /></b>
							<br />
						</td>
					</tr>
					<tr>
						<td width="5" valign="top">
							<font color="blue"><b>Subject : </b> </font>
						</td>
						<td width="540">
							<b><jsp:getProperty name="email" property="subject" /></b>
							<br />
						</td>
					</tr>
					<tr>
						<td align="center" valign="top" colspan="2">
							<font color="blue"><b>Message</b> </font>
						</td>
					</tr>
					<tr>
						<td colspan="2" valign="top" height="150"><jsp:getProperty
								name="email" property="content" /><br />
							<br>
						</td>
					</tr><tr>
						<td colspan="2" valign="top" height="150"><jsp:getProperty
								name="email" property="attachmentfile" /><br />
							<br>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>