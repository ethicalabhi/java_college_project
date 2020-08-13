
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
   <caption>DEPARTMENT INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Department Info</i></tr>
   <br/>
   <tr><th bgcolor="skyblue"><b>Department Id</b></th><th bgcolor="skyblue"><b>Department</b></th><th bgcolor="skyblue"><b>Description</b></th>
   <c:if test="${sessionScope.role=='admin'}"><th bgcolor="skyblue"><b>Action</b></th></c:if> 
    </tr>
   
   <c:if test="${not empty departinfo}">
    
  <c:forEach var="departinfo" items="${departinfo}">
   <tr>
   <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./ViewUpdateDepartmentAction?did=${departinfo.did }">${departinfo.did }</a></td>
   </c:if>
   <c:choose>
   <c:when test="${sessionScope.role!='admin'}">
   <td>${departinfo.did }</td>
   </c:when>
   </c:choose>
  <td>${departinfo.departmentname }</td>
  <td>${departinfo.ddescription }</td>
  
  <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./CancelDepartmentAction?did=${departinfo.did }">Cancel</a></td>
  </c:if>

   </tr>  
   
  </c:forEach>
   </c:if> 

   				<c:if test="${empty departinfo}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
 </table>
 <c:if test="${sessionScope.role=='admin'}">
 <br/>
		<center>
		<a href="./AddDepartment.jsp">Add New Department</a>
   </center><br/>
   
   </c:if>
   <br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
