<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  
  <body>
   <table align="center"  style="border:0px solid black;border-color:#FF9000;" >
			<tr>
				<td colspan="1" width="900" height="150" valign="top"><img src="<%=request.getContextPath()+"/images/header77.PNG" %>" align="top" height="180" width="1200" style="-moz-border-radius-topleft: 5px; -moz-border-radius-topright: 5px; -moz-border-radius-bottomright: 5px; -moz-border-radius-bottomleft: 5px;"/></td>
			</tr>
			<tr>
				<td align="center"><marquee  behavior="alternate" scrollamount="2"><font color="seaw" size="5"><b><i>Application for </i></b></font>  <font color="#blue" size="5"> <b><i>Electronic Payment   </i></b></font><font color="#003366" size="5"><b><i>System in Universities  </i></b></font></marquee></td>
			</tr>
			
		<tr>
		 
		  <td>
		 <c:if test="${sessionScope.role!='null'}">
		
   				<c:choose>
   				<c:when test="${sessionScope.role=='admin'}">
   				<jsp:include page="./adminmenu.jsp"/>
   				</c:when>
   		        
   				
   				<c:when test="${sessionScope.role=='manager'}">
   				<jsp:include page="./ManagerMenu.jsp"/>
   				</c:when>
   				
			 <c:when test="${sessionScope.role=='faculty'}">
   				<jsp:include page="./FacultyMenu.jsp"/>
   				</c:when>
   				
   				
   				<c:when test="${sessionScope.role=='student'}">
   				<jsp:include page="./StudentMenu.jsp"/>
   				</c:when>
   
								<c:otherwise>
						<jsp:include page="./menubeforelogin.jsp"/>
					</c:otherwise>
					</c:choose>
					</c:if>
		
		  <center>
   <font color="red"><b>
		 <c:if test="${requestScope.status!='null'}">
					 
                          <c:out value="${requestScope.status}"></c:out> 
                          </c:if>
                          </b>
                          </font>
                         
                           </center>
                            <center>
   <font color="red"><b>
		 <c:if test="${requestScope.status!='null'}">
					 
                          <c:out value="${requestScope.status1}"></c:out> 
                          </c:if>
                          </b>
                          </font>
                         
                           </center>
                           </td>
                           </tr>
                           </table>
  </body>
</html>
