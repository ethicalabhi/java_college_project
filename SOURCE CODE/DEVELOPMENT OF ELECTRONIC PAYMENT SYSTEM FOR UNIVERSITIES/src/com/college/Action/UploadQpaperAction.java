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


public class UploadQpaperAction extends HttpServlet {

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
		  
		  String login=(String) request.getSession().getAttribute("loginuser");
		  
		  System.out.println("in action Class login is........."+login);
		  
		  cb.setLogin(login);
		  
		 
		
		  
		 flag= new CourseMgrDelegate().uploadQpaper(cb);				  								 
		  
		 
		  System.out.println("in Action class vcb..........."+flag);
		  if(flag){
			  request.setAttribute("status","Qpaper Released Successfully" );
			  path="./UploadQuestionpaper.jsp";
			 }
		  else {
			  request.setAttribute("status","Posting of Qpaper is Failed Or PaperCode is Already exists " );
			  path="./userhome.jsp";
			}
		  
   }
	  catch (Exception e) {
		  request.setAttribute("status","Invalid Data" );
		  path="./userhome.jsp";
		e.printStackTrace();
		
	}
     RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		
		
		
		
		
		
	}

}
