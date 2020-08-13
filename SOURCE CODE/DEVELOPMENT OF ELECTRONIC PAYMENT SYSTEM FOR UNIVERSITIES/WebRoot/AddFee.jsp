<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
<html>
  <head>
   <script language="JavaScript" src="<%=request.getContextPath()+"/scripts/gen_validatorv31.js"%>" type="text/javascript"></script>
  <script language="JavaScript" type="text/javascript"
		src="<%=request.getContextPath()+"/scripts/ts_picker.js"%>"></script>

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
                   
		<form action="<%=request.getContextPath()+"/AddFeeAction"%>" name="fee" onsubmit="return validator();">
	<CENTER>	
    <table border="1" width="545" height="173">
     <caption>ADD FEE INFORMATION</caption>
    
    <tr bgcolor="#FFOOCCFFDD"><i> Add Fee Info</i></tr>
   
    <tr>
    <br/>
    
                         <td width="128"><span class="style17"><font color="higblue"><b>CourseTitle</b></font> </span></td>
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
                               <td width="228"><span class="style17"><font color="higblue" id="ctitle"><b>Academic Fee</b></font> </span>
                                <div id="title"></div>
                                
                                </td>
                                <td width="269"><label>
                              <input type="text" name="af">
                                </label></td>
                              </tr>
                              
                             
                              
                              
                               <tr>
                               <td width="258"><span class="style17"><font color="higblue" id="ctitle"><b>Training &Placement Fee</b></font> </span>
                                <div id="title"></div>
                                
                                </td>
                                <td width="269"><label>
                              <input type="text" name="pf">
                                </label></td>
                              </tr>
                              
                            
                              
                               <tr>
                               <td width="228"><span class="style17"><font color="higblue" id="ctitle"><b>Laboratory Fee</b></font> </span>
                                <div id="title"></div>
                                
                                </td>
                                <td width="269"><label>
                              <input type="text" name="lf">
                                </label></td>
                                </tr>
                              
                             
                              
                               <tr>
                               <td width="228"><span class="style17"><font color="higblue" id="ctitle"><b>Exam Fee</b></font> </span>
                                <div id="title"></div>
                                
                                </td>
                                <td width="269"><label>
                              <input type="text" name="ef">
                                </label></td>
                              </tr>
                              
                             
                              
                               <tr>
                               <td width="228"><span class="style17"><font color="higblue" id="ctitle"><b>Transportation Fee</b></font> </span>
                                <div id="title"></div>
                                
                                </td>
                                <td width="269"><label>
                              <input type="text" name="tf">
                                </label></td>
                              </tr>
                              
                             
                              
                              <tr>
                               <td width="228"><span class="style17"><font color="higblue" id="ctitle"><b>Hostel Fee</b></font> </span>
                                <div id="title"></div>
                                
                                </td>
                                <td width="269"><label>
                              <input type="text" name="hf">
                                </label></td>
                              </tr>
                              
                             
                             <tr>
                               <td width="228"><span class="style17"><font color="higblue" id="ctitle"><b>Fee LastDate</b></font> </span>
                                <div id="title"></div>
                                
                                </td>
				<td>
					<input type="text" name="ldate" size="30" readonly="readonly">
				
					<a
						href="javascript:show_calendar('document.fee.ldate', document.fee.ldate.value);">
						<img src="<%=request.getContextPath()+"/images/cal.gif"%>" alt="a" width="18" height="18"
							border="0" />
					</a>
				</td>
			</tr>
                            
                          </TABLE>
                             <TABLE> 
                             
                             <TR><TD></TD></TR>
                             <TR><TD></TD></TR>
                             <TR><TD></TD></TR>
                             <tr>
                             
                            
                             <td align="right">
                             <input type="submit" name="submit" value="Insert Data">
                              </td>
                              
                              </tr>
    </table>
    
    </CENTER>
    
    <br/>
			
                  <jsp:include page="Footer.jsp"></jsp:include>
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("fee");

 

  </script>
  </body>
</html>
