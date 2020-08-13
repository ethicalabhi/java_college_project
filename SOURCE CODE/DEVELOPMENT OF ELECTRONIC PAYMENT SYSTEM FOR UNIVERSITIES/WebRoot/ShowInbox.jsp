<%@page import="com.college.FormBean.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.mail.Address"%>
<body>
	<jsp:include page="Header.jsp"></jsp:include><center>
		<font color="#1D6EFF"><b><i>Welcome <%=(String) session.getAttribute("user")%>,Here
					is ur inbox</i> </b> </font>
	</center>
	<center>
		<table>
			<%
				ArrayList<MailDTO> ar = (ArrayList<MailDTO>) request
						.getAttribute("email");
				Iterator<MailDTO> it = (Iterator<MailDTO>) ar.iterator();
				int i = 0;
				while (it.hasNext()) {
					i++;
					MailDTO md = it.next();
					session.setAttribute("mail" + i, md);
			%>
			<tr>
				<a href="./ShowMail.jsp?id=<%=i%>"><%=md.getSubject()%></a>
			</tr>
			<%
				}
			%>
		</table>
	</center>
</body>