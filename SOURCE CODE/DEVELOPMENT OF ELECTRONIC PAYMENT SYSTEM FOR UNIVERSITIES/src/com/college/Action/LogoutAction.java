package com.college.Action;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.college.Mgrdelegate.SecurityMgrDelegate;


public class LogoutAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path="";

		HttpSession session=request.getSession();
		System.out.println("in logout user="+session.getAttribute("loginuser"));
		try{
		new SecurityMgrDelegate().loginaudit((String)session.getAttribute("loginuser"));
		
		
		session.setAttribute("loginuser",null);
		session.setAttribute("role", null);
		session.invalidate();
		
		request.setAttribute("status", "Logout Successfully");
		path="./LoginForm.jsp";
		}
		catch (Exception e) {
			e.printStackTrace();
		request.setAttribute("status", "Logout Failed");
		path="./userhome.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
					rd.forward(request, response);	
	}

}
