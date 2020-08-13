package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.college.DaoImpl.ExamDaoImpl;
import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.CourseMgrDelegate;

public class AddMarksAction extends HttpServlet {

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

		CourseFormBean cb=new CourseFormBean();
		   boolean flag=false;
		
		String subjid[] = request.getParameterValues("subjid");
		String examid[] = request.getParameterValues("examid");
		String userid[] = request.getParameterValues("userid");
		String smarks[] = request.getParameterValues("smarks");
		String passpercentages[] = request.getParameterValues("passpercentages");
		String averages[] = request.getParameterValues("averages");
		
		
		for(int i=0;i<subjid.length;i++)
		{
			cb.setSubjid(Integer.parseInt(subjid[i]));
			cb.setExamid(Integer.parseInt(examid[i]));
			cb.setUserid(Integer.parseInt(userid[i]));
			cb.setSmarks(Integer.parseInt(smarks[i]));
			cb.setPasspercentages(Integer.parseInt(passpercentages[i]));
			cb.setAverages(Integer.parseInt(averages[i]));
			   flag= new ExamDaoImpl().addMarks(cb);
			
		}
		

	
		
		
		System.out.println("subject id======>"+cb.getSubjid());
		System.out.println("cb.getExamid()=========>"+cb.getExamid());
		System.out.println("cb.getUserid()========>"+cb.getUserid());
		System.out.println("cb.getSmarks()=========>"+cb.getSmarks());
		System.out.println("cb.getSubjid()==========>"+cb.getSubjid());
		System.out.println("cb.getPasspercentages()==========>"+cb.getPasspercentages());
		System.out.println("cb.getAverages()==========>"+cb.getAverages());
		
		
		
		
	/*	Map map=request.getParameterMap();
	try {
		//BeanUtils.populate(cb, map);
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
		
	}*/
	String path="";
        
      
         try{
        	 
        	  HttpSession session=request.getSession();
        	  
        	String login=(String) session.getAttribute("loginuser");
        	    
        	   cb.setLogin(login);
		  
		    
		 
		  
		       
		       
		       
		       
		       
		       
		       
		       
		       if(flag){
			   request.setAttribute("status", "Marks Introduced Successfully");
			  path="/GetStudentCourseAction?userid="+cb.getUserid();
			 }
		  else{
			  request.setAttribute("status", "Introduction of Marks is Failed");
			  path="/GetStudentCourseAction?userid="+cb.getUserid();
			  }}
	  catch (Exception e) {
		request.setAttribute("status", "Invalid Entries");
		  path="./userhome.jsp";
		  e.printStackTrace();
		  }
	RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		
		
	}

}
