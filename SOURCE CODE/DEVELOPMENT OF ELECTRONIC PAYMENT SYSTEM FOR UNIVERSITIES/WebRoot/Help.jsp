<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Help.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<jsp:include page="Header.jsp"></jsp:include>
  
  
		<h3><font color="#1274c9"> Here U can get the Help  To use      <font color="seawaterblue" size=""><b><i>Lost Articles and  </i></b></font><font color="paleblbrickred" size=""><b><i> Letters Reconciliation System</i></b></font>  </font>
		</h3>
  
   <br/><br/>
                   <jsp:include page="Footer.jsp"></jsp:include> 
  
  
  </body>
</html>
