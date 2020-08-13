package com.college.Action;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.college.DaoImpl.SecurityDaoImpl;
import com.college.FormBean.*;
import com.college.Mgrdelegate.SecurityMgrDelegate;

public class LoginAction extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		   String role="";
		
		String target ="";
		
		HttpSession session=request.getSession();
		
		LoginForm lf=new LoginForm();
		
		String username = request.getParameter("username");
		lf.setUsername(username);
		String pass=request.getParameter("password");
		lf.setPassword(pass);
		
		Vector<LoginForm> vpro = new Vector<LoginForm>();
		
		try{
			
			vpro = new SecurityDaoImpl().loginCheck(lf);
			System.out.println(vpro.size());
			Iterator it = vpro.listIterator();
			while (it.hasNext()) {
				lf = (LoginForm) it.next();
			}
			int userid=lf.getUserid();
			System.out.println(userid);
			System.out.println(lf.getLogintype());
			if (lf.getLogintype().equalsIgnoreCase("admin"))
			{
				
				request.setAttribute("status","Welcome "+ username);
				
				session.setAttribute("userid", userid);
				target = "./userhome.jsp";
				
				session.setAttribute("loginuser", username );
				session.setAttribute("role", lf.getLogintype());
				session.setAttribute("password",pass);
				
			}
			else if (lf.getLogintype().equalsIgnoreCase("manager"))
			{
				session.setAttribute("userid", userid);
                request.setAttribute("status","Welcome " + username );
				 target = "./userhome.jsp";
				session.setAttribute("loginuser", username );
				session.setAttribute("role", lf.getLogintype());
				session.setAttribute("password",pass);
				
			}
			else if (lf.getLogintype().equalsIgnoreCase("faculty"))
			{
				session.setAttribute("userid", userid);
                request.setAttribute("status","Welcome " + username );
				 target = "./userhome.jsp";
				session.setAttribute("loginuser", username );
				session.setAttribute("role", lf.getLogintype());
				session.setAttribute("password",pass);
				
			}
			else if (lf.getLogintype().equalsIgnoreCase("student"))
			{
				session.setAttribute("userid", userid);
                request.setAttribute("status","Welcome " + username );
				 target = "./userhome.jsp";
				session.setAttribute("loginuser", username );
				session.setAttribute("role", lf.getLogintype());
				session.setAttribute("password",pass);
				
			}
			else
			{
				request.setAttribute("status", "Invalid username&password");
				target = "./LoginForm.jsp";
			}
		}catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
				
	  }

}
