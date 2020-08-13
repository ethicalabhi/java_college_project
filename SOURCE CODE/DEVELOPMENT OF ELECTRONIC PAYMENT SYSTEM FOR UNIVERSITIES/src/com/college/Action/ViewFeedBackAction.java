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

import com.college.FormBean.FeedBackFormBean;
import com.college.Mgrdelegate.FeedbackMgrDelegate;





public class ViewFeedBackAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        FeedBackFormBean fb=new FeedBackFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(fb, map);
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
        String path="";
        Vector<FeedBackFormBean> allFeedbacks=null;

	  try{
		  
		 
		 
		  allFeedbacks= new FeedbackMgrDelegate().getAllFeedBack();
		 
		  System.out.println("in Action class vcb Feedback..........."+allFeedbacks);
		   if(!allFeedbacks.isEmpty())
		  {
			  request.setAttribute("FeedBack", allFeedbacks);
			  request.setAttribute("status", "Here is the Feedbacks From Colleges");
			  path="./ViewAllFeedBacks.jsp";
			 }
		  else {
			  request.setAttribute("status", "No Feedbacks R There");
			  path="./ViewAllFeedBacks.jsp";
			}
		  }
	  catch (NullPointerException e) {
		  request.setAttribute("status", "Invalid data");
		  path="./ViewAllFeedBacks.jsp";
		e.printStackTrace();		
	}
	RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
}

	}


