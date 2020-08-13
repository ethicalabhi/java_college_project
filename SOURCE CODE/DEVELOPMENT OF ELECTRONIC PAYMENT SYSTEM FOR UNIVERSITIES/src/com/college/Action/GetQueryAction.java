package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.FormBean.QueryFormBean;
import com.college.Mgrdelegate.QueryMgrDelegate;


public class GetQueryAction extends HttpServlet {

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
	        Vector<QueryFormBean> getsolution=null;

		  try{
			  
			  int qid=Integer.parseInt(request.getParameter("qid"));
			  String login=request.getParameter("from");
			  
			  getsolution= new QueryMgrDelegate().getQueriesAt(qid);
			
			  System.out.println("in Action class vcb..........."+getsolution);
			  if(!getsolution.isEmpty()){
				  request.setAttribute("QueryAt", getsolution);
				  request.setAttribute("status", "Here is the Query");
				  path="./SendSolution.jsp";
				 }
			  else {
				  request.setAttribute("status", "Sorry u Query is till Now");
				  path="./SendSolution.jsp";
			}
			}
		  catch (NullPointerException e) {
			  request.setAttribute("status", "Invalid Data");
			  path="./SendSolution.jsp";
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
	}

}
