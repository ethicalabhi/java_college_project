<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
  
  <body>
   
   <jsp:include page="Header.jsp"></jsp:include>
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
    <caption>U R Account Details</caption>
   <tr><th bgcolor="ashblue"><b>A/C Holder Name</b></th ><th bgcolor="ashblue"><b>Account Number</b></th><th bgcolor="ashblue"><b>A/C Type</b></th><th bgcolor="ashblue"><b>Account Balance</b></th><th bgcolor="ashblue"><b>U R Photo</b></th>
    </tr>
<c:if test="${not empty AccInfo}">
      <c:forEach var="AccInfo" items="${AccInfo}">
<tr>
<td>${AccInfo.fname }${AccInfo.lname }</td>
<td>${AccInfo.acctno }</td>
<td>${AccInfo.acctype }</td>
<td>${AccInfo.accbal }</td>
<td bgcolor="#F4F5F7"> <p><img alt="See Photo Here" id="previewField" src="${AccInfo.photo}" height="100" width="100"></p></td>


</tr>
</c:forEach>
</c:if>
</table>
   
   <br/>  <br/>  <br/>
    <jsp:include page="./Footer.jsp"></jsp:include>
   
  </body>
</html>
