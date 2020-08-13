<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	if (session.getAttribute("loginuser") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
%>
<%
	}
%>
<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
</script>




		<script type="text/javascript">
function validator() {

	document.getElementById("subject").innerHTML = "";
	

}
</script>

		<script type="text/javascript">
function disableBackButton() {
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>

	</head>

	<body onload="javascript:disableBackButton()">

		<jsp:include page="Header.jsp"></jsp:include>

		<!--<form action=<%=request.getContextPath() + "/AddFacultySubjectAction"%>
			name="subject" method="get"  onsubmit="return validator();">

			-->
			
			
			<form action="AddFacultySubjectAction">
			<table border="1" width="785" height="173">

				<tr bgcolor="#FFOOCCFFDD">
					<i> Add Faculty Subjects</i>
				</tr>
				<caption>
					FACULTY SUBJECTS INFORMATION
				</caption><!--

                        <c:if test="${not empty UserDetails}">
                        
                        <c:forEach var="UserDetails" items="${UserDetails}">
                        
                        </c:forEach>
                        </c:if>
                      --><tr>
                  <td width="85"><span><font color="higblue">FacultyID</font></span><br></td>
              <td width="286"><label>
                            <input type="text" name="userid" size="48" value="<%=(String)request.getParameter("facid") %>" readonly="readonly" />
                          </label><br></td>
                        </tr>
                  
				<tr>


					<td width="128">
						<span class="style17"><font color="higblue"><b>Subject</b>
						</font> </span>


					</td>
					<td width="269">
						<label>
							<input type="text" name="subject" id="ctitle">
						</label>
						<div id="title"></div>
					</td>
				</tr>

				<tr>
					<td align="right">
						<input type="submit" name="submit" value="Insert Subject">
					</td>
				</tr>
			</table>


</form>
			<br />

			<jsp:include page="Footer.jsp"></jsp:include>
		
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
