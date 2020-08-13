package com.college.Action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.CourseMgrDelegate;



public class CancelDepartmentAction extends HttpServlet {

	
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
		  
		  int cid=Integer.parseInt(request.getParameter("did"));
		  
	         flag= new CourseMgrDelegate().deleteDepartment(cid);		
		
		  
		System.out.println("in Action class flag..........."+flag);
		  
		 if(flag){
			  request.setAttribute("status","Department Cancled Successfully");
			  path="./ViewDepartmentAction?page=./ViewAllDepartment.jsp";
			 }
		  else {
			  request.setAttribute("status","Cancilation of Course is Failed");
			  path="./ViewDepartmentAction?page=./ViewAllDepartment.jsp";
		}
		   }
	  catch (Exception e) {
		  request.setAttribute("status","Envalid Entries");
		  path="./ViewDepartmentAction?page=./ViewAllDepartment.jsp";
		    e.printStackTrace();
		    }
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	}

}
