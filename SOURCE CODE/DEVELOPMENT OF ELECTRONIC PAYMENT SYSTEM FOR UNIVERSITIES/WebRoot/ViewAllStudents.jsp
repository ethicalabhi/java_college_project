
<%@ page import="java.util.*" %>
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
                   
		
<center><h3><font color="teal"><b><i>View All Students Details</b></font></h3></center>
   
  
      
      <input type="hidden" name="type" value="projcode"/>
      <input type="hidden" name="value" value="<%=request.getParameter("projcode")%>"/>
    <table width="" border="0" align="center" bordercolor="#F4F5F7">
    
      <tr bgcolor="#asHblue">
       
       
       
       
	   
        
        <td width="110"><div align="center" class="style8"><b>Designation</b></div></td>
         <td width="110"><div align="center" class="style8"><b>StudentIdNo</b></div></td>
         <td width="110"><div align="center" class="style8"><b>CourseName</b></div></td>
        <td width="110"><div align="center" class="style8"><b>FirstName</b></div></td>
        <td width="87"><div align="center" class="style8"><b>LastName</b></div></td>
        
        <td width="64"><div align="center" class="style8"><b>Dob</b></div></td>
      <td width="110"><div align="center" class="style8"><b>Email</b></div></td>
          
        <td width="64"><div align="center" class="style8"><b>StudentPicture</b></div></td>
         <td width="64"><div align="center" class="style8"><b>MobileNumber</b></div></td>
          <td width="64"><div align="center" class="style8"><b>City</b></div></td>
           <td width="64"><div align="center" class="style8"><b>State</b></div></td>
            <td width="64"><div align="center" class="style8"><b>Country</b></div></td>
        
      </tr>
      
      <c:if test="${not empty StudentInfo}">
      <c:forEach var="StudentInfo" items="${StudentInfo}">
         
      <tr bgcolor="#CEC9FA" >
    
        
        <td bgcolor="#F4F5F7" ><div align="center" class="style7"> ${StudentInfo.logintype }</div></td>
        <td bgcolor="#F4F5F7" ><div align="center" class="style7"> ${StudentInfo.userid }</div></td>
        
        <td bgcolor="#F4F5F7" ><div align="center" class="style7"> ${StudentInfo.cname }</div></td>  
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${StudentInfo.fname }</div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${StudentInfo.lname }</span></div></td>
      
        <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${StudentInfo.dob }</div></td> 
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${StudentInfo.email }</div></td>
       
        <td bgcolor="#F4F5F7"> <p><img alt="See Photo Here" id="previewField" src="userimages/${StudentInfo.photo }" height="50" width="100"></p></td>
         <td bgcolor="#F4F5F7"><div align="center" class="style7">${StudentInfo.mobile }</div></td>
          <td bgcolor="#F4F5F7"><div align="center" class="style7">${StudentInfo.city }</div></td>
           <td bgcolor="#F4F5F7"><div align="center" class="style7">${StudentInfo.state }</div></td>
            <td bgcolor="#F4F5F7"><div align="center" class="style7">${StudentInfo.country }</div></td>
     </tr>
      </c:forEach>
      </c:if>
      
      <c:if test="${ empty StudentInfo}">
     
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
    
         </c:if>
 </table>
 
 
 
 <br/><br/> <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
