package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.DaoImpl.ExamDaoImpl;
import com.college.FormBean.ExamFormBean;
import com.college.Mgrdelegate.ExamMgrDelegate;

public class GetExamAction extends HttpServlet {

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
		 Vector<ExamFormBean> scheduleInfo=null;

		  try{
			  
			  int cid=Integer.getInteger(request.getParameter("cid"));
			  
			  System.out.println("in action class cid is==========================>"+cid);
			  
			  int sid=Integer.getInteger(request.getParameter("subid"));
			  scheduleInfo= new ExamDaoImpl().getExam(cid,sid);
			
			  System.out.println("in Action class vcb..........."+scheduleInfo);
			
			  if(!scheduleInfo.isEmpty())
			  {
				  request.setAttribute("cid", cid);
				  request.setAttribute("Schedulemarks", scheduleInfo);
				  request.setAttribute("status", "Here is the ExamSchedule Info");
				  path="./AddMarks.jsp";
				 }
			  else {
				  request.setAttribute("status", "There r No Schedules");
				  path="./AddMarks.jsp";
				}
			  }
		  catch (NullPointerException e) {
			  request.setAttribute("status", "In valid Data");
			  path="./AddMarks.jsp";
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		
		
		
		
		
		
		
		
		
	}

}
