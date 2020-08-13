
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
   <caption>QUESTION PAPER INFO</caption>
   <tr bgcolor="#CCFFFF"><i>Notification Info</i></tr>
   <br/>
   <tr><th bgcolor="#2F4F4F"><b>PaperCode</b></th><th bgcolor="#2F4F4F"><b>Course Title</b></th><th bgcolor="#2F4F4F"><b>Subject Name</b></th><th bgcolor="#2F4F4F"><b>Description</b></th><th bgcolor="#2F4F4F"><b>ReleasedDate</b></th><th bgcolor="#2F4F4F"><b>QPaper</b></th>
   
    </tr>
   
   <c:if test="${not empty PaperInfo}">
    
  <c:forEach var="PaperInfo" items="${PaperInfo}">
   <tr>
   
   <td>${PaperInfo.qid }</td>
   <td>${PaperInfo.cname }</td>
   <td>${PaperInfo.sname }</td>  

  <td>${PaperInfo.qdescription }</td>
  <td>${PaperInfo.qdate }</td>
  <td><a href="./GetQpaper.jsp?courseid=${PaperInfo.courseid }&subid=${PaperInfo.subid }">DownloadQPaper</a></td>

 </tr> 
 
 
  
   
  </c:forEach>
   </c:if> 

   				<c:if test="${empty PaperInfo}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
 </table>
 <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
