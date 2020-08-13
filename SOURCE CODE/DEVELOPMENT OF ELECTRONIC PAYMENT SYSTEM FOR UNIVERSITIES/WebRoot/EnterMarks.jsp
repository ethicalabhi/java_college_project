<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 
 function getsubject(){
 
 var cid=document.getElementById('courseid').value;
 alert(cid);
 
 if(cid=="")
 alert(cid);
 else
 {
 
 window.location.href="./GetSubjectAction?cid="+cid+"&page=./ExamSchedule.jsp";
 
 }
 }
 
 
 </script>

<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/ts_picker.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/general.js"> </script>
    <script language="javascript" src="<%=request.getContextPath()%>/scripts/ts_picker.js"></script>
     
 <script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
 </head>
 
    <body onload="javascript:disableBackButton()">
<form action="<%=request.getContextPath()+"/AddMarksAction"%>" name=register>


<jsp:include page="Header.jsp"></jsp:include>

    <font color="#4D88DB"><h3 align="center">Exam Marks</h3></font>
    <table align="center" border="1">
    <tr bgcolor="#278ujg"><i>Enter Marks Here</i></tr>
    <br/><br/>
                             <tr>
                             <td width="128"><span class="style17"><font color="igblue"><b>StudentRollNo</b></font> </span></td>
                                <td width="269"><label>
                                
                                
                            <input type=text name="userid" value="<%=request.getParameter("userid") %>" readonly="readonly">
                              
                              
                            
                                </label></td>
                              </tr>
                             
                              <tr>
                             <td width="128"><span class="style17"><font color="igblue"><b>CourseTitle</b></font> </span></td>
                                <td width="269"><label>
                                
                                
                            <input type=text name="courseid" value="<%=request.getParameter("courseid") %>" readonly="readonly">
                              
                              
                            
                                </label></td>
                              </tr>
 
                             <tr>
                             <td width="128"><span class="style17"><font color="igblue"><b>Subject</b></font> </span></td>
                             <TD>
                             <input type="text" name="subjid" value="<%=request.getParameter("subid") %>" readonly="readonly">
                             
                             </TD>
                             </tr>
                              <tr>
                             <td width="128"><span class="style17"><font color="igblue"><b>ExamId</b></font> </span></td>
                                <td width="269"><label>
                                
                                <input type="text" name="examid" value="<%=request.getParameter("examid") %>" readonly="readonly">
                            
                            
                                </label></td>
                              </tr>
                               <tr><td><b><font color="igblue">ExamName</td><td><input type="text" name="ename" value="<%=request.getParameter("ename") %>" readonly="readonly"/></td></tr>
                              
                             
    
                              <tr><td><b><font color="igblue">TotalMarks</td><td><input type="text" name="tmarks" value="<%=request.getParameter("tmarks") %>" readonly="readonly"/></td></tr>
    
    <tr><td><b><font color="igblue">MarksSecured</td><td><input type="text" name="smarks"  /></td></tr>
    <tr><td><b><font color="igblue">PassPercentage</td><td><input type="text" name="passpercentages"  /></td></tr>
    <tr><td><b><font color="igblue">Average</td><td><input type="text" name="averages"  /></td></tr>
<tr><td></td><td><input type="submit" value="Insert"/></td></tr></table><br><br>

</form>
<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");

  
    
    frmvalidator.addValidation("smarks","req","Securedmarks is required");
     frmvalidator.addValidation("smarks","numeric");
      frmvalidator.addValidation("passpercentages","req","passpercentages is required");
     frmvalidator.addValidation("passpercentages","numeric");
      frmvalidator.addValidation("averages","req","averages is required");
     frmvalidator.addValidation("averages","numeric");

        
  </script>
  <br/>
  <jsp:include page="Footer.jsp"></jsp:include>
  
  
  </body>
  </html>



		