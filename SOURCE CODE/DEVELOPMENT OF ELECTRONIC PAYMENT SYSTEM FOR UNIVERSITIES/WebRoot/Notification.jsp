<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
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
                   
		<form action="./NotificationAction" name="announce">
		

		
    <table border="1" width="785" height="173">
    
    <tr bgcolor="#98FB98"><i> Course Announcement Info</i></tr>
    <caption><font color="hblue">Course specific Announcments</caption>
    <tr>
    <br/>
     <tr>
    
   
                                <td width="128"><span class="style17"><font color="#4169E1"><b>CourseTitle</b></font> </span></td>
                                <td width="269"><label>
                                
                                
                            <select name="courseid">
                            <option>--Select--</option>
                            <c:if test="${not empty coursevector}">
                                <c:forEach var="coursevector" items="${coursevector}">
                                
                            <option value="${coursevector.courseid }">${coursevector.cname }</option>
                            </c:forEach>
                            </c:if>
                            </select>
                            
                                </label></td>
                              </tr>
                              
                             
 
 

                              <tr>
                                <td><span class="style17"><font color="#4169E1"><b>NotificationDescription</b></font></span></td>
                                <td>
                                 
                         
                                <textarea cols="30" rows="5"  name="description" ></textarea>
                                     
                                    
                                    
                                </td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="#4169E1"><b>BrowseNotification</b></font></span></td>
                                <td>
                                 
                         
                                <input type="file" name="notification"  onChange="preview(this)" />
                                     
                                    
                                    
                                </td>
                              </tr>
                              <br/>
                              
<tr>
                             <td align="right">
                             <input type="submit" name="submit" value="PostAnnouncement">
                              </td></tr>
    </table>
    
    <br/><br/>
    

			
                   <jsp:include page="Footer.jsp"></jsp:include>
    </form>
     <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("announce");


    frmvalidator.addValidation("description","req","Announcement is required");
  
  </script>
    
  </body>
</html>
