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

import com.college.FormBean.NotificationBean;
import com.college.Mgrdelegate.CourseMgrDelegate;


public class NotificationAction extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NotificationBean ab=new NotificationBean();
		
		
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(ab, map);
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
		  
		  ab.setLogin(login);
		  
		 
		
		  
		 flag= new CourseMgrDelegate().insertNotification(ab);				  								 
		  
		 
		  System.out.println("in Action class vcb..........."+flag);
		  if(flag){
			  request.setAttribute("status","Notification Released Successfully" );
			  path="./Notification.jsp";
			 }
		  else {
			  request.setAttribute("status","Posting of Notification is Failed" );
			  path="./Notification.jsp";
			}
		  
   }
	  catch (Exception e) {
		  request.setAttribute("status","Invalid Data" );
		  path="./Notification.jsp";
		e.printStackTrace();
		
	}
     RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		}

}
