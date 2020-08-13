<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.college.DaoImpl.CourseDaoImpl"%>
<%@ page import="com.college.FormBean.CourseFormBean"%>

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
  <jsp:include page="Header.jsp"></jsp:include><br/>
  
  
   <table align="center">
			<tr><td><b>Download u r Paper Here</b></td></tr><tr>
				<td colspan="1" width="" height="" valign="top"><img src="<%=request.getContextPath()+"/images/do.jpeg"%>" align="top" height="75" width="150"/></td>
			</tr>
			</table>
  <%  
     String path=request.getRealPath("/notifications"); 
      System.out.println(path+"@@@@@@@@@@@@@@@&quot"); 
     String courseid=request.getParameter("courseid");
     System.out.println("courseid==============>"+courseid);
     
     int sid=Integer.parseInt(request.getParameter("subid"));
     
 int cid=Integer.parseInt(courseid);
 
     CourseDaoImpl profiledao=new CourseDaoImpl();
    Vector<CourseFormBean> vcb=profiledao.viewQpaper(path,cid,sid); 
int cnt=0; 
for(CourseFormBean doc:vcb) 
{ 
    cnt++; 
   String doc1= doc.getQpaper(); 
   int id= doc.getQid(); 
   System.out.println(doc1+"##############"+id); 
%>
<%
//response.setContentType("application/doc");
//response.setHeader("Content-disposition","attachment; filename="+cnt+doc1);
 %>
  
                 
 
<a href='<%=path+'/'+id+doc1%>'>Open Document</a>
 
<%

out.println("<br>");

}
 %>
 <br/>
 <br/>
  <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
