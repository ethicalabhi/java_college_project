<%@page import="java.sql.*,java.io.*" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
 
<head>
  
  <script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
 </head>
 
    <body onload="javascript:disableBackButton()">


 	
<br><jsp:include page="Header.jsp"></jsp:include>

   <center> <h2><font color="teal">Examination Time Table</font></h2></center>
<table align="center" border="1" height="100" width="500">
<tr>
<th><b><font color="peal" size="4">ExamTitle</font></b></th>
<th><b><font color="peal" size="4">Course</font></b></th>
<th><b><font color="peal" size="4">Subject</font></b></th>
<th><b><font color="peal" size="4">TotalMarks</font></b></th>
<th><b><font color="peal" size="4">ExamDate</font></b></th>
<th><b><font color="peal" size="4">Day</font></b></th>
<th><b><font color="peal" size="4">Time</font></b></th>
</tr>


<c:if test="${not empty ExamSchedule}">
<c:forEach var="ExamSchedule" items="${ExamSchedule}">
    
    <tr>
     <td><font color="">${ExamSchedule.ename }</font></td>
    <td><font color="">${ExamSchedule.cname }</font></td>
    <td><font color="">${ExamSchedule.sname }</font></td>
    <td><font color="">${ExamSchedule.tmarks }</font></td>
    <td><font color="">${ExamSchedule.examdate }</font></td>
    <td><font color="">${ExamSchedule.day }</font></td>
    <td><font color="">${ExamSchedule.time }</font></td>
    </tr>
    </c:forEach>
    </c:if>
  
</table>
<br/>
   <jsp:include page="Footer.jsp"></jsp:include>
   </body>
   
