package com.college.Action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.college.DaoImpl.ExamDaoImpl;

import com.college.FormBean.CourseFormBean;

public class ViewMarksAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
		String path="";
	      Vector<CourseFormBean> empInfo=null;
	        String page="";

		  try{
			  
			  
			  HttpSession session=request.getSession();
	    	  
	      	String login=(String) session.getAttribute("loginuser");
			 
	      	int userid=Integer.parseInt(request.getParameter("userid"));
			 
			  empInfo= new ExamDaoImpl().viewmarks(userid);
			  
			  
			
			  System.out.println("in getStudent ViewMarksAction  class corelist ..........."+empInfo);
			  if(!empInfo.isEmpty())
			  {
				  
				  request.setAttribute("MarksInfo", empInfo);
				  request.setAttribute("userid", userid);
				  request.setAttribute("status", "Here is the Info of Student Marks");
				  path="./ViewMarks.jsp";
				 }
			  else {
				  request.setAttribute("status", "No Data Found");
				  path="./ViewMarks.jsp";
				  }
			  }
		  catch (NullPointerException e) {
			  request.setAttribute("status", "In Valid Entries Try Again");
			  path="./ViewMarks.jsp";
			e.printStackTrace();
			
		}
		 RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
			
		
	}

}
