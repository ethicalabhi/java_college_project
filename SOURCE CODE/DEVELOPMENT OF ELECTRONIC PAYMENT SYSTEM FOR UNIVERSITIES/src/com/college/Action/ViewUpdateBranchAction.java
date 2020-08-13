package com.college.Action;

import java.io.IOException;


import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.CourseMgrDelegate;




public class ViewUpdateBranchAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);
	}
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		        String path="";
		        Vector<CourseFormBean> branchat=null;

			  try{
				  int cid=Integer.parseInt(request.getParameter("bid"));
				  
				  
				  branchat= new CourseMgrDelegate().viewBranchAt(cid);	
				 
				  System.out.println("in View Course Update Action class vcb..........."+branchat);
				  if(!branchat.isEmpty()){
					  request.setAttribute("branchat", branchat);
					  request.setAttribute("status", "Here is the Branch Info");
					  path="./UpdateBranch.jsp";
					 }
				  else {
					  request.setAttribute("status", "Branch Info is not Available");
					  path="./UpdateBranch.jsp";
					}
				  }
			  catch (NullPointerException e) {
				  request.setAttribute("status", "Invalid Enteries");
				  path="./UpdateBranch.jsp";
				e.printStackTrace();
				}
			RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
		
	
	}

}
