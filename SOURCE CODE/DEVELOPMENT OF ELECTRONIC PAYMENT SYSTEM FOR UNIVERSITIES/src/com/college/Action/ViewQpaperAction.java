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


public class ViewQpaperAction extends HttpServlet {

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

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		Vector<CourseFormBean> vcb=null;
		
		 String path="";
	        boolean flag=false;

		  try{
			  
			 
			  String path1=request.getRealPath("/qpapers");
			 
			
			  
			 vcb= new CourseMgrDelegate().viewAllQpaper(path1);				  								 
			  
			 
			
			  if(!vcb.isEmpty()){
				  request.setAttribute("PaperInfo", vcb);
				  request.setAttribute("status","Here is Qpaper Info" );
				  path="./ViewQPaperInfo.jsp";
				 }
			  else {
				  request.setAttribute("status","There R no Q parers Available Present " );
				  path="./userhome.jsp";
				}
			  
	   }
		  catch (Exception e) {
			  request.setAttribute("status","Invalid Data" );
			  path="./userhome.jsp";
			e.printStackTrace();
			
		}
	     RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
			
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
