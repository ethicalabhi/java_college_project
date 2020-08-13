<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.college.DaoImpl.AccountDAO"%>
<%@page import="com.college.FormBean.TransactionFormBean"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
  
   <%
          
          String login=(String)session.getAttribute("loginuser");
          
           %>
  <body>
   <jsp:include page="Header.jsp"></jsp:include>
	
			<center><h2>Transaction Page</h2></center>
			
			
			<form action="./DepositeAction">
			<table align="center" border="1">
			 <%
           
            AccountDAO loanDAO=new AccountDAO();
            
            Vector<TransactionFormBean> loanList=loanDAO.getAccno(login);
            
            if(loanList.isEmpty()){
            
            %>
            <tr>
            <td><b> <font size="3">Sorry U Account is Locked .Try Again</font></b>
            <%
            }
            
            System.out.println("in jsp vector obj ...is........"+loanList);
            System.out.println("in jsp vector obj ...is........"+loanList+"and size is ........"+loanList.size());  
           
          
         Iterator it=loanList.listIterator();

 while(it.hasNext())
 {%><%
 
 TransactionFormBean tfb=(TransactionFormBean)it.next();
  %>
			<tr>
			<td><font size="4">AccountNo</font></td><td> <input type="text" name="acctno" value="<%=tfb.getAcctno() %>" readonly="readonly"> </td>
			</tr>
			 <%} %>
			 <tr>
                     <td>TransactionType</td>
                     <td>
                     <select name="ttype">
                     <option value="">--SELECT--</option>
                     <option value="Deposit"  >Deposit</option>
                     
                     </select>
                     </td>
                     </tr>
                     <tr>
                     <td>TransactionAmount</td>
                      <td>
                        <input type="text" name="tamount"/>
                        </td>
                      </tr>
                      
                      <tr><td><input type="submit" value="Submit">  </td> <td><input type="reset" value="Clear"> </td> </tr>
			</table>
			
			
			
			
			
			</form>
			
			
			
  </body>
</html>
