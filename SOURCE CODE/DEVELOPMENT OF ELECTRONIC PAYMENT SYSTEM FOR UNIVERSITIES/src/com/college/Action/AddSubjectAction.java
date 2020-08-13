package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;
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


public class AddSubjectAction extends HttpServlet {

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
			  
			       flag= new CourseMgrDelegate().insertSubject(cb);
			 
			   if(flag){
				   request.setAttribute("status", "Subject Introduced Successfully");
				  path="./ViewCoursesAction?page=/AddSubject.jsp";
				 }
			  else{
				  request.setAttribute("status", "Introduction of Subject is Failed Or Subject Already Exist");
				  path="./userhome.jsp";
				  }}
		  catch (Exception e) {
			request.setAttribute("status", "Invalid Entries");
			  path="./userhome.jsp";
			  e.printStackTrace();
			  }
		RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		
		
		
		
	}

}
