
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>
	<script language="JavaScript" src="<%=request.getContextPath()+"/scripts/gen_validatorv31.js"%>" type="text/javascript"></script>
		<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
.Title1 {font-family:Verdana;
font-weight:bold;
font-size:8pt
}
        </style>
          <script language="JavaScript" type="text/javascript">
//--------------- LOCALIZEABLE GLOBALS ---------------
var d=new Date();
var monthname=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
//Ensure correct for language. English is "January 1, 2004"
var TODAY = monthname[d.getMonth()] + " " + d.getDate() + ", " + d.getFullYear();
//---------------   END LOCALIZEABLE   ---------------
document.getElementById("div1").innerHTML=TODAY;
</script>
<script type="text/javascript" src="scripts/validate.js"></script>
<script type="text/javascript" src="scripts/ts_picker.js"></script>
	</head>
	<body bgcolor="white">
	

 <jsp:include page="Header.jsp"></jsp:include>
<br/>
         
       
        <form action="<%=request.getContextPath()+"/LoginAction"%>" method=post name="login">
        
        
        <table  border="0" align="center"  bgcolor="white" width="100%">
               <tr>
               <td>
             <center> <div id="div1"  height="40" width="60" style="border:2px solid green;color:White; size:6px;position:relative;left:100px;background-color:black;">
                <script language="JavaScript" type="text/javascript">
                     document.write(TODAY);
                </script>
               </div></center>
               </td>
              </tr>
              <tr>
                 <TD vAlign=top align=right colSpan=2><div align="left" >
                    <span class="style1"><FONT size="2" color="red"> <script language="JavaScript" type="text/javascript">
                     	</script></FONT></span><BR>
                </div></TD>
                
               <td  background="#F5FFFA"> <img src="<%=request.getContextPath()+"/images/login.jpg"%>"  height="200" width="250"/>
                 </td>
                 <td height="120" align="right"></td>
                 <td><table border="0" align="center" width="240" height="200">
                <tr align="center"><strong><h3><font color="#800080">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Login Form</font></h3></strong>
 	</tr>
                   <tr>
                     <td ><font color="#CD5C5C" size=""><b>UserID</b></font></td>
                      <td ><input type="text" name="username"> </td>
                      </tr>
                   <tr>
                     <td><font color="#CD5C5C" size=""><b>Password</b></font></td>
                      <td>
                        <input type="password" name="password"><br><br>                      </td>
                      </tr>
                    <tr>
                     <td colspan="2">
                       <div align="center" class="style11">
                         <input type="image" name="Submit"src="images/sign.png" height="50" width="120">
                          &nbsp;
                           <input type="image" name="reset"src="images/clear.png" height="50" width="100">
                         </div> 
                         </tr>   
                                       <!--     <tr>                     
                         <td><div>
                         <a href="Register.jsp">NewStudentSignUp??</a>
                         
                         </div></td>
                         
                      </tr> -->
                         
                      
                
                 </table>
             </table>
          </form>
        
          <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");

  frmvalidator.addValidation("username","req","Login Name is required");
  frmvalidator.addValidation("password","req","Password is required");
   
  </script><!--
   <jsp:include page="./Footer.jsp"></jsp:include>
	--></body>
</html>