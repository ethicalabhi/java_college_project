<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
  
  <body>
   
   <jsp:include page="Header.jsp"></jsp:include>
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
    <caption>All Student  Fees Details</caption>
   <tr><th bgcolor="ashblue"><b>StudentID</b></th ><th bgcolor="ashblue"><b>StudentName</b></th><th bgcolor="ashblue"><b>Course</b></th><th bgcolor="ashblue"><b>Branch</b></th><th bgcolor="ashblue"><b>TotalFee</b></th><th bgcolor="ashblue"><b>PaidFee</b></th><th bgcolor="ashblue"><b>DueFee</b></th><th bgcolor="ashblue"><b>FeesPaidDate</b></th>
    </tr>
<c:if test="${not empty feeInfo}">
      <c:forEach var="feeInfo" items="${feeInfo}">
<tr>
<td>${feeInfo.userid }</td>
<td align="center">${feeInfo.login }</td>
<td>${feeInfo.cname }</td>
<td>${feeInfo.branchname }</td>
<td>${feeInfo.titalfee }</td>
<td>${feeInfo.paidfee }</td>
<td>${feeInfo.duefee }</td>
<td>${feeInfo.paidate }</td>

</tr>
</c:forEach>
</c:if>
</table>
   
   <br/>  <br/>  <br/>
    <jsp:include page="./Footer.jsp"></jsp:include>
   
  </body>
</html>
