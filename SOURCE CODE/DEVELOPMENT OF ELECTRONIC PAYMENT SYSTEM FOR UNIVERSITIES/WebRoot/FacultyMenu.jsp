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
		$('ul', this).slideDown(750);
		},
		function () {
		//hide its submenu
		$('ul', this).slideUp(750);
		}
		);
		});
    </script>
</head>
<body>
	
	<div class="menu" >
		<ul>
			<li><FONT face="Times New Roman" size="3"><a href="./userhome.jsp">Home</a></FONT></li>
			<li><FONT face="Times New Roman" size="3"><a href="#">Branch&amp;Course</a></FONT>
				<ul>
					<li><a href="./ViewDepartmentAction">ViewDepartment</a></li>
					<li><a href="./ViewBranchAction">ViewBranch</a></li>
					<li><a href="./ViewCoursesAction?page=/ViewAllCourses.jsp">ViewCourses</a></li>
					 <li><a href="./ViewSubjectAction">ViewSubjects</a></li>
					</ul>
		     </li>
			
			
			<li><FONT face="Times New Roman" size="3"><a href="./#">AccountInfo</a></FONT>
			<ul>
                
                <li><a href="./GetBalanceAction">ViewBalance</a></li>
                <li><a href="./Deposite.jsp">Deposit</a></li>
               </ul>
			
			</li>
			<li><FONT face="Times New Roman" size="3"><a href="#">StudentDetails</a></FONT>
			<ul>
                <li><a href="./ViewStudentsAction?page=./ViewAllStudents.jsp">ViewStudents</a></li>
                
               </ul>
			
			</li>
			<li><FONT face="Times New Roman" size="3"><a href="#">FeeInfo</a></FONT>
			<ul>
              
                <li><a href="./ViewAllStudentFeeAction">ViewStudentFeesInfo</a></li>
               </ul>
			
			</li>
			
			<li>
					<FONT face="Times New Roman" size="3"><a href="#" class="parent"><span>Mails</span> </a></FONT>
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
			<li><FONT face="Times New Roman" size="3"><a href="#">QueryInfo</a></FONT>
			<ul>
                <li><a href="./ViewQueriesAction">ReceiveQueries</a></li>
                <li><a href="./ViewQueriesAction">GiveSolution</a></li>
               </ul>
			
			</li>
			
			<li><FONT face="Times New Roman" size="3"><a href="#">Feedback</a></FONT>
			<ul>
                <li><a href="./ViewFeedBackAction">ViewFeedback</a></li>
               
               </ul>
			
			</li>
			
			<li><FONT face="Times New Roman" size="3"><a href="./RegistrationForm.jsp">Security</a></FONT>
			<ul>
                <li><a href="./Changepassword.jsp">ChangePassword</a></li>
                
               </ul>
			
			</li>
			
			<li><FONT face="Times New Roman" size="3"><a href="./LogoutAction">Logout</a></FONT>
			
			
			</li>
		</ul>
	</div>

</body>
</html>
