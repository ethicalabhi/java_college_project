package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.college.DaoImpl.AccountDAO;

import com.college.FormBean.RegisterFormBean;
import com.college.FormBean.TransactionFormBean;

public class GetBalanceAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path="";
		
		try{
			 String path1=request.getRealPath("/userimages");
		 
		 System.out.println("path--------"+path1);
		  
		 HttpSession session=request.getSession();
			String login=(String)session.getAttribute("loginuser");	
			System.out.println(login);
		    ArrayList<TransactionFormBean> vqb= new AccountDAO().getusers(path1,login);				  								 
		  
		 
		  System.out.println("in Action class vcb userinfo..........."+vqb);
		  
		  
		  if(!vqb.isEmpty())
		  {
			  request.setAttribute("AccInfo", vqb);
			  path="ViewAccountDetails.jsp";
			  request.setAttribute("status","Here Is The Users Info");
			 }
		  else {
			  
			  path="userhome.jsp";
			  request.setAttribute("status","No Users  Available ");
			
		}
		  
	}
	  catch (Exception e) {
		e.printStackTrace();
		path="userhome.jsp";
		request.setAttribute("status","No Users Available");
	}


	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);

		
		
		
	}

}
