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
		$('ul', this).slideDown(500);
		},
		function () {
		//hide its submenu
		$('ul', this).slideUp(3500);
		}
		);
		});
    </script>
</head>
<body>
	
	<div class="menu" >
		<ul>
			<li><FONT size="2"><a href="./userhome.jsp">Home</a></FONT></li>
			
			<li><FONT size="2"><a href="#">BranchInfo</a></FONT>
				<ul>
					<li><a href="./ViewDepartmentAction">ViewDepartment</a></li>
					<li><a href="./ViewBranchAction">ViewBranch</a></li>
					</ul>
		     </li>
			<li><FONT size="2"><a href="#">CourseInfo</a></FONT>
				<ul>
					<li><a href="./ViewCoursesAction?page=/ViewAllCourses.jsp">ViewCourses</a></li>
					 <li><a href="./ViewSubjectAction">ViewSubjects</a></li>
					</ul>
		     </li>
			
			
			
			
			
			
			<li><FONT size="2"><a href="./#">AccountInfo</a></FONT>
			<ul>
                
                <li><a href="./GetBalanceAction">ViewBalance</a></li>
                <li><a href="./Deposite.jsp">Deposit</a></li>
               </ul>
			
			</li>
			<li><FONT size="2"><a href="#">Fees Payment</a></FONT>
			<ul>
               
                <li><a href="./ViewStudentFeeAction">Fees Payment</a></li>
                 <li><a href="./GetFeeInfoAction">Fees Information</a></li>
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
			<li><FONT size="2"><a href="#">QueryInfo</a></FONT>
			<ul>
                <li><a href="./Queries.jsp">PostQuery</a></li>
                <li><a href="./ViewQueryStatusAction">ViewSolution</a></li>
                 <li><a href="./Feedback.jsp">PostFeedback</a></li>
               </ul>
			
			</li>
			
			<li><FONT size="2"><a href="./#">ViewProfile</a></FONT>
			<ul>
                
                <li><a href="./ViewProfile.jsp"><span>ViewProfile</span></a></li>
              
               </ul>
			
			</li>
			<li><FONT size="2"><a href="#">Security</a></FONT>
			<ul>
                <li><a href="./Changepassword.jsp">ChangePassword</a></li>
                
               </ul>
			
			</li>
			
			<li><FONT size="2"><a href="./LogoutAction">Logout</a></FONT>
			
			
			</li>
		</ul>
	</div>

</body>
</html>
