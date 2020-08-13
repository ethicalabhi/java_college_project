package com.college.Action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.CourseMgrDelegate;





public class AddCourseAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);
		}
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		    CourseFormBean cb=new CourseFormBean();
				Map map=request.getParameterMap();
			try {
				BeanUtils.populate(cb, map);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				
			}
			String path="";
		        
		         boolean flag=false;
		         try{
		        	 
		        	  HttpSession session=request.getSession();
		        	  
		        	String login=(String) session.getAttribute("loginuser");
		        	    
		        	   cb.setLogin(login);
				  
				       flag= new CourseMgrDelegate().insertCourse(cb);
				 
				   if(flag){
					   request.setAttribute("status", "Course Introduced Successfully");
					  path="./AddCourse.jsp";
					 }
				  else{
					  request.setAttribute("status", "Introduction of Course is Failed");
					  path="./AddCourse.jsp";
					  }}
			  catch (Exception e) {
				request.setAttribute("status", "Invalid Entries");
				  path="./AddCourse.jsp";
				  e.printStackTrace();
				  }
			RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
				
}
}
