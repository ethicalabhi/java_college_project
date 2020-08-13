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

import org.apache.commons.beanutils.BeanUtils;

import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.CourseMgrDelegate;


public class CancelSubjectAction extends HttpServlet {

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
		  
		  int sid=Integer.parseInt(request.getParameter("subid"));
		  
	         flag= new CourseMgrDelegate().deleteSubject(sid);		
		
		  
		System.out.println("in Action class flag..........."+flag);
		  
		 if(flag){
			  request.setAttribute("status","Subject Cancled Successfully");
			  path="./ViewSubjectAction";
			 }
		  else {
			  request.setAttribute("status","Cancilation of Subject is Failed");
			  path="./ViewSubjectAction";
		}
		   }
	  catch (Exception e) {
		  request.setAttribute("status","Envalid Entries");
		  path="./ViewSubjectAction";
		    e.printStackTrace();
		    }
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		
	
	}

}
