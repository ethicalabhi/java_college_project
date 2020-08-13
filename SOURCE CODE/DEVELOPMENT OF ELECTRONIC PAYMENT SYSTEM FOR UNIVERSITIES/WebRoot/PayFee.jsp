<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>

<%
	double st = 0.0;
if (request.getAttribute("tamount") != null) {
%>
<%
	st = (Double)request.getAttribute("tamount");
%>
<%
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 
 <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
<script type="text/javascript">
	 
	 function CheckAvailable()
	 {
	   var userid=document.getElementById("userid").value;
	    var tamount=document.getElementById("tamount").value;
	  
	   window.location.href="<%=request.getContextPath()%>/ChekBalAction?userid="+userid+"&bal="+tamount+"&path=./ChekBalAction?page=PayFee.jsp";
	 }
	  
   
   </script>
   
   <script>
function validateForm()
{
    if(document.fee.tamount.value=="")
    {
      alert("Ammount is required");
      document.fee.tamount.focus();
      return false;
    }
    else if(document.fee.toacctno.value=="")
    {
      alert("Account No. required");
      document.fee.toacctno.focus();
      return false;
    }
}
</script>
	<script language="JavaScript" type="text/javascript"
		src="<%=request.getContextPath()+"/scripts/ts_picker.js"%>"></script>
		
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
                   
		<form action="<%=request.getContextPath()+"/UploadFeeAction"%>" name="fee" method="post" onSubmit="return validateForm()">
		<center>
    <table border="1" width="585" height="173">
    
    
    <caption>FEE PAYMENT</caption>
    <tr>
   
                                <c:if test="${not empty sfeeinfo}">
                                <c:forEach var="sfeeinfo" items="${sfeeinfo}">
    
                                    <tr>
                                    
                                <td width="328"><span class="style17"><font color="BLACK"><b>StudentId</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="userid" readonly="readonly" value="${sfeeinfo.userid }">
                                </label></td>
                              </tr>
                                    
                                    
                              <tr>
                                <td width="328"><span class="style17"><font color="BLACK"><b>StudentName</b></font> </span></td>
                                <td width="150"><label>
                                <input type="text" name="login" value="${sfeeinfo.login }" readonly="readonly">
                                </label></td>
                              </tr> 
                              
                              <tr>
                              <td width="328"><span class="style17"><font color="BLACK"><b>CourseName</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="cname" value="${sfeeinfo.cname }" readonly="readonly">
                                </label></td>
                              </tr>
                              <tr>
                             
                                <td width="328"><span class="style17"><font color="BLACK"><b>BranchName</b></font> </span></td>
                                <td width="150"><label>
                                <input type="text" name="branchname" value="${sfeeinfo.branchname }" readonly="readonly">
                                </label></td>
                              </tr> 
                             
                               
                            
         
                             <tr>
                                    <td width="328"><span class="style17"><font color="BLACK"><b>Academic Fee</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="af" value="${sfeeinfo.af }" readonly="readonly">
                                </label></td>
                              </tr>
                              
                              <tr>
                                    <td width="328"><span class="style17"><font color="BLACK"><b>Training & Placement Fee</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="pf" value="${sfeeinfo.pf }" readonly="readonly">
                                </label></td>
                              </tr>
                              
                              <tr>
                                    <td width="328"><span class="style17"><font color="BLACK"><b>Laboratory Fee</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="lf" value="${sfeeinfo.lf }" readonly="readonly">
                                </label></td>
                              </tr>
                              
                              <tr>
                                    <td width="328"><span class="style17"><font color="BLACK"><b>Exam Fee</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="ef" value="${sfeeinfo.ef }" readonly="readonly">
                                </label></td>
                              </tr>
                              
                              <tr>
                                    <td width="328"><span class="style17"><font color="BLACK"><b>Transportation Fee</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="tf" value="${sfeeinfo.tf }" readonly="readonly">
                                </label></td>
                              </tr>
                              
                              <tr>
                                    <td width="328"><span class="style17"><font color="BLACK"><b>Hostel Fee</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="hf" value="${sfeeinfo.hf }" readonly="readonly">
                                </label></td>
                              </tr>
                              
                              <tr>
                                    <td width="328"><span class="style17"><font color="BLACK"><b>Total Fee</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="titalfee" value="${sfeeinfo.titalfee }" readonly="readonly" >
                                </label></td>
                              </tr>
                               <tr>
                                    <td width="328"><span class="style17"><font color="BLACK"><b>Due Fee</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="duefee" value="${sfeeinfo.duefee }" readonly="readonly" >
                                </label></td>
                              </tr>
                              
                            <tr>
                            <td width="328"><span class="style17"><font color="BLACK"><b>Pay Amount</b></font> </span></td>
                                <td width="150"><label>
                             <input type="text" name="tamount" value='<%=st%>' onchange="javascript:CheckAvailable()">
                                </label></td>
                              </tr>
                              
                               <tr>
                                  <td width="328"><span class="style17"><font color="BLACK"><b>From Account No</b></font> </span></td>
                                <td width="150"><label>
                              <input type="text" name="acctno" value="${sfeeinfo.acctno }" readonly="readonly" >
                                </label></td>
                              </tr>
                             <tr>
                                  <td width="328"><span class="style17"><font color="BLACK"><b>To Account No</b></font> </span></td>
                                <td width="150"><label>
                             <input type="text" name="toacctno" >
                                </label></td>
                              </tr>
                    </tr> </table>
                    <table>        
                     </br>         
              <tr>
                             <td align="right">
                             <input type="submit" name="submit" value="Submit Fee">
                              </td></tr>
                          </c:forEach>
                          </c:if>    
    </table>
    
    </center>
    
    <br/>
			
                    
    </form>
    
      <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("fee");

  frmvalidator.addValidation("tamount","req","Ammount is required");
  frmvalidator.addValidation("toacctno","req","Account no is required");
    
  
  </script>
  <br/>
    <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
