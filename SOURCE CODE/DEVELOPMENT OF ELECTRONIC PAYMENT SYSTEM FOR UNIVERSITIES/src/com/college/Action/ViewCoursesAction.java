package com.college.Action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.beanutils.BeanUtils;

import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.CourseMgrDelegate;






public class ViewCoursesAction extends HttpServlet {

	
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
		        Vector<CourseFormBean> courseinfo=null;
		        Vector<CourseFormBean> branchinfo=null;
		        String page=request.getParameter("page");

			  try{
				 
				  
				  
				  System.out.println("page------------>"+page);
				 
				  courseinfo= new CourseMgrDelegate().viewCourse();
				  branchinfo= new CourseMgrDelegate().viewBranch();	
				  
				  System.out.println("in Action class vcb..........."+courseinfo);
				  if(!courseinfo.isEmpty()){
					  request.setAttribute("coursevector", courseinfo);
					  request.setAttribute("branchinfo", branchinfo);
					  request.setAttribute("status", "Available");
					
					  path=page;
					 }
				  else {
					  request.setAttribute("status", "Course Info is Not Available");
					  path=page;
					  }
				   }
			  catch (NullPointerException e) {
				  request.setAttribute("status", "Invalid Entries");
				  path=page;
				e.printStackTrace();
				
			}
			 RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
	}

}
