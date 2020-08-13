package com.college.Action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.Mgrdelegate.RegisterMgrDelegate;





public class ChekUserAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path="";
		boolean flag=false;
		
		String target="";
		
		
		try{
			
				String userid=request.getParameter("userid");
				
				System.out.println("in action cklasss..........userid....."+userid);
				
				target=request.getParameter("path");
				
				System.out.println("in action class////////////"+target);
				flag=new RegisterMgrDelegate().checkAvailability(userid);
				
				System.out.println("flag is========"+flag);
				
			
			
			
			
			
			if(flag==false){
				
				request.setAttribute("status", "Available");
				
				path=target;
				
			}
			else
			{
				
              request.setAttribute("status", "Already Exists");
				
              path=target;
				
			}
			}
		catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("status", "Invalid data&Plz Enter Proper date");
			
			path=target;
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}
