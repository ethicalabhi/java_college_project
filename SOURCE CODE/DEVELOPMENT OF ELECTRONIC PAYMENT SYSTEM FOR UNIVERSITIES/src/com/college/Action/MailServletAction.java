package com.college.Action;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

public class MailServletAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2941564269120432640L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		MailDTO mailDTO = new MailDTO();
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "localhost");
			props.put("mail.smtp.port", "25");
			Session session1 = Session.getDefaultInstance(props, null);
			String username = (String) request.getSession()
					.getAttribute("user");
			String sender = username + "@MIME.com";
			mailDTO.setReceiver(request.getParameter("receiver"));
			mailDTO.setSubject(request.getParameter("subject"));
			mailDTO.setMessage(request.getParameter("message"));
			//mailDTO.setAttachmentfile(request.getParameter("attachmentfile"));

			Message message = new MimeMessage(session1);

			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse(request.getParameter("receiver"), false));
			message.setSubject(request.getParameter("subject"));
			message.setContent(request.getParameter("message"), "text/plain");
			message.setText(request.getParameter("message"));

			/*BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(request.getParameter("message"));*/

			Multipart multipart = new MimeMultipart();

			// add the message body to the mime message
			//multipart.addBodyPart(messageBodyPart);
			String attachments=request.getParameter("attachmentfile");
			
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			// use a JAF FileDataSource as it does MIME type detection
			DataSource source = new FileDataSource(attachments);
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			attachmentBodyPart.setFileName(attachments);
			// add the attachment
			multipart.addBodyPart(attachmentBodyPart);
	
			// add any file attachments to the message
			//addAtachments(attachments, multipart);
			// Put all message parts in the message
			message.setContent(multipart);

			Transport.send(message);
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
		rd = request.getRequestDispatcher(UtilConstants._SEND_MAIL);
		rd.forward(request, response);
	}

	protected void addAtachments(String[] attachments, Multipart multipart)
			throws MessagingException, AddressException {
		for (int i = 0; i <= attachments.length - 1; i++) {
			String filename = attachments[i];
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			// use a JAF FileDataSource as it does MIME type detection
			DataSource source = new FileDataSource(filename);
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			attachmentBodyPart.setFileName(filename);
			// add the attachment
			multipart.addBodyPart(attachmentBodyPart);
		}
	}
}
