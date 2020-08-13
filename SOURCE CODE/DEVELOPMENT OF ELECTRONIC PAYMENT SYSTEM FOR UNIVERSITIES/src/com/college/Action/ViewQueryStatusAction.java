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
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.college.FormBean.SolutionFormBean;
import com.college.Mgrdelegate.SolutionMgrDelegate;





public class ViewQueryStatusAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
               doPost(request, response);
               }
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      SolutionFormBean sb=new SolutionFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(sb, map);
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
        String path="";
        Vector<SolutionFormBean> queryStatus=null;

	  try{
		  HttpSession session=request.getSession();
    	  
      	String login=(String) session.getAttribute("loginuser");
		
		  queryStatus= new SolutionMgrDelegate().getQueryStatus(login);
		 
		  
		  System.out.println("in Action class vcb..........."+queryStatus);
		  if(!queryStatus.isEmpty()){
			  request.setAttribute("Statusvector", queryStatus);
			  request.setAttribute("status", "Here is the Query status");
			  path="./ViewQueryStatus.jsp";
			 }
		  else {
			  request.setAttribute("status", "No Query from u");
			  path="./ViewQueryStatus.jsp";
			}
		}
	  catch (NullPointerException e) {
		  request.setAttribute("status", "In valid Data");
		  path="./ViewQueryStatus.jsp";
		e.printStackTrace();
		}
  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);

	}

}
