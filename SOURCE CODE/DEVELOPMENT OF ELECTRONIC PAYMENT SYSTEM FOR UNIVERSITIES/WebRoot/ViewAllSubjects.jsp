
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
   <caption>SUBJECT INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Subject Info</i></tr>
   <br/>
   <tr><th bgcolor="skyblue"><b>Subject Id</b></th><th bgcolor="skyblue"><b>SubjectName</b></th><th bgcolor="skyblue"><b>CourseName</b></th><th bgcolor="skyblue"><b>Date</b></th>
   <c:if test="${sessionScope.role=='admin'}"><th bgcolor="skyblue"><b>Action</b></th></c:if> 
    </tr>
   
   <c:if test="${not empty subjectvector}">
    
  <c:forEach var="subjectvector" items="${subjectvector}">
   <tr>
   <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./ViewUpdateSubjectAction?subid=${subjectvector.subid }">${subjectvector.subid }</a></td>
   </c:if>
   <c:choose>
   <c:when test="${sessionScope.role!='admin'}">
   <td>${subjectvector.subid }</td>
   </c:when>
   </c:choose>
  <td>${subjectvector.sname }</td>
  <td>${subjectvector.cname }</td>

  <td>${subjectvector.sdate }</td>
 
  <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./CancelSubjectAction?subid=${subjectvector.subid }">Cancel</a></td>
  </c:if>

   </tr>  
   
  </c:forEach>
   </c:if> 

   				<c:if test="${empty subjectvector}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
 </table>
 <c:if test="${sessionScope.role=='admin'}">
 <br/>
		<center>
		<a href="./ViewCoursesAction?page=/AddSubject.jsp">Add New Subject</a>
   </center><br/> 
    
   </c:if>
   <br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
