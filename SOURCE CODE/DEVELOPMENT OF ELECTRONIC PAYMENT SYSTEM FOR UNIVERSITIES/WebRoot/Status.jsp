<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
	<base href="<%=basePath%>">

</head>

<body >

	<jsp:include page="Header.jsp"></jsp:include>
	
		
		<br>
		<br>
		<br>

	
	<p>
		<font face="Arial" color="#323211" size="2"> </font>
	</p>
</body>

