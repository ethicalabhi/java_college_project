
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
		<script type="text/javascript">
function disableBackButton() {
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
	</head>

	<body onload="javascript:disableBackButton()">
		<jsp:include page="Header.jsp"></jsp:include>
		<%
  
  String report="<table align=center border=1 bgcolor= width=90% cellpadding=10>";
  report=report+"<caption>FACULTY HANDLING SUBJECTS</caption>";
  report=report+"<tr bgcolor=#CCFFFF><i></i></tr><br/>";
  report=report+"<tr><th bgcolor=lightgreen><b>SubjectName</b></th><th bgcolor=lightgreen><b>Year</b></th><th bgcolor=lightgreen><b>Branch</b></th><th bgcolor=lightgreen><b>PassPercentage</b></th></tr>";
  
  if((String)request.getAttribute("status123")!=null){
  %><%=request.getAttribute("status123")%>
		<% }%>


		<table align="center" border="1" bgcolor="" width="90%"
			cellpadding="10">
			<caption></caption>
			<tr bgcolor="#CCFFFF">
				<i></i>
			</tr>
			<br />
			<tr>
				<th bgcolor="lightgreen">
					<b>FacultyID</b>
				</th>
				<th bgcolor="lightgreen">
					<b>FacultyName</b>
				</th>
				<th bgcolor="lightgreen">
					<b>SubjectName</b>
				</th>

			</tr>


			Export to :
			<a href="./ExportXLS" target="_blank"><font color="brown">XLS</font>
			</a>

			<%
   Vector<CourseFormBean> vcb=(Vector<CourseFormBean>)request.getAttribute("SubjectsInfo");
   
   System.out.println("In Jsp vector is.................."+vcb);
   
   Iterator it=vcb.listIterator();
   
   while(it.hasNext()){
  
%>
			<%
  int uid=(Integer)request.getAttribute("userid");
  CourseFormBean cb=(CourseFormBean)it.next();
   report=report+"<tr><td>"+uid+"</td>";
   report=report+"<td>"+cb.getSubject()+"</td>";
   report=report+"<td>"+cb.getCdate()+"</td>";
   report=report+"<td>"+cb.getCname()+"</td>";
   report=report+"<td>"+cb.getPasspercentages()+"</td>";
   
  
   %>

			<tr>

				<td><%=uid %></td>


				<td><%=cb.getFname() %></td>
				<td><%=cb.getSubject() %></td>


			</tr>

			<%}
  report+="</table>";
  session.setAttribute("Report",report);
   %>
		</table>
		<c:if test="${empty MarksInfo}">
			<tr>
				<!--  	<td colspan="5"> No Record Found</td>-->
			</tr>
		</c:if>


		<br />
		<jsp:include page="Footer.jsp"></jsp:include>


	</body>
</html>
