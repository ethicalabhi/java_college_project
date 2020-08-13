package com.college.Action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.college.FormBean.NotificationBean;
import com.college.Mgrdelegate.CourseMgrDelegate;




public class ViewNotificationAction extends HttpServlet {

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
        Vector<NotificationBean> announcements=null;

	  try{
		
		
		 String path1=request.getRealPath("/notifications");
	
		try{
		  
		 announcements= new CourseMgrDelegate().viewAllNotification( path1);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		HttpSession hs=request.getSession();
		 System.out.println("in Action class vcb..........."+announcements);
	
		  if(!announcements.isEmpty()){
			  request.setAttribute("Notification", announcements);
			  request.setAttribute("status", "Enjoy the Notification Info");
			  path="./ViewNotification.jsp";
			 }
		  else {
			  request.setAttribute("status", "There is no Notification");
			  path="./ViewNotification.jsp";
			  }
		  }
	  catch (NullPointerException e){
		  request.setAttribute("status", "Invalid Data");
		  path="./ViewNotification.jsp";
		  e.printStackTrace();
		  }
	  RequestDispatcher rd=request.getRequestDispatcher(path);
	rd.forward(request,response);

  }

	}


