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
    <br/>
    
    <center>
    <table>
    
    <c:if test="${sessionScope.role!='null'}">
		
   				<c:choose>
   				<c:when test="${sessionScope.role=='admin'}">
             
             <h2><font color="watblue">Welcome To Admin Home</font></h2>
              <table bgcolor="#FFFFE0" align="center">
   <tr>
   <td colspan="1" align="right" valign="top"><img src="<%=request.getContextPath()+"/images/a2.gif"%>" align="top" /></td>
   
   <td>
  <label >
  <fieldset>
         <legend><b><font color="purple">This Is Administrator</font></b></legend>
  Mission Statement<br />
  The purpose of <i><b> College Fee Management System</b></i> We have an extensive Education Network.I am Administrator of  Our college . Here we r going to maintain All information of Our College  like Student Fees Information.......etc
  
Through this Web Site.

  <p>We look forward to serving you! </p>
  <div align="center"><span class="style2"><br />
  </span></div>
  </fieldset>
  
  </label>
  </td>
  </tr>
  </table>
   				
   				</c:when>
   		        
   				
   				<c:when test="${sessionScope.role=='manager'}">
   				 <h2><font color="watblue">Welcome To College Staff Home</font></h2>
   				 <table bgcolor="#FFF5EE" align="center">
   <tr>
   <td colspan="1" align="right" valign="top"><img src="<%=request.getContextPath()+"/images/m.jpeg"%>" align="top" height="100" width="100"/></td>
   
   <td>
  <label >
  <fieldset>
         <legend><b><font color="purple">This Is Examination Branch</font></b></legend>
  Mission Statement<br />
  The purpose of <i><b> College Fees Management System</b></i> We have an extensive Education Network.
Through this Web Site.

  <p>We look forward to serving you! </p>
  <div align="center"><span class="style2"><br />
  </span></div>
  </fieldset>
  
  </label>
  </td>
  </tr>
  </table>
   				</c:when>
   				
			    			
				
   				<c:when test="${sessionScope.role=='student'}">
   				<h2><font color="watblue">Welcome To Student Home</font></h2>
   				 <table bgcolor="ashblue" align="center">
   <tr>
   <td colspan="1" align="right" valign="top"><img src="<%=request.getContextPath()+"/images/c1jpg.jpg"%>" align="top" /></td>
   
   <td>
  <label >
  <fieldset>
         <legend><b><font color="hblue">This Is Student World</font></b></legend>
  Mission Statement<br />
  
  <p>We look forward to serving you! </p>
  <div align="center"><span class="style2"><br />
  </span></div>
  </fieldset>
  
  </label>
  </td>
  </tr>
  </table>
   				</c:when>
   
					</c:choose>
					</c:if>
		</table>
    
    
    
    </center>
    
		<br/>
		
		<jsp:include page="Footer.jsp"></jsp:include>
		</body>
		</html>
		