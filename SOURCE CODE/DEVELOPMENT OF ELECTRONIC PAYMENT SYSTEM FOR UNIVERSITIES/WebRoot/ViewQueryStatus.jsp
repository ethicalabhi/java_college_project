

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
<html>
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
    
    
    
 
<jsp:include page="Header.jsp"></jsp:include>

		<br/><br/><br/>
   
			<center><h2>Queries Status</h2></center>
		  <div class="hr"> </div>
          <p></p> 
                    <form method="post" action="ViewSolution">
 
    <table width="637" border="1" align="center" bordercolor="#8692E3">
    
      <tr bgcolor="#509Ccc">
     
        <td width="18"><div align="center">
            
        </div></td>
        <td width="233"><div align="center" class="style8">Query ID</div></td>
        <td width="233"><div align="center" class="style8">From</div></td>
        
        <td width="372"><div align="center" class="style8">Query Date</div></td>
        <td width="372"><div align="center" class="style8">Status</div></td>
        <td width="372"><div align="center" class="style8">Solution</div></td>
      </tr>
      
      <c:if test="${not empty Statusvector}">
      <c:forEach var="Statusvector" items="${Statusvector}">
     
         
      <tr bgcolor="white">
      <td bgcolor="white"><input name="ch" type="checkbox" id="checkbox2" onclick="check1()" value="${Statusvector. qid}"/></td> 
      <td bgcolor="white"><div align="center"><span class="style7">${Statusvector.quid }</span></div></td>
      <td bgcolor="white"><div align="center"><span class="style7">${Statusvector.to }</span></div></td>
      <td bgcolor="white"><div align="center"><span class="style7">${Statusvector.rdate }</span></div></td>
      <td bgcolor="white"><div align="center"><span class="style7">${Statusvector.status }</span></div></td>
      <td bgcolor="white"><div align="center"><span class="style7"><a href="./ViewSolutionAction?qid=${Statusvector. qid}&from=${sessionScope.user}">View</a></span></div></td>
       
       
       
        </div></td>
        
      </tr>
      </c:forEach>
      </c:if>
      
     
   
          <tr>
        <td colspan="6"><div align="center">
         
          <input type="submit" name="delete" value="Delete"/>
         
        </div></td>
      </tr>
     
    </table>
     <br/><br/>
			
                  <jsp:include page="Footer.jsp"></jsp:include>

</body></html>