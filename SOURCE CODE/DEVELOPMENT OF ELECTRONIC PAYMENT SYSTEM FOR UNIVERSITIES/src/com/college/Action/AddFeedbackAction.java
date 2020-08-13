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

import com.college.FormBean.FeedBackFormBean;
import com.college.Mgrdelegate.FeedbackMgrDelegate;


public class AddFeedbackAction extends HttpServlet {

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

		
		
		
		FeedBackFormBean fb=new FeedBackFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(fb, map);
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
        	 
        	 
		  
		       flag= new FeedbackMgrDelegate().insertFeedBack(fb);
		 
		   if(flag){
			   request.setAttribute("status", "Feedback Posted Successfully");
			  path="./Feedback.jsp";
			 }
		  else{
			  request.setAttribute("status", "Posting of Feedback is Failed");
			  path="./Feedback.jsp";
			  }}
	  catch (Exception e) {
		request.setAttribute("status", "Invalid Entries");
		  path="./Feedback.jsp";
		  e.printStackTrace();
		  }
	RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		
		
		
		
		
		
		
	}

}
