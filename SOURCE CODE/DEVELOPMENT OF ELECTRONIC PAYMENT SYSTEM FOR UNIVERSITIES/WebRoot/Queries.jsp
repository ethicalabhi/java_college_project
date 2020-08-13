
<%@page import=" java.text.DateFormat"%>
<%@page import=" java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>

<html>
<head>
<script type="text/javascript">

function validation(){

document.getElementById("ErrorQuery").innerHTML="";
if(document.getElementById("query").value==""){

document.getElementById("ErrorQuery").innerHTML="Plz Enter Query";
return false;
}else if(!isNaN(document.getElementById("query").value)){
document.getElementById("ErrorQuery").innerHTML="Plz Enter Only Alphabets";
return false;
}

}



</script>
  
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
    
    
    
    
     <%!
   
  Date date=new Date();
              DateFormat df = new SimpleDateFormat("dd-MMM-yy");
              
            String  reportDate = df.format(date); 
             
              
    

 %>
 
 
<jsp:include page="Header.jsp"></jsp:include>
                   
			

			<center><h2><font color="#share">Send Query</font></h2></center>
		  <div class="hr"> </div>
          <p></p> 
					<form id="formquery" name="queryform" method="post" action="<%=request.getContextPath()+"/PostQueryAction"%>" onsubmit="return validation();">
					  <table width="337" border="2" align="center">
                        <tr>
                          <td width="54"><span class=""><font color="#FF77">From</font></span></td>
                          <td width="273"><label>
                            <input type="text" name="from"  size="48" value="<%=(String)session.getAttribute("loginuser")%>" readonly="readonly" />
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class=""><font color="#FF77">To</font></span></td>
                          <td><label>
                            <input type="text" name="to"   size="48"  value="E-Manager" readonly="readonly"/>
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class=""><font color="#FF77">Query</font></span></td>
                          <td><label>
                            <textarea name="query" id="query" cols="45" rows="10"></textarea>
                            
                          </label><div id="ErrorQuery"></div></td>
                          
                        </tr>
                        
                        <tr>
                          <td><span class=""><font color="#FF77">Date</font></span></td>
                          <td>
                   <input type="text" name="date" readonly="readonly" value="<%=reportDate %>"/>
      
                     </td>
                        </tr>
                        
                        <tr>
                          <td colspan="2"><label>
                            <div align="center">
                              <input type="submit" name="send" value="SEND" >
                             </div>
                          </label></td>
                        </tr>
                      </table>
                      
                      
                    
		
                      </form>
		
			
                  <jsp:include page="Footer.jsp"></jsp:include>

</body></html>