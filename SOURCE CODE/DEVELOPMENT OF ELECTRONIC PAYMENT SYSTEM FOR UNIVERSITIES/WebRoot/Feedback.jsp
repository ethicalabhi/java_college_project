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
  
  <script language="JavaScript" src="<%=request.getContextPath()+"/scripts/gen_validatorv31.js"%>" type="text/javascript"></script>
  
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

		
			<center><h3><i><font color="#C71585">FeedBack Form</font></i></h3></center>
		 
<form action="./AddFeedbackAction" method="post"  name="feedback">
<table width="379" border="2" align="center" bordercolor="#000000">
   <tr>
    <td bgcolor="#FFFFFF" class="style2 style3"><strong>FeedBack</strong></td>
    <td bordercolor="#000000" bgcolor="#FFFFFF"><textarea name="feedback"></textarea></td>
  </tr>
   <tr>
    <td width="85" bgcolor="#FFFFFF"><span class="style2 style3"><strong>StudentName </strong></span></td>
    <td width="284" bordercolor="#000000" bgcolor="#FFFFFF"><input type=text name="cname"  /></td>
  </tr>
 
    
  
  
  <tr>
    <td bgcolor="#FFFFFF"><span class="style2 style3"><strong>Contact</strong></span><br></td>
    <td bordercolor="#000000" bgcolor="#FFFFFF"><input type=text name="mobile"/>
     </td>
  </tr>
 
   <tr>
    <td width="85" bgcolor="#FFFFFF"><span class="style2 style3"><strong>EmailId </strong></span></td>
    <td width="284" bordercolor="#000000" bgcolor="#FFFFFF"><input type=text name="email" maxlength="" />    </td>
  </tr>
 
  
  
    <tr bgcolor="#FFFFFF">
    <td colspan="2"><div align="center" class="style3">
      <input type=submit value="PostFeedBack">&nbsp;
     
    </div></td>
  </tr>
</table>
</form>
<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("feedback");

    frmvalidator.addValidation("feedback","req","Feedback is required");
 
    frmvalidator.addValidation("cname","req","name is required");
   
    frmvalidator.addValidation("email","req","Email is required");
   
     frmvalidator.addValidation("mobile","req","Please enter your MobileNo");
     frmvalidator.addValidation("mobile","numeric");
  </script>

 <br/>
     <jsp:include page="./Footer.jsp"></jsp:include>

  </body>
</html>
