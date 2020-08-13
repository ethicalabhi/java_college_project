<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" href="menu_style1.css" type="text/css" />
	 <script type="text/javascript" src="<%=request.getContextPath()+"/scripts/jquery.js"%>">
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
</head>
<body>
	
	<div class="menu" >
		<ul>
			<li><FONT size="2"><a href="./userhome.jsp">Home</a></FONT></li>
			
			<li><FONT size="2"><a href="#">Deprt_Info</a></FONT>
				<ul>
					<li><a href="./AddDepartment.jsp">AddDepartment</a></li>
					<li><a href="./ViewDepartmentAction">ViewDepartment</a></li>
					</ul>
		  </li>
		 <li><FONT size="2"><a href="#">BranchInfo</a></FONT>
				<ul>
					<li><a href="./AddBranch.jsp">AddBranch</a></li>
					<li><a href="./ViewBranchAction">ViewBranch</a></li>
					</ul>
		  </li>
			<li><FONT size="2"><a href="#">CourseInfo</a></FONT>
				<ul>
					<li><a href="./AddCourse.jsp">AddCourse</a></li>
					<li><a href="./ViewCoursesAction?page=/ViewAllCourses.jsp">ViewCourses</a></li>
					<li><a href="./ViewCoursesAction?page=/AddSubject.jsp">AddSubject</a></li>
                     <li><a href="./ViewSubjectAction">ViewSubjects</a></li>
					</ul>
		  </li>
		  <li><FONT size="2"><a href="./#">Account</a></FONT>
			<ul>
                
                <!--<li><a href="./GetBalanceAction">ViewBalance</a></li>
                --><li><a href="./Deposite.jsp">Deposit</a></li>
               </ul>
			
			</li>
          <li><FONT size="2"><a href="#">FeeInfo</a></FONT>
			<ul>
                <li><a href="./ViewCoursesAction?page=/AddFee.jsp">Add FeesInfo</a></li>
                <li><a href="./ViewAllStudentFeeAction">ViewStudentFeesInfo</a></li>
               </ul>
			
			</li>
			<li><FONT size="2"><a href="#">EmployeesInfo</a></FONT>
			<ul>
                <li><a href="./RegistrationForm.jsp">RegisterEmployee</a></li>
                <li><a href="./FacultyRegisterForm.jsp">RegisterFaculty</a></li>
                <li><a href="./ViewFacultiesAction?page=./ViewAllFaculties.jsp">ViewFaculties</a></li>
                <li><a href="./ViewEmployeesAction">ViewEmployees</a></li>
               </ul>
			
			</li>
			<li><FONT size="2"><a href="./RegistrationForm.jsp">StudentsInfo</a></FONT>
			<ul>
                <li><a href="./StudentRegisterForm.jsp">RegisterStudents</a></li>
                <li><a href="./ViewStudentsAction?page=./ViewAllStudents.jsp">ViewStudents</a></li>
                
               </ul>
			
			</li>
			
			<li>
					<FONT size="2"><a href="#" class="parent"><span>Mails</span> </a></FONT>
					<div>
						<ul>
							<li>
								<a href="./ComposeAppMailAction">Compose Mail</a>
							</li>

							<li>
								<a
									href="./OutboxAction?empid=<%=session.getAttribute("userid")%>&requesttype=inbox">Inbox</a>
							</li>
							<li>
								<a
									href="./OutboxAction?empid=<%=session.getAttribute("userid")%>&requesttype=outbox">Outbox</a>
							</li>
						</ul>
					</div>
				</li>
				<!--<li><a href="#">Security</a>
			<ul>
                <li><a href="./Changepassword.jsp">ChangePassword</a></li>
                
               </ul>
			
			--><li><FONT size="2"><br /></FONT></li>
			<li><FONT size="2"><a href="./LogoutAction">Logout</a></FONT>
			
			
			</li>
		</ul>
	</div>

</body>
</html>
