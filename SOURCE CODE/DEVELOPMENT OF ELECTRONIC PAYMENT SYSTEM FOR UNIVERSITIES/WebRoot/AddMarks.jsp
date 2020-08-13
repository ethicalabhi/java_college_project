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
 
 function getstudent(){
 
 var userid=document.getElementById('select').value;
 alert(userid);
 
 if(userid==""){
 alert("plz select student");
 }
 else
 {
 
 window.location.href="./GetStudentCourseAction?userid="+cid;
 
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
    
<form action="<%=request.getContextPath()+"/GetStudentCourseAction"%>" name=register>


<jsp:include page="Header.jsp"></jsp:include>

    <font color="#4D88DB"><h3 align="center">Upload Marks Info</h3></font>
    <table align="center" border="1">
    <tr bgcolor="#F08080"><i>Upload Exams Marks Info  Here</i></tr>
    <br/><br/>
                              <tr>
                             <td width="128"><font color="purple"><b>StudentNumber</b></font> </td>
                                <td width="269"><label>
                                
  <b><input type="text"  name="userid"/></b>                              
                            <!--<select name="userid"  id="select" >
                              
                              <c:choose>
				 <c:when test="${requestScope.userid ne null}">
				   <option value="${requestScope.userid}">${requestScope.userid}</option>
				 </c:when>
                           
                           <c:otherwise> 
                           
                           
                            <option>--Select--</option>
                            
                            
                            <c:if test="${not empty StudentInfo}">
                                <c:forEach var="StudentInfo" items="${StudentInfo}">
                                
                            <option value="${StudentInfo.userid }">${StudentInfo.fname }${StudentInfo.lname }</option>
                            </c:forEach>
                            </c:if>
                            </c:otherwise>
                            </c:choose>
                            
                            </select>
                            
                                --></label></td>
                              </tr>
 
                             
    
<tr><td></td><td><input type="submit" value="Get Info"/></td></tr></table><br><br>

</form>
<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");

  
    frmvalidator.addValidation("examdate","req","examdate is required");
    frmvalidator.addValidation("time","req","Time is required");

        frmvalidator.addValidation("day","req","day is required");
         frmvalidator.addValidation("day","alpha","SubjectName is Only Characters");
  </script>
  <br/>
  <jsp:include page="Footer.jsp"></jsp:include>
  
  
  </body>
  </html>



		