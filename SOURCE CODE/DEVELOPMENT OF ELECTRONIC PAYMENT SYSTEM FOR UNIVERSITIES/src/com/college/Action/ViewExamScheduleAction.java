package com.college.Action;

import java.io.IOException;

import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.FormBean.ExamFormBean;
import com.college.Mgrdelegate.ExamMgrDelegate;

;

public class ViewExamScheduleAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 String path="";
		 Vector<ExamFormBean> scheduleInfo=null;

		  try{
			  scheduleInfo= new ExamMgrDelegate().viewSchedule();
			
			  System.out.println("in Action class vcb..........."+scheduleInfo);
			
			  if(!scheduleInfo.isEmpty())
			  {
				  
				  request.setAttribute("ExamSchedule", scheduleInfo);
				  request.setAttribute("status", "Here is the ExamSchedule Info");
				  path="./ViewExamSchedule.jsp";
				 }
			  else {
				  request.setAttribute("status", "There r No Schedules");
				  path="./ViewExamSchedule.jsp";
				}
			  }
		  catch (NullPointerException e) {
			  request.setAttribute("status", "In valid Data");
			  path="./ViewExamSchedule.jsp";
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		}

}
