
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
  report=report+"<caption>STUDENT FEE INFORMATION</caption>";
  report=report+"<tr bgcolor=#CCFFFF><i>Student Fee Payment Slip </i></tr><br/>";
  report=report+"<tr><th bgcolor=lightgreen><b>StudentRollNo</b></th><th bgcolor=lightgreen><b>Student Name</b></th><th bgcolor=lightgreen><b>Course Name</b></th><th bgcolor=lightgreen><b>Branch Name</b></th><th bgcolor=lightgreen><b>TotalFee</b></th><th bgcolor=lightgreen><b>Paid Fee</b></th><th bgcolor=lightgreen><b>DueFee</b></th><th bgcolor=lightgreen><b>date</b></th></tr>";
  
   %>
    <table align="center" border="1" bgcolor="" width="50%" cellpadding="10">
   <caption>STUDENT Fees Payment Slip</caption>
   <tr bgcolor="#CCFFFF"><i>Fees Payment Slip</i></tr>
   <br/>
   
    
    </tr>
    

Export to : <a href="./ExportXLS" target="_blank"><font color="brown">XLS</font></a>
    
   <%
   Vector<CourseFormBean> vcb=(Vector<CourseFormBean>)request.getAttribute("feeInfo");
   
   System.out.println("In Jsp vector is.................."+vcb);
   
   Iterator it=vcb.listIterator();
   
   while(it.hasNext()){
  
%>
<%
  
  CourseFormBean cb=(CourseFormBean)it.next();
   report=report+"<tr><td>"+cb.getUserid()+"</td>";
    report=report+"<td>"+cb.getCname()+"</td>";
   report=report+"<td>"+cb.getLogin()+"</td>";
   report=report+"<td>"+cb.getBranchname()+"</td>";
   report=report+"<td>"+cb.getTitalfee()+"</td>";
   report=report+"<td>"+cb.getPaidfee()+"</td>";
   report=report+"<td>"+cb.getDuefee()+"</td>";
   report=report+"<td>"+cb.getPaidate()+"</td></tr>";
  
   %>
   	
   <tr>
  
  <td ><b>StudentRollNo</b></td>
  <td><%=cb.getUserid() %></td>
  </tr>
  <tr>
   <td ><b>StudentName</b></td>
  <td><%=cb.getLogin() %></td>
  </tr>
   <tr>
   <td ><b>CourseName</b></td>
  <td><%=cb.getCname() %></td>
  </tr>
 <tr> 
  <td ><b>BranchName</b></td>
  
 <td><%=cb.getBranchname() %></td>
 </tr>
 <tr> 
  <td ><b>Total Fee</b></td>
 <td><%=cb.getTitalfee() %></td>
 </tr>
 <tr> 
  <td ><b>Paid Fee</b></td>
 <td><%=cb.getPaidfee() %></td>
 </tr>
  <tr>
   <td ><b>Due Fee</b></td>
  <td><%=cb.getDuefee() %></td>
  </tr>
 <tr> 
  <td ><b>Date</b></td>
 <td><%=cb.getPaidate() %></td>
 </tr>
     
    <%}
  report+="</table>";
  session.setAttribute("Report",report);
   %>
</table>
   				<c:if test="${empty feeInfo}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
 
   <br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
