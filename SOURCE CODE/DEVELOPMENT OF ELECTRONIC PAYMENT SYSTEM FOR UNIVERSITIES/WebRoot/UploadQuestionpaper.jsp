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
 
 <script type="text/javascript">
 
 function getsubject(){
 
 var cid=document.getElementById('courseid').value;
 alert(cid);
 
 if(cid=="")
 alert(cid);
 else
 {
 
 window.location.href="./GetSubjectAction?cid="+cid+"&page=./UploadQuestionpaper.jsp";
 
 }
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
                           
                           
                   
		<form action="./UploadQpaperAction" name="qpaper">
		
    <table border="1" width="785" height="173">
    
    <tr bgcolor="#FFOOCCFFDD"><i> Upload Question Paper</i></tr>
    <caption>UPLOAD QUESTION PAPER INFO</caption>
    <tr>
    <br/>
     
                              <tr>
                             <td width="128"><span class="style17"><font color="higblue"><b>CourseTitle</b></font> </span></td>
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
                             <td width="128"><span class="style17"><font color="higblue"><b>Subject</b></font> </span></td>
                                <td width="269"><label>
                                
                                
                            <select name="subjid">
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
                                <td><span class="style17"><font color="higblue"><b>BrowsePaper</b></font></span></td>
                                <td>
                                 
                         
                                <input type="file" name="qpaper"  onChange="preview(this)" />
                                     
                                    
                                    
                                </td>
                              </tr>
                              
                             
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>QuestionPaperDescription</b></font></span></td>
                                <td>
                                 
                         
                                <textarea cols="30" rows="5"  name="qdescription" ></textarea>
                                     
                                    
                                    
                                </td>
                              </tr>
                              
<tr>
                             <td align="right">
                             <input type="submit" name="submit" value="UpLoad">
                              </td></tr>
    </table>
    
    
    

			
                 
    </form>
       <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("qpaper");

  frmvalidator.addValidation("qcode","req","QuestionpaperCode is required");
  
   
  
    frmvalidator.addValidation("qpaper","req","QuestionPaper is required");

  </script>
  <br/>
     <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
