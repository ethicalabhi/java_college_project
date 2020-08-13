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
                   
		<form action="<%=request.getContextPath()+"/UpdateCourseAction"%>" name="ucourse" method="post">
		
    <table border="1" width="785" height="173">
    
    <tr bgcolor="#4682B4"><i> Update Course Info</i></tr>
    <caption>&quot;COURSE INFORMATION</caption>
    <tr>
   
                                <c:if test="${not empty coursevector}">
                                <c:forEach var="coursevector" items="${coursevector}">
    
                                    <tr>
                                    
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>CourseId</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="courseid" readonly="readonly" value="${coursevector.courseid }">
                                </label></td>
                              </tr>
                                    
                                    
                                    <tr>
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>CourseTitle</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="cname" value="${coursevector.cname }" readonly="readonly">
                                </label></td>
                              </tr>
                              
                              <tr>
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>CourseFee</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="fee" value="${coursevector.fee }">
                                </label></td>
                              </tr>
 
                            <tr>
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>CourseDuration</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="duration" value="${coursevector.duration }">
                                </label></td>
                              </tr>

                              <tr>
                                <td><span class="style17"><font color="#6B8E23"><b>CourseDescription</b></font></span></td>
                                <td>
                                 
                         
                                <textarea cols="30" rows="5"  name="cdescription" >${coursevector.cdescription }</textarea>
                                     
                                    
                                    
                                </td>
                              </tr>
                              
                              <tr>
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>Introduced Date</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="cdate" readonly="readonly" value="${coursevector.cdate }">
                                </label></td>
                              </tr>
                              
                              <tr>
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>CourseStatus</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="cstatus" value="${coursevector.cstatus }">
                                </label></td>
                              </tr>
                             
                              
<tr>
                             <td align="right">
                             <input type="submit" name="submit" value="Update Course">
                              </td></tr>
                          </c:forEach>
                          </c:if>    
    </table>
    
    
    
    <br/>
			
                    
    </form>
    
      <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("ucourse");

  frmvalidator.addValidation("courseid","req","courseid is required");
  frmvalidator.addValidation("cname","req","cname is required");
    frmvalidator.addValidation("cname","alpha","CourseName is Only Characters");
    frmvalidator.addValidation("cdescription","req","cdescription is required");
    frmvalidator.addValidation("cdate","req","cdate is required");
    frmvalidator.addValidation("cfee","req","cdate is required");
     frmvalidator.addValidation("cfee","numeric");
    frmvalidator.addValidation("duration","req","cdate is required");

    frmvalidator.addValidation("cstatus","req","cstatus is required");
     frmvalidator.addValidation("cstatus","alpha","cstatus is Only Characters");
    
  </script>
  <br/>
    <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
