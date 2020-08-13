
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
   <caption>COURSES FEE INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Courses Fee Info</i></tr>
   <br/>
   <tr><th bgcolor="skyblue"><b>Fees Id</b></th><th bgcolor="skyblue"><b>Course Title</b></th><th bgcolor="skyblue"><b>Academic Fee</b></th><th bgcolor="skyblue"><b>Training &Placement Fee</b></th><th bgcolor="skyblue"><b>Laboratory Fee</b></th><th bgcolor="skyblue"><b>Exam Fee</b></th><th bgcolor="skyblue"><b>Transportation Fee</b></th><th bgcolor="skyblue"><b>Hostel Fee</b></th><th bgcolor="skyblue"><b>LastDate</b></th>
   <c:if test="${sessionScope.role=='admin'}"><th bgcolor="skyblue"><b>Action</b></th></c:if> 
    </tr>
   
   <c:if test="${not empty feeinfo}">
    
  <c:forEach var="feeinfo" items="${feeinfo}">
   <tr>
   <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./ViewUpdateFeeAction?fid=${feeinfo.fid }">${feeinfo.fid }</a></td>
   </c:if>
   <c:choose>
   <c:when test="${sessionScope.role!='admin'}">
   <td>${feeinfo.fid }</td>
   </c:when>
   </c:choose>
  <td>${feeinfo.cname }</td>
  <td>${feeinfo.af }</td>
  <td>${feeinfo.pf }</td>
  <td>${feeinfo.lf }</td>
  <td>${feeinfo.ef }</td>
  <td>${feeinfo.tf }</td>
  <td>${feeinfo.hf }</td>
  <td>${feeinfo.ldate }</td>
  <c:if test="${sessionScope.role=='admin'}">
  <td><a href="./CancelFeeAction?fid=${feeinfo.fid }">Cancel</a></td>
  </c:if>

   </tr>  
   
  </c:forEach>
   </c:if> 

   				<c:if test="${empty feeinfo}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
 </table>
 <c:if test="${sessionScope.role=='admin'}">
 <br/>
		<center>
		<a href="./Addfee.jsp">Add New Course Fee</a>
   </center><br/>
    
   </c:if>
   <br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
