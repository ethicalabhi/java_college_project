

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
<html>
<script language="JavaScript1.2">
/*Number check script-
By JavaScript Kit (www.javascriptkit.com)
Over 200 free scripts here!
*/

function checknumber(){
var x=document.f.accno.value
var anum=/(^\d+$)|(^\d+\.\d+$)/
if (anum.test(x))
testresult=true
else{
alert("Please input a valid number!")
testresult=false
}
return (testresult)
}

</script>
<script>
function checkban(){
if(validateFields())
{
if (document.layers||document.all||document.getElementById)
return checknumber()
else
return true;
}
else
return false; 
}
</script>
<script type="text/javascript" src="scripts/project.js"></script>

<head>

    <style type="text/css">
<!--
.style1 {
	font-size: 50px
}
-->
    </style>
    
    <script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
 </head>
 
    <body onload="javascript:disableBackButton()">
	<!-- providing keyboard shortcuts to important links -->
	
	 	
<jsp:include page="Header.jsp"></jsp:include>

			<center><h2>All FeedBacks</h2></center>
		  <div class="hr"> </div>
          <p></p>                       <fieldset>
          
          
         
          
           <table width="637" border="0" align="center" bordercolor="#8692E3">
         <tr bgcolor="#50cccc">
        <td width="233" height="16"><div align="center" class="style8">FeedBack ID</div></td>
        <td width="372"><div align="center" class="style8">Contact</div></td>
        <td width="372"><div align="center" class="style8">MailID</div></td>
        <td width="372"><div align="center" class="style8">Read</div></td>
        <td width="372"><div align="center" class="style8">Delete Action</div></td>
      </tr>
		   <c:if test="${not empty FeedBack}" >
          <c:forEach var="FeedBack" items="${FeedBack}">
         	
      <tr bgcolor="#CcC9cA">
              <td bgcolor="#C3D7BA"><div align="center"><span class="style7">${FeedBack.fid }</span></div></td>
        <td bgcolor="#C3D7BA"><div align="center" class="style7">${FeedBack.mobile }</div></td>
        <td bgcolor="#C3D7BA"><div align="center"><span class="style7">${FeedBack.email }</span></div></td>
        <td bgcolor="#C3D7BA"><div align="center" class="style3">
         
        <strong><a href="./GetFeedbackAction?fid=${FeedBack.fid }">READ</a></strong>
      
        </div></td>
        
     
      <td bgcolor="#C3D7BA"><div align="center" class="style3">
              
        <strong><a href="./DeleteFeedbackAction?fid=${FeedBack.fid }">DELETE</a></strong>
      
        </div></td>
      </tr>   
      </c:forEach>
      </c:if>
      <c:choose>
      <c:when test="${ empty FeedBack}">
     
    
         <tr><td height="24" colspan="6"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
        
         </tr>
         </c:when>
         </c:choose>
         
   
       </table>
       </fieldset>
       
      
    <br/><br/>
			
                   <jsp:include page="Footer.jsp"></jsp:include>
                
        
</body></html>








