
<%@page import="com.college.FormBean.RegisterFormBean"%>
<%@page import="com.college.DaoImpl.RegisterDaoImpl"%>




<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>

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
        
<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js">


</script> <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
	</head>
	<body onload="Response.Cache.SetCacheability(HttpCacheability.NoCache);

Response.Cache.SetExpires(DateTime.Now); " >
<jsp:include page="Header.jsp"></jsp:include>

    <%  
   response.setHeader("Pragma","no-cache");  
    response.setHeader("Cache-Control","no-store");  
   response.setHeader("Expires","0");  
  response.setDateHeader("Expires",-1);  
    %>  
     
     <%
String name=(String)session.getAttribute("loginuser");
String path=request.getRealPath("/userimages");
RegisterFormBean aprofile=new RegisterDaoImpl().getprofile(name,path);

%>
     <br/>
    
     <br/>
     <table width="403" height="116" bordercolor="#FEE8B6">
     </tr>
       <tr>
       <td> <b>Photo</b></td>
 <td bgcolor=""> <p><img alt="See Photo Here" id="previewField" src="userimages/<%=aprofile.getPhoto() %>" height="70" ></p></td>
     </tr>
     <tr></tr><tr></tr><tr></tr><tr></tr>

       <tr><strong><span class="Title1"><u>Personal  Details<br/>
                 <br/>
       </u></span></strong></tr>
       <tr>
         <td width="128" bgcolor="#B0C4DE"><strong><span class="style14 Title">FirstName</span></strong></td>
         <td width="366" bgcolor="#B0C4DE"><span class="Title1"><strong><%=aprofile.getFname()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>LastName</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getLname()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#B0C4DE"><span class="Title1"><strong>DOB</strong></span></td>
         <td bgcolor="#B0C4DE"><span class="Title1"><strong><%=aprofile.getDob()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Email</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getEmail()%></strong></span></td>
       </tr>
       <tr>
        
         
         
         
         
         
       
     </table>
     
     <p></p>

 
<table border="1" align="center" bordercolor="#000000" bgcolor="#CCCCCC" width="719" height="20%">
  <br/>
  <br/>
  <tr><strong><span class="Title"><u> Address Details<br/>
            <br/>
  </u></span></strong></tr>
  <tr>
    
    <td bgcolor="#CCCCCC"><div align="center" class="Title">HouseNo</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Street</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">City</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">State</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Country</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">PhoneNo</div></td>
  </tr>
  
  
  <tr>
   
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getHno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getStreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getState()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCountry()%></span></td>
     <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getMobile()%></span></td>
  </tr>
  
</table>
<br/><br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>