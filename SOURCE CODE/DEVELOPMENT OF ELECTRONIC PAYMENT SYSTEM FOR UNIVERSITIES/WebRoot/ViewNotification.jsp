
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
   <caption>NOTIFICATION INFO</caption>
   <tr bgcolor="#CCFFFF"><i>Notification Info</i></tr>
   <br/>
   <tr><th bgcolor="#8FBC8F"><b>Course Title</b></th><th bgcolor="#8FBC8F"><b>Announcement</b></th><th bgcolor="#8FBC8F"><b>ReleasedDate</b></th><th bgcolor="#8FBC8F"><b>DownLoadNotifications</b></th>
   
    </tr>
   
   
   <c:if test="${not empty Notification}">
    
  <c:forEach var="Notification" items="${Notification}">
   <tr>
   
   
   <td>${Notification.ctitle }</td>
  

  <td>${Notification.description }</td>
  <td>${Notification.adate }</td>
  
 <td><a href="notifications/${Notification.notification}">DownloadNotification</a></td>
 
 
  <td></td>

 </tr> 
 
 
  
   
  </c:forEach>
   </c:if> 

   				<c:if test="${empty Notification}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
 </table>
 <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
