
<%
	if (request.getParameter("status") != null) {
%>
<center>
	<strong><font color=red><%=request.getParameter("status")%></font>
	</strong>
	<%
		}
	%>
</center>
