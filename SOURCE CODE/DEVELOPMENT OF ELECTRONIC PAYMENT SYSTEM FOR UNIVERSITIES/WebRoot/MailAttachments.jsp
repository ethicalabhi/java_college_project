<%@ page language="java" import="java.util.*,java.io.*"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.college.FormBean.MailDTO;"%>
<%@ page errorPage="UserExceptionHandler.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String fileString = "";
	MailDTO mail = null;
%>
<%
	if (session.getAttribute("userid") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
	}
%>

<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
</script>



	</head>

	<body>

		<jsp:include page="Header.jsp"></jsp:include>

		<center>
			<h3>
				<font color="red">Mail Attachments</font>
			</h3>
		</center>


		<%
			Vector c = (Vector) request.getAttribute("vmail");
			Iterator it = c.listIterator();
			String str = "";
			while (it.hasNext()) {
				str = "";
				mail = (MailDTO) it.next();
				str = mail.getAttachmentfile();
		%>
		<center>
			<table>
				<td>
					<a href='<%=str%>'><%=new File(mail.getAttachmentfile()).getName()%></a>
				</td>
				<%
					}
				%>
			</table>
		</center>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
