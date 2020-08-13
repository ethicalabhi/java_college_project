package com.college.ServiceI;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import com.college.FormBean.MailDTO;
import com.college.exception.ConnectionException;

public interface MailServiceI {
	// public boolean insertTime(String time,int employeeid) throws
	// ConnectionException,SQLException ;
	public Vector<MailDTO> mailContacts() throws ConnectionException,
			SQLException;

	public boolean sendMail(MailDTO mail) throws ConnectionException,
			SQLException;

	public Vector<MailDTO> viewMails(MailDTO mail) throws ConnectionException,
			SQLException;

	public boolean deleteMails(int msgid, String mailbox)
			throws ConnectionException, SQLException;

	public Vector<MailDTO> viewMail(int messageid, String mailbox)
			throws ConnectionException, SQLException;

	public boolean deleteTips(int msgid) throws ConnectionException,
			SQLException;

	public boolean insestAttachment(MailDTO mail) throws FileNotFoundException,
			ConnectionException;

	public Vector<MailDTO> viewMailAttachment(int messageid, String mailbox,
			String realpath) throws ConnectionException;
}