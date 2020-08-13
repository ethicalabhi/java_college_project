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

import com.college.FormBean.ExamFormBean;
import com.college.Mgrdelegate.ExamMgrDelegate;



public class ExamScheduleAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

          ExamFormBean eb=new ExamFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(eb, map);
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
		 
		 flag= new ExamMgrDelegate().scheduleExam(eb);				  								 
		 
		 System.out.println("in Action class vcb..........."+flag);
		  if(flag){
			  request.setAttribute("status", "Exam Time table is Posted Successfully");
			  path="./ExamSchedule.jsp";
			 }
		  else {
			  request.setAttribute("status", "Exam Schedule Posting is Failed");
			  path="./ExamSchedule.jsp";
			  }
		  }
	  catch (Exception e) {
		  request.setAttribute("status", "In valid Entries");
		  path="./ExamSchedule.jsp";
		e.printStackTrace();
		}
     RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
   }

}
