<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
  <br/><br/>
<form id="form1" name="rollno" method="post" action="./ViewMarksAction">
<fieldset>
         <legend><b><font color="#A3456">Search Marks Here</font></b></legend>
         <TABLE><tr><td>
         
         <table  align="center">
         <tr>
         <td colspan="1" align="right" valign="top"><img src="<%=request.getContextPath()+"/images/s1.jpeg"%>" align="top"  height="150" width="191"/>&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;  <br></td>
        </tr>
        </table>
        </td>
        <td>
            <TABLE bgcolor="#66CC33" align="center">
        <tr>
         <td>
         
 

      <b>EnterRollNo</b>
    <input type="text" name="userid"  />
    <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
    <br /><a href="password.html" target="_parent">
    <input type="submit" name="submit" id="submit" value="Submit" />
    </a><br />
    <br />
 
  </td>
  </tr>
  </table>
  </td>
  </tr>
  </TABLE>
  </fieldset>
</form>
<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("rollno");

  
    
    frmvalidator.addValidation("userid","req","RollNumber is required");
     frmvalidator.addValidation("userid","numeric");

        
  </script>
<br/>
		<br/>
		  <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
