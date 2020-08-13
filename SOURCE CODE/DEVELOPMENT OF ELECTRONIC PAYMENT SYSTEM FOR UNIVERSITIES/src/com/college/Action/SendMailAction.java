package com.college.Action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * The SendMailAction servlet class implements for to Send Mails.
 * 
 */
public class SendMailAction extends HttpServlet {

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
		RequestDispatcher rd = null;
		boolean flag = false, flag1 = false;
		String path = "";
		MailDTO mail = new MailDTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(mail, map);
			if ((request.getParameter("image[image_1]")) != null) {
				if (!request.getParameter("image[image_1]").equals("")) {
					String ch[] = request.getParameterValues("ch");
					flag = new MailDelegate().sendMail(mail);
					for (int j = 1; j <= ch.length; j++) {
						String filaname = request.getParameter("image[image_"
								+ j + "]");

						mail.setFilepath(filaname);
						try {
							flag1 = new MailDelegate().insestAttachment(mail);
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}
			}
			if (flag) {
				request.setAttribute("status", "mail sended successfully...");
				path = UtilConstants._SEND_MAILS;
			} else {
				request.setAttribute("status", UtilConstants._SEND_MAIL_FAIL);
				path = UtilConstants._SEND_MAILS;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._SEND_MAILS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
