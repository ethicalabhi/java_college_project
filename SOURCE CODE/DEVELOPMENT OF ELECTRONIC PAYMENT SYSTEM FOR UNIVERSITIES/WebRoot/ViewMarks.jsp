
<%@page import="com.college.FormBean.CourseFormBean"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
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
  <%
  
  String report="<table align=center border=1 bgcolor= width=90% cellpadding=10>";
  report=report+"<caption>STUDENT MARKS INFORMATION</caption>";
  report=report+"<tr bgcolor=#CCFFFF><i>Student Marks Info</i></tr><br/>";
  report=report+"<tr><th bgcolor=lightgreen><b>StudentRollNo</b></th><th bgcolor=lightgreen><b>Course Title</b></th><th bgcolor=lightgreen><b>Subject Title</b></th><th bgcolor=lightgreen><b>ExamTitle</b></th><th bgcolor=lightgreen><b>ExamAttemptDate</b></th><th bgcolor=lightgreen><b>TotalMarks</b></th><th bgcolor=lightgreen><b>SecuredMarks</b></th></tr>";
  
   %>
    <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>STUDENT MARKS INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Student Marks Info</i></tr>
   <br/>
   <tr><th bgcolor="lightgreen"><b>StudentRollNo</b></th><th bgcolor="lightgreen"><b>Course Title</b></th><th bgcolor="lightgreen"><b>Subject Title</b></th><th bgcolor="lightgreen"><b>ExamTitle</b></th><th bgcolor="lightgreen"><b>ExamAttemptDate</b></th><th bgcolor="lightgreen"><b>TotalMarks</b></th><th bgcolor="lightgreen"><b>SecuredMarks</b></th>
   <th bgcolor="lightgreen"><b>Average</b></th>
    
    </tr>
    
    
       
Export to : <a href="./ExportXLS" target="_blank"><font color="brown">XLS</font></a>
    
   <%
   Vector<CourseFormBean> vcb=(Vector<CourseFormBean>)request.getAttribute("MarksInfo");
   
   System.out.println("In Jsp vector is.................."+vcb);
   
   Iterator it=vcb.listIterator();
   
   while(it.hasNext()){
  
%>
<%
  int uid=(Integer)request.getAttribute("userid");
  CourseFormBean cb=(CourseFormBean)it.next();
   report=report+"<tr><td>"+uid+"</td>";
   report=report+"<td>"+cb.getCname()+"</td>";
   report=report+"<td>"+cb.getSname()+"</td>";
   report=report+"<td>"+cb.getEname()+"</td>";
   report=report+"<td>"+cb.getEdate()+"</td>";
   report=report+"<td>"+cb.getTmarks()+"</td>";
   report=report+"<td>"+cb.getSmarks()+"</td>";
   report=report+"<td>"+cb.getAverages()+"</td></tr>";
  
   %>
   	
   <tr>
  
  <td><%=uid %></td>
  <td><%=cb.getCname() %></td>
  <td><%=cb.getSname() %></td>
  <td><%=cb.getEname() %></td>
  <td><%=cb.getEdate() %></td>
  <td><%=cb.getTmarks() %></td>
  
  <td><%=cb.getSmarks() %></td>
  <td><%=cb.getAverages() %></td>
   </tr>
     
    <%}
  report+="</table>";
  session.setAttribute("Report",report);
   %>
</table>
   				<c:if test="${empty MarksInfo}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
 
   <br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
