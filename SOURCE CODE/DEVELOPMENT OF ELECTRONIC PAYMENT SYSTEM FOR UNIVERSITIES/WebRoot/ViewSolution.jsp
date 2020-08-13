
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

  <script type="text/javascript" src="scripts/general.js"> </script>
   <script type="text/javascript" src="scripts/ts_picker.js"> </script>

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
	<!-- providing keyboard shortcuts to important links -->
	
	
<jsp:include page="Header.jsp"></jsp:include>
	
			<center><h2>Reply from Manager</h2></center>
		  <div class="hr"> </div>
		  
					  <table width="381" border="1" align="center">
					  
					  <c:if test="${not empty Solutionvector}">
                        <c:forEach var="Solutionvector" items="${Solutionvector}">
                        <tr>
                        
               
                        
                          <td width="85"><span class="">From</span></td>
              <td width="286"><label>
                            <input type="text" name="from"  size="48" value="${Solutionvector.cname }" readonly="readonly" />
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class="">To</span></td>
                          <td><label>
                            <input type="text" name="to"  size="48"  value="Faculty" readonly="readonly"/>
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class="">Query</span></td>
                          <td><label>
                            <textarea name="query" cols="45" rows="5" readonly="readonly" >${Solutionvector.query }</textarea>
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class="">Send Date</span></td>
                          <td><input type="text" name="sdate" value="${Solutionvector.sdate }" readonly="readonly" /></td>
                        </tr>
                        <tr>
                          <td><span class="">Reply Date</span></td>
                          <td><input type="text"  name="rdate" size="48" readonly="readonly" value="${Solutionvector.rdate }"/></td>
                        </tr>
                        <tr>
                          <td><span class="">Solution</span></td>
                          <td><textarea name="query2"  cols="45" rows="5"    readonly="readonly">${Solutionvector.solution }</textarea></td>
                        </tr>
                        <tr>
                          <td colspan="2"><label>
                            <div align="center">
                              <input type="submit"  name="back"  value="back" onclick="javascript:history.back(-1)"/>
                              </div>
                          </label></td>
                          
                          
                        </tr>
                        </c:forEach>
                        </c:if>
                       
                      </table>
                      
                      
          
				 <br/><br/>
			
                  <jsp:include page="Footer.jsp"></jsp:include>
</body></html>
