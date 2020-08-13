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

import com.college.FormBean.RegisterFormBean;
import com.college.Mgrdelegate.RegisterMgrDelegate;



public class ChangePasswordAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2941564269120432640L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd=null;

		boolean flag=false;
		String path="";
		
		RegisterFormBean rto=new RegisterFormBean();
	
		Map map=request.getParameterMap();
	 try {
		BeanUtils.populate(rto, map);
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	}
	try{
	
		flag=new RegisterMgrDelegate().changePass(rto);
	
	   if(flag){
		   
		   request.setAttribute("status", "Password Changed Successfully");
		   
		   path="./Changepassword.jsp";
		   
		    }
	   else{
           request.setAttribute("status", "Changing of Password is failed");
		   
           path="./Changepassword.jsp";
		   }
		
	}
	catch (Exception e) {
		e.printStackTrace();
		
		request.setAttribute("status", "INVALID ENTRIES");
		   
		 path="./Changepassword.jsp";
		}
	
	rd=request.getRequestDispatcher(path);
	
	rd.forward(request, response);
	
	}

}
