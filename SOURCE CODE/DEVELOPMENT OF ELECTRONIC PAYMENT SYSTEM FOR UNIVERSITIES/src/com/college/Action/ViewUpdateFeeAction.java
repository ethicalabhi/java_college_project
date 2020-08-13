package com.college.Action;

import java.io.IOException;


import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.CourseMgrDelegate;




public class ViewUpdateFeeAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);
	}
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		        String path="";
		        Vector<CourseFormBean> feeat=null;

			  try{
				  int cid=Integer.parseInt(request.getParameter("fid"));
				  
				  
				  feeat= new CourseMgrDelegate().viewFeeAt(cid);	
				 
				  System.out.println("in View Course Update Action class vcb..........."+feeat);
				  if(!feeat.isEmpty()){
					  request.setAttribute("feeat", feeat);
					  request.setAttribute("status", "Here is the Fee Info");
					  path="./UpdateFee.jsp";
					 }
				  else {
					  request.setAttribute("status", "Fee Info is not Available");
					  path="./UpdateFee.jsp";
					}
				  }
			  catch (NullPointerException e) {
				  request.setAttribute("status", "Invalid Enteries");
				  path="./UpdateFee.jsp";
				e.printStackTrace();
				}
			RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
		
	
	}

}
