
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

 if(session.getAttribute("loginuser")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("./LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>
<html>
  <head>
  
  <script type = "text/javascript" >



function sanjay(form){

alert("hai");


 var total="00.00"; 

  var count=0;
 
     validate(form);
     for(var i=1;document.f1.smarks[i]!=null;i++)
     { 
           if(document.f1.smarks[i].value<=0)
            {
                alert("Quantity must be greater than Zero");
                document.f1.smarks[i].value=1;
            }    
                document.order.price[i].value = (document.order.iprice[i].value)*(document.order.quantity[i].value);
                total=parseFloat(total)+parseFloat(document.order.price[i].value);
                document.order.total.value=total;
                
      }             
  }








function validate(form)
{
alert("Anotherhai")
   for(var i=1;document.f1.smarks[i]!=null;i++)
   {
       if(parseInt(document.f1.smarks[i].value) > parseInt(document.f1.smarks[i].value))
       {
            alert("Not sufficient inventory");
            document.f1.smarks[i].value = document.f1.smarks[i].value;
            calculate(form);
            return false;
       }   
   }
   return true;
}
</script>

</script>
  
  
  
  
  
    
  
  
  
  
  
  
 
	<script language="JavaScript" type="text/javascript"
		src="<%=request.getContextPath()+"/scripts/ts_picker.js"%>"></script>
		<script language="JavaScript" type="text/javascript"
		src="<%=request.getContextPath()+"/scripts/general.js"%>"></script>
		<script language="JavaScript" type="text/javascript"
		src="<%=request.getContextPath()+"/scripts/gen_validatorv31.js"%>"></script>
		
  
  <script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
 </head>
 
    <body onload="javascript:disableBackButton()">
  <%
  
  System.out.println(request.getAttribute("userid"));
  int userid=(Integer)request.getAttribute("userid");
  System.out.println(userid);
  int uid=userid;
   %>
 
 <jsp:include page="AddMarks.jsp"></jsp:include> 
<form   name="f1" action="AddMarksAction"   >
    <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>STUDENT COURSES INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Student Course Info</i></tr>
   <br/>
   <tr><th bgcolor="#4682B4"><b>Course Title</b></th><th bgcolor="#4682B4"><b>Subject Title</b></th><th bgcolor="#4682B4"><b>ExamTitle</b></th><th bgcolor="#4682B4"><b>ExamAttemptDate</b></th><th bgcolor="#4682B4"><b>TotalMarks</b></th><th bgcolor="#4682B4"><b>Marks</b></th>
   
    
    </tr>
   
   <c:if test="${not empty SCInfo}">
    
  <c:forEach var="SCInfo" items="${SCInfo}">
   <tr>
  
  

  
  
 <td>${SCInfo.cname }</td>
  
  <td><input type="hidden"  value="<%=request.getAttribute("userid")%>" name="userid" />${SCInfo.sname }</td>
  <td><input type="hidden"  value="  ${SCInfo.courseid }  " name="courseid" /> ${SCInfo.ename }<input type="hidden"  value="${SCInfo.subid}" name="subjid" /></td>
  <td> <input type="hidden"  value="${SCInfo.examid }" name="examid" /> ${SCInfo.edate }</td>
  <td> <input type="hidden"  value="${SCInfo.ename }" name="${SCInfo.ename }" />    ${SCInfo.tmarks }</td>
  
  <td><input type="hidden"  value="${SCInfo.tmarks }" name="tmarks" /><input type="text" value="" id="smarks" name="smarks" onblur="sanjay()" /></td>
  <td><input type="hidden"  value="${SCInfo.passpercentages }" name="pass" />
 
  
  <!--<td><a href="./EnterMarks.jsp?courseid=${SCInfo.courseid }&sname=${SCInfo.sname}&subid=${SCInfo.subid}&cname=${SCInfo.cname }&examid=${SCInfo.examid }&ename=${SCInfo.ename }&etype=${SCInfo.etype }&tmarks=${SCInfo.tmarks }&userid=<%=uid %>">EnterMarks</a></td>
  
   --></tr>  
   
  </c:forEach>
   </c:if>
   <c:if test="${empty SCInfo}">
   				<tr>
   			<td colspan="5"> No Record Found</td>
   			</tr>
   				</c:if>
   				
   				<td><input type="submit" value="submit" name="submit"/></td>
   				
   				
   				
   				
 </table>
 
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("f1");

    frmvalidator.addValidation("smarks","req","userid is required");
    frmvalidator.addValidation("smarks","numeric","Please EnterNumeric value");
    frmvalidator.addValidation("smarks","lt",50"Please   NUMBER MUST BE 60EnterNumeric value");
    
    
    
    </script>
   
   <br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
		
		
  </body>
</html>
