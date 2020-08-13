
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



<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
<script language="javascript">





function validate()
{
   var temp = document.register;
   if(temp.fname.value=="" || temp.lname.value=="" || temp.bdate.value=="" || temp.loginname.value=="" || temp.password.value=="" || temp.sanswer.value=="")
   {
       alert("All Fields are manditory");
       return false;
   }
   if(temp.ch.checked && temp.ownquest.value=="")
   {
       alert("All Fields are manditory");
       return false;
   }
   return true;
}
function check()
{
    var form = document.register;
    if(!form.ch.checked){
          form.ownquest.disabled=true;
          form.squest.disabled=false;
    }
    else{
          form.ownquest.disabled=false;
          form.squest.disabled=true;
    }
}
</script>
  <script type="text/javascript" src="scripts/general.js"> </script>
   <script type="text/javascript" src="scripts/ts_picker.js"> </script>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>

	<meta http-equiv="Last-Modified" content="Thu, 02 Aug 2007 10:30:00 GMT"/>
	
	
	<title>e-Banking</title>

	<link rel="icon" href="http://www.bis.org/favicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="http://www.bis.org/favicon.ico" type="image/x-icon"/>
	
	<link href="cbanks_files/standard.css" type="text/css" rel="stylesheet"/>
	
	<!-- JavaScript variable to set the active Menu -->
	<script type="text/javascript" src="cbanks_files/standard.js"></script>
	<script type="text/javascript">
	<!--
		var primaryMenu = "Central bank hub";
		var secondaryMenu = "Central bank websites";
	// -->
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
    	
<jsp:include page="Header.jsp"></jsp:include>
    
	
			<center><h2>Reply Form</h2></center>
		  <div class="hr"> </div>
          <p></p> 
          					<form  method="post" action="./PostSolutionAction" name="replay">
          					
          					 <%!
   
               Date date=new Date();
              DateFormat df = new SimpleDateFormat("dd-MMM-yy");
              
            String  reportDate = df.format(date); 
             %>
          					
          					
					
					
					  <table width="381" border="1" align="center">
                        
                        
                        
                        <c:if test="${not empty QueryAt}">
                        
                        <c:forEach var="QueryAt" items="${QueryAt}">
                        
                        
                      <tr>
                  <td width="85"><span>QueryId</span><br></td>
              <td width="286"><label>
                            <input type="text" name="qid" size="48" value="${QueryAt.qid }" readonly="readonly" />
                          </label><br></td>
                        </tr>
                  
                  
                  <tr>
                 <td width="85"><span>From</span><br></td>
              <td width="286"><label>
                            <input type="text" name="from" size="48" value="${QueryAt.cname }" readonly="readonly" />
                          </label><br></td>
                        </tr>
                        <tr>
                          <td><span >To</span><br></td>
                          <td><label>
                            <input type="text" name="to"  size="48"  value=" E-Manager" readonly="readonly"/>
                          </label><br></td>
                        </tr>
                        <tr>
                          <td><span class="">Query</span><br></td>
                          <td><label>
                            <textarea name="query"  cols="45" rows="5"  readonly="readonly">${QueryAt.query }</textarea>
                          </label><br></td>
                        </tr>
                        <tr>
                          <td><span class="">Send Date</span><br></td>
                          <td><input type="text" name="sdate"   readonly="readonly" value="${QueryAt.date }"/><br></td>
                        </tr>
                        
                        </c:forEach>
                        </c:if>
                        <tr>
                          <td><span class="">Reply Date</span><br></td>
                           <td>
                   <input type="text" name="rdate" readonly="readonly"  value="<%=reportDate %>"/>
      
                     </td>
                        </tr>
                        <tr>
                          <td><span class="">Solution</span></td>
                          <td><textarea name="solution"  cols="45" rows="5" ></textarea></td>
                        </tr>
                        <tr>
                          <td colspan="2">:<label>
                            <div align="center">
                              <input type="submit" value="PostSolution"/>
                              </div>
                          </label></td>
                        </tr>
                      </table>
                    
            
                      
                      </form>
                      
                     	<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("replay");

  frmvalidator.addValidation("qid","req","QueryId is required");
    frmvalidator.addValidation("solution","alpha","solution is Only Characters");
    frmvalidator.addValidation("from","req","Sender is required");
    frmvalidator.addValidation("to","req","Responder is required");
     frmvalidator.addValidation("query","req","Query is required");
    frmvalidator.addValidation("sdate","req","ReceivedDate is required");
     frmvalidator.addValidation("rdate","req","SendDate is required");
       frmvalidator.addValidation("solution","req","solution is required");

     </script>
			<br/>
			<jsp:include page="Footer.jsp"></jsp:include>
</body></html>