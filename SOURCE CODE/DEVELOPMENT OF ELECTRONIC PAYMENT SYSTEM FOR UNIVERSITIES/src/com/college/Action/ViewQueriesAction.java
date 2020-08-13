package com.college.Action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.college.FormBean.QueryFormBean;
import com.college.Mgrdelegate.QueryMgrDelegate;






public class ViewQueriesAction extends HttpServlet {

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
		        Vector<QueryFormBean> queryInfo=null;

			  try{
				 
				  queryInfo= new QueryMgrDelegate().getQueries();				  								 
				 
				 System.out.println("in Action class vcb..........."+queryInfo);
				  
				  
				  if(!queryInfo.isEmpty()){ 
					  request.setAttribute("Queryvector", queryInfo);
					  request.setAttribute("status", "Here is the Queries");
					  path="./ViewQueries.jsp";
					 }
				  else {
					  request.setAttribute("status", "No Queries from Students");
					  path="./ViewQueries.jsp";
					}
				  
		   }
			  catch (NullPointerException e) {
				  request.setAttribute("status","Invalid data");
				  path="./ViewQueries.jsp";
				e.printStackTrace();
				}
	 RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
		
	}


}
