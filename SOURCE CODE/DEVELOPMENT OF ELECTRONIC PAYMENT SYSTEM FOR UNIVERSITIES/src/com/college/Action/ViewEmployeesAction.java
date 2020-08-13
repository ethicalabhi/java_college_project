package com.college.Action;

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

import org.apache.commons.beanutils.BeanUtils;

import com.college.Mgrdelegate.UserMgrDelegate;
import com.college.Util.CoreList;


public class ViewEmployeesAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		}
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	        String path="";
	        CoreList empInfo=null;

		  try{
			  String path1=request.getRealPath("/userimages");
			 
			  empInfo= new UserMgrDelegate().getEmployees(path1);
			
			  System.out.println("in Action class vcb ..........."+empInfo);
			  if(!empInfo.isEmpty())
			  {
				  request.setAttribute("EmpInfo", empInfo);
				  request.setAttribute("status", "Here is the Info About Employees");
				  path="./ViewEmployees.jsp";
				 }
			  else {
				  request.setAttribute("status", "No Data Found");
				  path="./ViewEmployees.jsp";
				  }
			  }
		  catch (NullPointerException e) {
			  request.setAttribute("status", "In Valid Entries Try Again");
			  path="./ViewEmployees.jsp";
			e.printStackTrace();
			
		}
		 RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
			}

}
