package com.college.Action;

import java.io.IOException;
import java.util.Vector;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.college.DaoImpl.CourseDaoImpl;
import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.RegisterMgrDelegate;





public class ChekBalAction extends HttpServlet {

	
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
		HttpSession session=request.getSession();
		CourseFormBean cb=new CourseFormBean();
		
		try{
			
	           String login=(String)session.getAttribute("loginuser");
	            Vector<CourseFormBean> feeinfo=null;
				double tamount=Double.parseDouble(request.getParameter("bal"));
                 String userid=request.getParameter("userid");
				
				System.out.println("in action cklasss..........userid....."+userid);
				System.out.println("in action cklasss..........userid....."+tamount);
				
                target=request.getParameter("path");
				request.setAttribute("tamount", tamount);
				System.out.println("in action class////////////"+target);
				double bal=new RegisterMgrDelegate().checkbalAvailability(userid);
				 feeinfo= new CourseDaoImpl().viewStudentFee(login);
				System.out.println("bal is========"+bal);
			
			
			
			
			
			if(bal>tamount){
				
				 request.setAttribute("sfeeinfo", feeinfo);
				request.setAttribute("status", "Balance is Sufficient");
				System.out.println("Balance is Sufficient");
				 path="./PayFee.jsp";
				
			}
			else
			{
				request.setAttribute("sfeeinfo", feeinfo);
				
				  
              request.setAttribute("status", "Balance are not Sufficient.. plz Deposite the money.");
              System.out.println("Balance are not Sufficient.. plz Deposite the money");
              path="./PayFee.jsp";
				
			}
			
			
			}
		catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("status", "Invalid data&Plz Enter Proper date");
			
			 path="./PayFee.jsp";
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}
