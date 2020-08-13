package com.college.Action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.college.FormBean.MailDTO;
import com.college.db.*;
import com.college.DaoI.MailDaoI;
import com.college.DaoImpl.MailDaoImpl;
import com.college.exception.ConnectionException;
import com.college.ServiceI.MailServiceI;
import com.college.Mgrdelegate.MailDelegate;
import com.college.Util.UtilConstants;
import com.college.Util.DateWrapper;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * The OutboxAction servlet class implements for to view out box message
 * details.
 * 
 */
public class OutboxAction extends HttpServlet {

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
		String path = "";
		HttpSession session = request.getSession();
		int empid = Integer.parseInt(request.getParameter("empid"));
		String mailbox = request.getParameter("requesttype");
		Vector<MailDTO> vmail = null;
		MailDTO mail = new MailDTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(mail, map);
			vmail = new MailDelegate().viewMails(mail);
			if (!vmail.isEmpty()) {
				request.setAttribute("mails", vmail);
				request.setAttribute("mailbox", mailbox);
				request.setAttribute("status", UtilConstants._MAILS);
				path = UtilConstants._MAIL_BOX;
			} else {
				request.setAttribute("status", UtilConstants._MAIL_BOX_FAIL);
				path = UtilConstants._MAIL_BOX;
			}
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._MAIL_BOX;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}