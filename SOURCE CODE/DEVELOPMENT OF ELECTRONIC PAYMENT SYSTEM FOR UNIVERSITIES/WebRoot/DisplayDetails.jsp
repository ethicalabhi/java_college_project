<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><%@ page language="java" import="java.util.*"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	if (session.getAttribute("loginuser") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
%>
<%
	}
%>
<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
</script>


		
			<base href="<%=basePath%>">

			<title>My JSP 'SelectFaculty.jsp' starting page</title>

			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">
			<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
			<script type="text/javascript">
function disableBackButton() {
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>

		</head>

		<body onload="javascript:disableBackButton()">

			<jsp:include page="Header.jsp"></jsp:include>
			<table align="center" border="1" bgcolor="skyblue">
				<tr>
					<td>
						SubjectName
					</td>
					<td>
						Year
					</td>
					<td>
						Branch
					</td>
					<td>
						PassPercentage
					</td>
				</tr>

			</table>

		</body>
</html>
