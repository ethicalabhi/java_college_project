package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.Mgrdelegate.UserMgrDelegate;
import com.college.Util.CoreList;

public class GetStudentsAction extends HttpServlet {

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
        CoreList empInfo=null;

	  try{
		  String path1=request.getRealPath("/userimages");
		 
		  empInfo= new UserMgrDelegate().getEmployees(path1);
		
		  System.out.println("in Action class vcb ..........."+empInfo);
		  if(!empInfo.isEmpty())
		  {
			  request.setAttribute("EmpInfo", empInfo);
			  request.setAttribute("status", "Here is the Info About Employees");
			  path="./ViewEmployees.jsp";
			 }
		  else {
			  request.setAttribute("status", "No Data Found");
			  path="./ViewEmployees.jsp";
			  }
		  }
	  catch (NullPointerException e) {
		  request.setAttribute("status", "In Valid Entries Try Again");
		  path="./ViewEmployees.jsp";
		e.printStackTrace();
		
	}
	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		
		
		
		
		
		
		
	}

}
