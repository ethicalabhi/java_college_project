package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.CourseMgrDelegate;


public class GetSubjectAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path="";
        Vector<CourseFormBean> courseinfo=null;
        
        String page=request.getParameter("page");

	  try{
		    int cid=Integer.parseInt(request.getParameter("cid"));
		    
		  courseinfo= new CourseMgrDelegate().viewSubjectAt(cid);	
		  
		  System.out.println("in Action class vcb..........."+courseinfo);
		 
		  if(!courseinfo.isEmpty()){
			  
			  request.setAttribute("subjectAt", courseinfo);
			  request.setAttribute("cid", cid);
			  
			  request.setAttribute("status", "Enjoy The Subjects Info");
			  path=page;
			 }
		  else {
			  request.setAttribute("status", "Subject Info is Not Available");
			  path=page;
			  }
		   }
	  catch (NullPointerException e) {
		  request.setAttribute("status", "Invalid Entries");
		  path=page;
		e.printStackTrace();
		
	}
	 RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		

	}

}
