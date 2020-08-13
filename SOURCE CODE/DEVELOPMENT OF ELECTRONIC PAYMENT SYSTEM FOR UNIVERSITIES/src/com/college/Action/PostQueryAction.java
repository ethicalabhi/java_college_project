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

import com.college.FormBean.QueryFormBean;
import com.college.Mgrdelegate.QueryMgrDelegate;

public class PostQueryAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QueryFormBean qb=new QueryFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(qb, map);
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
		  
		   flag= new QueryMgrDelegate().insertQuery(qb);
		 
		  if(flag==true){
			  request.setAttribute("status", "Query Posted Successfully");
			  path="./Queries.jsp";
			 }
		  else {
			  request.setAttribute("status", "Posting Of Query is Failed");
			  path="./Queries.jsp";
			}
		  }
	  catch (Exception e) {
		  request.setAttribute("status", "invalid Data");
		  path="./Queries.jsp";
		e.printStackTrace();
		}
	RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
  }
}
