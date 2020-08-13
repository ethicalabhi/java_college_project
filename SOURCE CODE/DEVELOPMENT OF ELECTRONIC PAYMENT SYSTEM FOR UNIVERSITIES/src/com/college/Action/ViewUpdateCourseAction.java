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




public class ViewUpdateCourseAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);
	}
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		        String path="";
		        Vector<CourseFormBean> courseat=null;

			  try{
				  int cid=Integer.parseInt(request.getParameter("courseid"));
				  
				  
				   courseat= new CourseMgrDelegate().viewCourseAt(cid);	
				 
				  System.out.println("in View Course Update Action class vcb..........."+courseat);
				  if(!courseat.isEmpty()){
					  request.setAttribute("coursevector", courseat);
					  request.setAttribute("status", "Here is the Course Info");
					  path="./UpdateCourse.jsp";
					 }
				  else {
					  request.setAttribute("status", "Course Info is not Available");
					  path="./UpdateCourse.jsp";
					}
				  }
			  catch (NullPointerException e) {
				  request.setAttribute("status", "Invalid Enteries");
				  path="./UpdateCourse.jsp";
				e.printStackTrace();
				}
			RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
		
	
	}

}
