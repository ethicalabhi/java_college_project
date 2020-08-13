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
                   
		<form action="<%=request.getContextPath()+"/UpdateBranchAction"%>" name="subject" method="post">
		
    <table border="1" width="785" height="173">
    
    <tr bgcolor="#4682B4"><i> Update Branch Info</i></tr>
    <caption>Branch INFORMATION</caption>
    <tr>
   
                                <c:if test="${not empty branchat}">
                                <c:forEach var="branchat" items="${branchat}">
    
                                    <tr>
                                    
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>SubjectId</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="bid" readonly="readonly" value="${branchat.bid }">
                                </label></td>
                              </tr>
                                    
                                    
                                    <tr>
                                    <td width="128"><span class="style17"><font color="#6B8E23"><b>BranchName</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="branchname" value="${branchat.branchname }" >
                                </label></td>
                              </tr>
                              
                              
 
                              <tr>
                                <td><span class="style17"><font color="#6B8E23"><b>Description</b></font></span></td>
                                <td>
                                 
                         
                                <textarea cols="30" rows="5"  name="bdescription" >${branchat.bdescription }</textarea>
                                     
                                    
                                    
                                </td>
                              </tr>
                              
                             
                             
                             
                              
<tr>
                             <td align="right">
                             <input type="submit" name="submit" value="UpdateBranch">
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
