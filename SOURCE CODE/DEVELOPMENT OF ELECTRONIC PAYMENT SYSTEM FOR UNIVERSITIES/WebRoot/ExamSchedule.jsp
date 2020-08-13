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
<form action="<%=request.getContextPath()+"/ExamScheduleAction"%>" name=register>


<jsp:include page="Header.jsp"></jsp:include>

    <font color="#4D88DB"><h3 align="center">Exam Schedule</h3></font>
    <table align="center" border="1">
    <tr bgcolor="2BB6D7"><i>Prepare exam TimeTable Here</i></tr>
    <br/><br/>
                              <tr>
                             <td width="128"><span class="style17"><font color="igblue"><b>CourseTitle</b></font> </span></td>
                                <td width="269"><label>
                                
                                
                            <select name="courseid"  id="select" onchange="return getsubject();">
                              
                              <c:choose>
				 <c:when test="${requestScope.cid ne null}">
				   <option value="${requestScope.cid}">${requestScope.cid}</option>
				 </c:when>
                           
                           <c:otherwise> 
                           
                           
                            <option>--Select--</option>
                            
                            
                            <c:if test="${not empty coursevector}">
                                <c:forEach var="coursevector" items="${coursevector}">
                                
                            <option value="${coursevector.courseid }">${coursevector.cname }</option>
                            </c:forEach>
                            </c:if>
                            </c:otherwise>
                            </c:choose>
                            
                            </select>
                            
                                </label></td>
                              </tr>
 
                             <tr>
                             <td width="128"><span class="style17"><font color="igblue"><b>Subject</b></font> </span></td>
                                <td width="269"><label>
                                
                                
                            <select name="subid">
                            <option>--Select--</option>
                            <c:if test="${not empty subjectAt}">
                                <c:forEach var="subjectAt" items="${subjectAt}">
                                
                            <option value="${subjectAt.subid }">${subjectAt.sname }</option>
                            </c:forEach>
                            </c:if>
                            </select>
                            
                                </label></td>
                              </tr>
                              <tr>
                             <td width="128"><span class="style17"><font color="igblue"><b>ExamType</b></font> </span></td>
                                <td width="269"><label>
                                
                                
                            <select name="etype">
                            <option>--Select--</option>
                            <option value="internal">Internal</option>
                            </select>
                            
                                </label></td>
                              </tr>
                               <tr><td><b><font color="igblue">ExamName</td><td><input type="text" name="ename"/></td></tr>
                              <tr><td><b><font color="igblue">TotalMarks</td><td><input type="text" name="tmarks"/></td></tr>
    <tr><td><b><font color="igblue">ExamDate:</td><td><input type="text" name="examdate"/>
      <a href="javascript:show_calendar('document.register.examdate',document.register.examdate.value);"> <img src="<%=request.getContextPath()+"/images/cal.gif"%>" alt="c" width="18" height="18" border="0"/></a>
      </td></tr>
    <tr><td><b><font color="igblue">Day:</td><td><input type="text" name="day"/></td></tr>
    <tr><td><b><font color="igblue">Time:</td><td><input type="text" name="time"/></td></tr>
<tr><td></td><td><input type="submit" value="Insert"/></td></tr></table><br><br>

</form>
<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");

  
    frmvalidator.addValidation("examdate","req","examdate is required");
    frmvalidator.addValidation("time","req","Time is required");
    frmvalidator.addValidation("ename","req","ExamName is required");
  frmvalidator.addValidation("tmarks","req","TotalMarks is required");
    frmvalidator.addValidation("tmarks","numeric");
        frmvalidator.addValidation("day","req","day is required");
         frmvalidator.addValidation("day","alpha","SubjectName is Only Characters");
  </script>
  <br/>
  <jsp:include page="Footer.jsp"></jsp:include>
  
  
  </body>
  </html>



		