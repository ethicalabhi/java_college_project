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
 

 
 
 <script type="text/javascript">
	function validator(){

	document.getElementById("title").innerHTML="";
	document.getElementById("dfee").innerHTML="";
	document.getElementById("durations").innerHTML="";
	document.getElementById("ddescription").innerHTML="";
	
	if(document.getElementById("ctitle").value==""){
        
document.getElementById("title").innerHTML="Plz Enter CourseName";
return false;
	}
	else if(document.getElementById("cfee").value==""){
        
document.getElementById("dfee").innerHTML="Plz Enter Fee";

return false;
	}
	else if(document.getElementById("cduration").value==""){
        
document.getElementById("durations").innerHTML="Plz Enter Description";

return false;
	}
	else if(document.getElementById("description").value==""){
        
document.getElementById("ddescription").innerHTML="Plz Enter Description";

return false;
	}

	}
	
	function numer(){
	document.getElementById("dfee").innerHTML="";
	
	
	
	
	}
	
	</script>	
	
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
                   
		<form action=<%=request.getContextPath()+"/AddCourseAction"%> name="course">
		<center>	
    <table border="1" width="485" height="173">
    
    <tr bgcolor="#FFOOCCFFDD"><i> Add Course Info</i></tr>
    <caption>COURSE INTRODUCTION</caption>
    <tr>
    <br/>
     <tr>
    
   
                                <td width="128"><span class="style17"><font color="higblue" ><b>CourseTitle</b></font> </span>
                                
                                
                                </td>
                                <td width="269"><label>
                              <input type="text" name="cname" id="ctitle">
                                </label>
                                <div id="title"></div>
                                </td>
                              </tr>
                              
                             
  <tr>
    
   
                                <td width="128"><span class="style17"><font color="higblue" ><b>CourseFee</b></font> </span>
                                
                                </td>
                               
                                <td width="269"><label>
                              <input type="text" name="fee" id="cfee">
                                </label>
                                <div id="dfee"></div>
                                </td>
                              </tr>
                              
                               <tr>
    
   
                                <td width="128"><span class="style17"><font color="higblue" ><b>CourseDuration</b></font> </span>
                                
                                </td>
                                <td width="269"><label>
                                <input type="text" name="duration" id="cduration" >
                                </label>
                                <div id="durations"></div>
                                </td>
                              </tr>
                              
 

                              <tr>
                                <td><span class="style17"><font color="higblue"><b>CourseDescription</b></font></span></td>
                                <td>
                                 
                         
                                <textarea cols="20" rows="5"  name="cdescription" id="description"></textarea>
                                     
                                    <div id="ddescription"></div>
                                    
                                </td>
                              </tr>
                              
                              <br/>
                              
<tr>
                             <td align="right">
                             <input type="submit" name="submit" value="Insert Course">
                              </td></tr>
    </table>
    </center>	
    
    <br/>
			
                  <jsp:include page="Footer.jsp"></jsp:include>
    </form>
<%--    <script language="JavaScript" type="text/javascript">--%>
<%--//You should create the validator only after the definition of the HTML form--%>
<%--  var frmvalidator  = new Validator("course");--%>
<%----%>
<%--  frmvalidator.addValidation("cname","req","CourseName is required");--%>
<%--    frmvalidator.addValidation("cname","alpha","CourseName is Only Characters");--%>
<%--    frmvalidator.addValidation("fee","req","CourseFee is required");--%>
<%--    frmvalidator.addValidation("fee","numeric");--%>
<%--    frmvalidator.addValidation("duration","req","CourseDuration is required");--%>
<%--    --%>
<%--    frmvalidator.addValidation("cdescription","req","cdescription is required");--%>
<%----%>
<%--  </script>--%>
    
  </body>
</html>
