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

import com.college.DaoImpl.AccountDAO;
import com.college.FormBean.TransactionFormBean;

public class DepositeAction extends HttpServlet {

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

		
		
String path="";
		
		RequestDispatcher rd=null;
        boolean flag=false;
		TransactionFormBean  wf=new TransactionFormBean();
	    Map map=request.getParameterMap();
		
		try{
			BeanUtils.populate(wf, map);
			
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			
			
		flag= new AccountDAO().insertTransaction(wf);
		
		if(flag){
			request.setAttribute("status", "Amount Deposte Successfully");
			path="./Deposite.jsp";
			
		}
		else{
			request.setAttribute("status", "Amount deposite Failed try again");
			path="./userhome.jsp";
			
		}
		}catch (NullPointerException e) {
		e.printStackTrace();
		request.setAttribute("status", "Amount deposite Failed try again");
		path="./userhome.jsp";
	}
        rd=request.getRequestDispatcher(path);
        rd.forward(request, response);
		
		
		
		
		
		
		
	}

}
