
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
<html>
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
   	
<jsp:include page="Header.jsp"></jsp:include>

    <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>COURSES INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Courses Info</i></tr>
   <br/>
   <tr><th bgcolor="skyblue"><b>Course Id</b></th><th bgcolor="skyblue"><b>Course Title</b></th><th bgcolor="skyblue"><b>CourseFee</b></th><th bgcolor="skyblue"><b>Duration</b></th><th bgcolor="skyblue"><b>Introduced Date</b></th><th bgcolor="skyblue"><b>Course Status</b></th>
   <c:if test="${sessionScope.role=='admin'}"><th bgcolor="skyblue"><b>Action</b></th></c:if> 
    </tr>
   
   <c:if test="${not empty coursevector}">
    
  <c:forEach var="coursevector" items="${coursevector}">
   <tr>
   <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./ViewUpdateCourseAction?courseid=${coursevector.courseid }">${coursevector.courseid }</a></td>
   </c:if>
   <c:choose>
   <c:when test="${sessionScope.role!='admin'}">
   <td>${coursevector.courseid }</td>
   </c:when>
   </c:choose>
  <td>${coursevector.cname }</td>
  <td>${coursevector.fee }</td>
  <td>${coursevector.duration }</td>
  <td>${coursevector.cdate }</td>
  <td>${coursevector.cstatus }</td>
  <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./CancelCourseAction?courseid=${coursevector.courseid }">Cancel</a></td>
  </c:if>

   </tr>  
   
  </c:forEach>
   </c:if> 

   				<c:if test="${empty coursevector}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
 </table>
 <c:if test="${sessionScope.role=='admin'}">
 <br/>
		<center>
		<a href="./AddCourse.jsp">Add New Course</a>
   </center><br/>
     Note:Click on Courseid To Update
   </c:if>
   <br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
