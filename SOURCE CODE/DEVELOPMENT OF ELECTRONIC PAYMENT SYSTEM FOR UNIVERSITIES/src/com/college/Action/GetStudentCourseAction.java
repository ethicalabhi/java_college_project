package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.college.DaoImpl.UserDaoImpl;
import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.UserMgrDelegate;
import com.college.Util.CoreList;

public class GetStudentCourseAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
	 	int userid=0;
		
		
		String path="";
      Vector<CourseFormBean> empInfo=null;
        String page="";

	  try{
		  
		  
		  HttpSession session=request.getSession();
    	  
      	String login=(String) session.getAttribute("loginuser");
		 
       userid=Integer.parseInt(request.getParameter("userid"));
      	System.out.println("USERID"+userid);
		 
		  empInfo= new UserDaoImpl().getStudentCourseInfo(userid);
		  
		  
		
		  System.out.println("in getStudent Course Action  class corelist ..........."+empInfo.size());
		  if(!empInfo.isEmpty())
		  {
			  //request.setAttribute("userid", userid);
			  request.setAttribute("SCInfo", empInfo);
			  request.setAttribute("userid", userid);
			  request.setAttribute("status", "Here is the Info of StudentCourse");
			  path="./StudentCourseInfo.jsp";
			 }
		  else {
			  request.setAttribute("userid", userid);
			  request.setAttribute("status", "No Data Found");
			  path="./StudentCourseInfo.jsp";
			  }
		  }
	  catch (NullPointerException e) {
		  request.setAttribute("userid", userid);
		  request.setAttribute("status", "In Valid Entries Try Again");
		  path="./StudentCourseInfo.jsp";
		e.printStackTrace();
		
	}
	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		
		
		
		
	}

}
