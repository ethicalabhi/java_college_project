 <html>
 <head>
 
 <style media="all" type="text/css">
                @import "<%=request.getContextPath()+"/menu/menu_style.css"%>";
        </style>
	   <script type="text/javascript" src="<%=request.getContextPath()+"/scripts/jquery.js"%>">
       </script>
       <script type="text/javascript" src="<%=request.getContextPath()+"/scripts/moveclock.js"%>">
       </script>
      <script type="text/javascript">
		$(document).ready(function () {
		$('.menu li').hover(
		function () {
		//show its submenu
		$('ul', this).slideDown(1000);
		},
		function () {
		//hide its submenu
		$('ul', this).slideUp(1000);
		}
		);
		});
    </script>
 </head>
<body>

<div>
<ul class="menu">
<li class="top"><a href="<%=request.getContextPath()+"/Home.jsp"%>" target="_self" class="top_link"><span><b>Home</b></span></a>
</li>
<li class="top"><a href="<%=request.getContextPath()+"/Services.jsp"%>" target="_self" class="top_link"><span><b>Services</b></span></a>
</li>
<li class="top"><a href="<%=request.getContextPath()+"/Contactus.jsp"%>" target="_self" class="top_link"><span><b>ContactUs</b></span></a>
</li>

<li class="top"><a href="<%=request.getContextPath()+"/LoginForm.jsp"%>" target="_self" class="top_link"><span><b>Login</b></span></a>
</li>
</ul>
</div>
</body>
</html>
