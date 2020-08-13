<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Services.jsp' starting page</title>
    
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
		<br/><br/>
		<div  height="100" width="600" style="border:0px solid black;position:relative;left:200px">
		<pre>
<h3>Contact Us:</h3>

    If you have any questions please contact us We have a maximum 3 days reply policy
    NareshIt-Ameerpet
    
    2nd floor (View map)    
    
    Phone: +919999889999    
      
    Email: university@gmail.com
		
		</pre>
		
		
		 </div>		       
	