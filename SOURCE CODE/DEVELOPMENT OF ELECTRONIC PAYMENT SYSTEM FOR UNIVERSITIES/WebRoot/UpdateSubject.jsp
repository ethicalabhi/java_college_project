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
                   
		<form action="<%=request.getContextPath()+"/UpdateSubjectAction"%>" name="subject" method="post">
		
    <table border="1" width="785" height="173">
    
    <tr bgcolor="#4682B4"><i> Update Subject Info</i></tr>
    <caption>SUBJECT INFORMATION</caption>
    <tr>
   
                                <c:if test="${not empty subjectInfo}">
                                <c:forEach var="subjectInfo" items="${subjectInfo}">
    
                                    <tr>
                                    
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>SubjectId</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="subid" readonly="readonly" value="${subjectInfo.subid }">
                                </label></td>
                              </tr>
                                    
                                    
                                    <tr>
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>SubjectName</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="sname" value="${subjectInfo.sname }" >
                                </label></td>
                              </tr>
                              
                              <tr>
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>CourseName</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="cname" value="${subjectInfo.cname }" readonly="readonly">
                                </label></td>
                              </tr>
 
                              <tr>
                                <td><span class="style17"><font color="#6B8E23"><b>SubjectDescription</b></font></span></td>
                                <td>
                                 
                         
                                <textarea cols="30" rows="5"  name="sdescription" >${subjectInfo.sdescription }</textarea>
                                     
                                    
                                    
                                </td>
                              </tr>
                              
                              <tr>
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>Introduced Date</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="sdate" readonly="readonly" value="${subjectInfo.sdate }">
                                </label></td>
                              </tr>
                              
                             
                             
                              
<tr>
                             <td align="right">
                             <input type="submit" name="submit" value="UpdateSubject">
                              </td></tr>
                          </c:forEach>
                          </c:if>    
    </table>
    
    
    
    <br/>
			
                    
    </form>
    
      <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("subject");

  frmvalidator.addValidation("courseid","req","courseid is required");
  frmvalidator.addValidation("cname","req","CourseName is required");
    frmvalidator.addValidation("cname","alpha","CourseName is Only Characters");
    frmvalidator.addValidation("sname","req","SubjectName is required");
    frmvalidator.addValidation("sname","alpha","SubjectName is Only Characters");
    frmvalidator.addValidation("sdescription","req","Subjectdescription is required");
    frmvalidator.addValidation("sdate","req","Subjectdate is required");
  
  </script>
  <br/>
    <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
