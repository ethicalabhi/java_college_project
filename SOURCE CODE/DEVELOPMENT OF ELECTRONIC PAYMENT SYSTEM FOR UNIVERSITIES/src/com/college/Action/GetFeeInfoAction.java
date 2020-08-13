package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.college.DaoImpl.AccountDAO;
import com.college.DaoImpl.CourseDaoImpl;

import com.college.FormBean.RegisterFormBean;
import com.college.FormBean.CourseFormBean;

public class GetFeeInfoAction extends HttpServlet {

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
		   
		  
		    HttpSession session=request.getSession();
			String login=(String)session.getAttribute("loginuser");	
			System.out.println(login);
			Vector<CourseFormBean> vqb= new CourseDaoImpl().StudentFee(login);				  								 
		  
		 
		  System.out.println("in Action class vcb userinfo..........."+vqb);
		  
		  
		  if(!vqb.isEmpty())
		  {
			  request.setAttribute("feeInfo", vqb);
			  path="ViewFeeDetails.jsp";
			  request.setAttribute("status","Here Is Fee Info");
			 }
		  else {
			  
			  path="ViewFeeDetails.jsp";
			  request.setAttribute("status","No Fee  Available ");
			
		}
		  
	}
	  catch (Exception e) {
		e.printStackTrace();
		path="ViewFeeDetails.jsp";
		request.setAttribute("status","No Users Available");
	}


	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);

		
		
		
	}

}
