
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
   <caption>Branch INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Branch Info</i></tr>
   <br/>
   <tr><th bgcolor="skyblue"><b>Branch Id</b></th><th bgcolor="skyblue"><b>Branch</b></th><th bgcolor="skyblue"><b>Description</b></th>
   <c:if test="${sessionScope.role=='admin'}"><th bgcolor="skyblue"><b>Action</b></th></c:if> 
    </tr>
   
   <c:if test="${not empty branchinfo}">
    
  <c:forEach var="branchinfo" items="${branchinfo}">
   <tr>
   <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./ViewUpdateBranchAction?bid=${branchinfo.bid }">${branchinfo.bid }</a></td>
   </c:if>
   <c:choose>
   <c:when test="${sessionScope.role!='admin'}">
   <td>${branchinfo.bid }</td>
   </c:when>
   </c:choose>
  <td>${branchinfo.branchname }</td>
  <td>${branchinfo.bdescription }</td>
  
  <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./CancelBranchAction?bid=${branchinfo.bid }">Cancel</a></td>
  </c:if>

   </tr>  
   
  </c:forEach>
   </c:if> 

   				<c:if test="${empty branchinfo}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
 </table>
 <c:if test="${sessionScope.role=='admin'}">
 <br/>
		<center>
		<a href="./AddBranch.jsp">Add New Branch</a>
   </center><br/>
    
   </c:if>
   <br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
