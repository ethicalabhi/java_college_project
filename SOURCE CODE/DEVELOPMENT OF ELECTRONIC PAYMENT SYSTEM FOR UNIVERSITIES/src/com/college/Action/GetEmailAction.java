package com.college.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
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

public class GetEmailAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		ArrayList<MailDTO> ar = null;
		String status = "";
		String username = (String) request.getSession().getAttribute("user");
		try {
			File directory = new File("c:\\inetpub\\mailroot\\drop\\"
					+ username);
			File[] files = directory.listFiles();
			ar = display(files);
			request.setAttribute("email", ar);
			request.setAttribute("status", UtilConstants._MAIL_SEND_SUCCESS);
		} catch (Exception e) {
			request.setAttribute("status", UtilConstants._MAIL_SEND_FAIL);
			e.printStackTrace();
		}
		rd = request.getRequestDispatcher(UtilConstants._SHOW_INBOX);
		rd.forward(request, response);
	}

	public static ArrayList<MailDTO> display(File[] files) throws Exception {
		ArrayList<MailDTO> ar = new ArrayList<MailDTO>();
		Properties props = System.getProperties();
		props.put("mail.host", "localhost");
		props.put("mail.transport.protocol", "smtp");
		Session mailSession = Session.getDefaultInstance(props, null);
		for (int index = 0; index < files.length; index++) {
			File emlFile = new File(files[index].toString());
			InputStream source = new FileInputStream(emlFile);
			MimeMessage message = new MimeMessage(mailSession, source);
			MailDTO md = new MailDTO();
			md.setSubject(message.getSubject());
			md.setFrom(message.getFrom()[0]);
			md.setContent((message.getContent()));
			ar.add(md);
		}
		return ar;
	}
}
