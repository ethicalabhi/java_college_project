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
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.college.FormBean.SolutionFormBean;
import com.college.Mgrdelegate.SolutionMgrDelegate;

public class ViewSolutionAction extends HttpServlet {

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
        Vector<SolutionFormBean> getsolution=null;

	  try{
		  
		  int qid=Integer.parseInt(request.getParameter("qid"));
		  
		  HttpSession session=request.getSession();
    	  
      	String login=(String) session.getAttribute("loginuser");
      	    
      	 
		  
		  getsolution= new SolutionMgrDelegate().getSolution(qid,login);
		
		  System.out.println("in Action class vcb..........."+getsolution);
		  if(!getsolution.isEmpty()){
			  request.setAttribute("Solutionvector", getsolution);
			  request.setAttribute("status", "Enjoy the solution");
			  path="./ViewSolution.jsp";
			 }
		  else {
			  request.setAttribute("status", "Sorry u Query is Not Solved till Now");
			  path="./ViewSolution.jsp";
		}
		}
	  catch (NullPointerException e) {
		  request.setAttribute("status", "Invalid Data");
		  path="./ViewSolution.jsp";
		e.printStackTrace();
	}
	RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);

}

	}


