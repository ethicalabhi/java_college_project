
<%@ page import="java.util.*" %>
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
	  	
<jsp:include page="Header.jsp"></jsp:include>
                   
		
<center><h3><font color="teal"><b><i>View All Faculties Details</b></font></h3></center>
   
  
      
      <input type="hidden" name="type" value="projcode"/>
      <input type="hidden" name="value" value="<%=request.getParameter("projcode")%>"/>
    <table width="" border="0" align="center" bordercolor="#F4F5F7">
    
      <tr bgcolor="#asHblue">
       
       
       
       
	   
        
        <td width="110"><div align="center" class="style8"><b>Designation</b></div></td>
        <td width="110"><div align="center" class="style8"><b>FirstName</b></div></td>
        <td width="87"><div align="center" class="style8"><b>LastName</b></div></td>
        
        <td width="64"><div align="center" class="style8"><b>Dob</b></div></td>
      <td width="110"><div align="center" class="style8"><b>Email</b></div></td>
          
        <td width="64"><div align="center" class="style8"><b>FacultyPicture</b></div></td>
        <td width="110"><div align="center" class="style8"><b>Subjects</b></div></td>
      </tr>
      
      <c:if test="${not empty FacultInfo}">
      <c:forEach var="EmpInfo" items="${FacultInfo}">
         
      <tr bgcolor="#CEC9FA" >
    
        
        <td bgcolor="#F4F5F7" ><div align="center" class="style7"> ${EmpInfo.logintype }</div></td> 
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${EmpInfo.fname }</div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${EmpInfo.lname }</span></div></td>
      
        <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${EmpInfo.dob }</div></td> 
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${EmpInfo.email }</div></td>
       
        <td bgcolor="#F4F5F7"> <p><img alt="See Photo Here" id="previewField" src="userimages/${EmpInfo.photo }" height="50" width="100"></p></td>
        <td bgcolor="#F4F5F7"><a href="AddFacultySubjects.jsp?facid=${EmpInfo.userid}">AssignSubjects</a> </td>
     </tr>
      </c:forEach>
      </c:if>
      
      <c:if test="${ empty FacultInfo}">
     
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
    
         </c:if>
 </table>
 
 
 
 <br/><br/> <jsp:include page="Footer.jsp"></jsp:include>
</body>