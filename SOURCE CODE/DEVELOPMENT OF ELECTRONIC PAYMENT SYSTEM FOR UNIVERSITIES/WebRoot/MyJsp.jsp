<style media="all" type="text/css">
  @import "<%=request.getContextPath()%>/menu2/menu_style.css";
</style>
 <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery.js">
       </script>
       <script type="text/javascript">
		$(document).ready(function () {
		$('.menu li').hover(
		function () {
		//show its submenu
		$('ul', this).slideDown(350);
		},
		function () {
		//hide its submenu
		$('ul', this).slideUp(350);
		}
		);
		});
    </script>
<div>
<ul class="menu">
<li class="top"><a href="Home.jsp" target="_self" class="top_link"><span>Home</span></a>
</li>
<li class="top"><a href="#" target="_self" class="top_link"><span>CourseInfo</span></a>
<ul class="sub">
<li><a href="course.jsp" target="_self">AddCourse</a></li>
<li><a href="view.jsp" target="_self">Viewcourses</a></li>
</ul>
</li>
<li class="top"><a href="#" target="_self" class="top_link"><span>SubjectInfo</span></a>
<ul class="sub">
<li><a href="subject.jsp" target="_self">Addsubject</a></li>
<li><a href="view.jsp" target="_self">Viewsubjects</a></li>
</ul>
</li>
<li class="top"><a href="#" target="_self" class="top_link"><span>EmployeeInfo</span></a>
<ul class="sub">
<li><a href="employee.jsp" target="_self">AppointEmployee</a></li>
<li><a href="view.jsp" target="_self">ViewEmployees</a></li>
</ul>
</li>
<li class="top"><a href="#" target="_self" class="top_link"><span>StudentsInfo</span></a>
<ul class="sub">
<li><a href="register.jsp" target="_self">RegisterStudent</a></li>
<li><a href="view.jsp" target="_self">ViewStudents</a></li>
</ul>
</li>
<li class="top"><a href="#" target="_self" class="top_link"><span>ExamScheduleInfo</span></a>
<ul class="sub">
<li><a href="view.jsp" target="_self">ViewInternalschedule</a></li>
<li><a href="view.jsp" target="_self">viewExternalschedule</a></li>
</ul>
</li>
<li class="top"><a href="#" target="_self" class="top_link"><span>Security</span></a>
<ul class="sub">
<li><a href="changepassword.jsp" target="_self">Changepassword</a></li>
</ul>
</li>
<li class="top"><a href="#" target="_self" class="top_link"><span>Logout</span></a>
</li>
</ul>
</div>
