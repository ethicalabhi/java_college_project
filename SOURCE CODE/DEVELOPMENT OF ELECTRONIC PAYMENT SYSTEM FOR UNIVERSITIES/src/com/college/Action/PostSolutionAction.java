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

import com.college.FormBean.SolutionFormBean;
import com.college.Mgrdelegate.SolutionMgrDelegate;


public class PostSolutionAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          
		SolutionFormBean sfb=new SolutionFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(sfb, map);
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
		  
		
		   flag= new SolutionMgrDelegate().insertSolution(sfb);
		 
		  if(flag==true){
			  request.setAttribute("status", "Solution Posted successfully");
			  path="./SendSolution.jsp";
			 }
		  else {
			  request.setAttribute("status", "posting Of solution is Failed");
			  path="./SendSolution.jsp";
		  }
	  }
		  
	  catch (Exception e) {
		  request.setAttribute("status", "In valid data");
		  path="./SendSolution.jsp";
		e.printStackTrace();
		}
	RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
	
	}

}
