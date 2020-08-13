package com.college.ServiceImpl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import com.college.FormBean.MailDTO;
import com.college.FormBean.ProfileTO;
import com.college.DaoI.MailDaoI;
import com.college.DaoImpl.MailDaoImpl;
import com.college.exception.ConnectionException;
import com.college.ServiceI.MailServiceI;
import com.college.Mgrdelegate.MailDelegate;
import com.college.Util.UtilConstants;

public class MailServiceImpl implements MailServiceI {

	boolean flag = false;
	Vector<ProfileTO> vpro = null;
	MailDaoI mdaoi = new MailDaoImpl();

	public Vector<MailDTO> mailContacts() throws ConnectionException,
			SQLException {
		return mdaoi.mailContacts();
	}

	public boolean sendMail(MailDTO mail) throws ConnectionException,
			SQLException {
		flag = mdaoi.sendMail(mail);
		return flag;
	}

	public Vector<MailDTO> viewMails(MailDTO mail) throws ConnectionException,
			SQLException {
		return mdaoi.viewMails(mail);
	}

	public boolean deleteMails(int msgid, String mailbox)
			throws ConnectionException, SQLException {
		flag = mdaoi.deleteMails(msgid, mailbox);
		return flag;
	}

	public Vector<MailDTO> viewMail(int messageid, String mailbox)
			throws ConnectionException, SQLException {
		return mdaoi.viewMail(messageid, mailbox);
	}

	public boolean deleteTips(int msgid) throws ConnectionException,
			SQLException {
		flag = mdaoi.deleteTips(msgid);
		return flag;
	}

	public boolean insestAttachment(MailDTO mail) throws FileNotFoundException,
			ConnectionException {
		// TODO Auto-generated method stub
		return mdaoi.insestAttachment(mail);
	}

	public Vector<MailDTO> viewMailAttachment(int messageid, String mailbox,
			String realpath) throws ConnectionException {
		// TODO Auto-generated method stub
		return mdaoi.viewMailAttachment(messageid, mailbox, realpath);
	}
}
