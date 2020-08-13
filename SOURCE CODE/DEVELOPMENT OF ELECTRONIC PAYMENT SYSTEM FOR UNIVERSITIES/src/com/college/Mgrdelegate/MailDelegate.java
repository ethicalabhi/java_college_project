package com.college.Mgrdelegate;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import com.college.FormBean.MailDTO;
import com.college.FormBean.ProfileTO;
import com.college.DaoI.MailDaoI;
import com.college.DaoImpl.MailDaoImpl;
import com.college.exception.ConnectionException;
import com.college.ServiceI.MailServiceI;
import com.college.ServiceImpl.MailServiceImpl;
import com.college.Mgrdelegate.MailDelegate;
import com.college.Util.UtilConstants;


public class MailDelegate {
	MailServiceI usi = new MailServiceImpl();
	boolean flag = false;
	Vector<ProfileTO> vpro = null;

	public Vector<MailDTO> mailContacts() throws ConnectionException,
			SQLException {
		return usi.mailContacts();
	}

	public boolean sendMail(MailDTO mail) throws ConnectionException,
			SQLException {
		flag = usi.sendMail(mail);
		return flag;
	}

	public Vector<MailDTO> viewMails(MailDTO mail) throws ConnectionException,
			SQLException {
		return usi.viewMails(mail);
	}

	public boolean deleteMails(int msgid, String mailbox)
			throws ConnectionException, SQLException {
		flag = usi.deleteMails(msgid, mailbox);
		return flag;
	}

	public Vector<MailDTO> viewMail(int messageid, String mailbox)
			throws ConnectionException, SQLException {
		return usi.viewMail(messageid, mailbox);
	}

	public boolean deleteTips(int messageid) throws ConnectionException,
			SQLException {
		return usi.deleteTips(messageid);
	}

	public boolean insestAttachment(MailDTO mail) throws FileNotFoundException,
			ConnectionException {
		// TODO Auto-generated method stub
		return usi.insestAttachment(mail);
	}

	public Vector<MailDTO> viewMailAttachment(int messageid, String mailbox, String realpath) throws ConnectionException {
		// TODO Auto-generated method stub
		return usi.viewMailAttachment(messageid, mailbox,realpath);
	}

}
