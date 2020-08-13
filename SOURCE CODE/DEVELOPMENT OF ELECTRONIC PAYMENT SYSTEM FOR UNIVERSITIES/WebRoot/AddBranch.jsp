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
                   
		<form action="<%=request.getContextPath()+"/AddBranchAction"%>" name="branch" onsubmit="return validator();">
	<center>		
    <table border="1" width="485" height="173">
    
    <tr bgcolor="#FFOOCCFFDD"><i> Add Branch Info</i></tr>
    <caption>Branch Information</caption>
    <tr>
    <br/>
     <tr>
    
   
                                <td width="128"><span class="style17"><font color="higblue" id="ctitle"><b>BranchName</b></font> </span>
                                <div id="title"></div>
                                
                                </td>
                                <td width="169"><label>
                              <input type="text" name="branchname">
                                </label></td>
                              </tr>
                              
                             
                          

                              <tr>
                                <td><span class="style17"><font color="higblue"><b>BranchDescription</b></font></span></td>
                                <td>
                                 
                         
                                <textarea cols="20" rows="5"  name="bdescription" ></textarea>
                                     
                                    
                                    
                                </td>
                              </tr>
                              <br/>
                              
<tr>
                             <td align="right">
                             <input type="submit" name="submit" value="Insert Branch Info">
                              </td></tr>
    </table>
    </center>	
    
    
    <br/>
			
                  <jsp:include page="Footer.jsp"></jsp:include>
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("branch");

  frmvalidator.addValidation("branchname","req","SubjectName is required");
    
    
    
    frmvalidator.addValidation("bdescription","req","SubjectDescription is required");

  </script>
  </body>
</html>
