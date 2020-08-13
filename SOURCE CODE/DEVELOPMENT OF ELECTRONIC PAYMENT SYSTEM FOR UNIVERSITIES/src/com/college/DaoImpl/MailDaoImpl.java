package com.college.DaoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.college.FormBean.MailDTO;
import com.college.db.*;
import com.college.DaoI.MailDaoI;
import com.college.DaoImpl.MailDaoImpl;
import com.college.exception.ConnectionException;
import com.college.ServiceI.MailServiceI;
import com.college.Mgrdelegate.MailDelegate;
import com.college.Util.UtilConstants;
import com.college.Util.DateWrapper;

public class MailDaoImpl implements MailDaoI {
	Connection con;
	PreparedStatement pstmt, pstmt1;
	Statement stmt;
	ResultSet rs, rs1;
	boolean flag = false;

	/**
	 * The closeConnection method of the AttendanceDaoImpl Class. <br>
	 * 
	 * This method is called when to take Employee InTime.
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 */
	public void closeConnection() throws ConnectionException {
		try {
			if (pstmt != null)
				pstmt.close();
			if (pstmt1 != null)
				pstmt.close();
			if (stmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException ex) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		}
	}

	/**
	 * The deleteMails method of the MailDaoImpl Class.
	 * 
	 * This method is called when to deletemails details.
	 * 
	 * @param Passing
	 *            msgid as a one parameter.
	 * @param Passing
	 *            mailbox as a one parameter.
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean deleteMails(int msgid, String mailbox)
			throws ConnectionException {
		boolean flag = false;

		try {
			con = ConnectionFactory.getConnection();
			if (mailbox.equals("outbox"))
				pstmt = con.prepareStatement(SqlConstants._DELETE_MAIL);
			else
				pstmt = con.prepareStatement(SqlConstants._DELETE_MAIL1);
			pstmt.setInt(1, msgid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		}

		finally {
			closeConnection();
		}
		return flag;
	}

	public boolean deleteTips(int messageidx) throws ConnectionException,
			SQLException {
		boolean flag = false;

		try {
			con = ConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._TIPS_SUGGESTION);
			pstmt.setInt(1, messageidx);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The mailContacts method of the MailDaoImpl Class. <br>
	 * 
	 * This method is called when to view mailContacts.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with mail details depends upon operations.
	 */
	public Vector<MailDTO> mailContacts() throws ConnectionException,
			SQLException {
		Vector<MailDTO> vmail = new Vector<MailDTO>();
		MailDTO mail = null;
		try {
			con = ConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._MAIL_CONTACTS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mail = new MailDTO();
				mail.setEmpid(rs.getInt(1));
				mail.setMailid(rs.getString(2));
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				vmail.add(mail);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		} finally {
			closeConnection();
		}
		return vmail;
	}

	/**
	 * The viewMails method of the MailDaoImpl Class. <br>
	 * 
	 * This method is called when to view mails.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with mail details depends upon operations.
	 */
	public Vector<MailDTO> viewMails(MailDTO MailDTO)
			throws ConnectionException {
		Vector<MailDTO> vmail = new Vector<MailDTO>();
		int empid = MailDTO.getEmpid();
		System.out.println(empid);
		String mailbox = MailDTO.getRequesttype();
		MailDTO mail = null;
		try {
			con = ConnectionFactory.getConnection();
			if (mailbox.equals("outbox"))
				pstmt = con.prepareStatement(SqlConstants._VIEW_OUT_MAILS);
			else
				pstmt = con.prepareStatement(SqlConstants._VIEW_IN_MAILS);
			pstmt.setInt(1, empid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mail = new MailDTO();
				mail.setMessageid(rs.getInt(1));
				mail.setFrommailid(rs.getInt(2));
				mail.setTomailid(rs.getInt(3));
				// pstmt = con.prepareStatement(SqlConstants._VIEW_MAILID);
				// pstmt.setInt(1, rs.getInt(3));
				// System.out.println(rs.getInt(3));
				// rs1 = pstmt.executeQuery();
				// if (rs1.next()) {
				// mail.setEmploginid(rs1.getString(1));
				// }
				if (mailbox.equals("outbox"))
					pstmt1 = con
							.prepareStatement("select count(*) from OUTBOX_MAIL_ATTACHMENT where ATTACHMENTMAILID="
									+ rs.getInt(1));
				else
					pstmt1 = con
							.prepareStatement("select count(*) from INBOX_MAIL_ATTACHMENT where ATTACHMENTMAILID="
									+ rs.getInt(1));

				ResultSet resultSet = pstmt1.executeQuery();

				mail.setMailsub(rs.getString(4));
				mail.setMailbody(rs.getString(5));
				mail.setMaildate(DateWrapper.parseDate(rs.getDate(6)));
				mail.setMailbox(mailbox);
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1));
					mail.setAttachcount(resultSet.getInt(1));
				}
				vmail.add(mail);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				System.out.println(se);
			}
		} finally {
			closeConnection();
		}

		return vmail;
	}

	/**
	 * The sendMail method of the MailDaoImpl Class.
	 * 
	 * This method is called when to sensMails details.
	 * 
	 * @param Passing
	 *            Mail bean as a one parameter.
	 * @throws ConnectionException
	 *             if an error occurred
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 * @throws ConnectionException
	 */
	public boolean sendMail(MailDTO mail) throws ConnectionException,
			SQLException {
		boolean flag = false;
		try {
			con = ConnectionFactory.getConnection();
			int frommailid = mail.getFrommailid();
			int empid = mail.getEmpid();
			System.out.println(empid);
			System.out.println(frommailid);
			String mailsub = mail.getMailsub();
			String mailbody = mail.getMailbody();
			pstmt = con.prepareStatement(SqlConstants._SEND_MAIL);
			pstmt1 = con.prepareStatement(SqlConstants._SEND_MAIL1);
			pstmt.setInt(1, frommailid);
			pstmt1.setInt(1, frommailid);
			pstmt.setInt(2, empid);
			pstmt1.setInt(2, empid);
			pstmt.setString(3, mailsub);
			pstmt1.setString(3, mailsub);
			pstmt.setString(4, mailbody);
			pstmt1.setString(4, mailbody);

			int i = pstmt.executeUpdate();
			int j = pstmt1.executeUpdate();
			if (i > 0 && j > 0) {
				flag = true;
				con.commit();
			} else
				flag = false;
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		}

		finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The viewMail method of the MailDaoImpl Class. <br>
	 * 
	 * This method is called when to view mails.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with maildetails depends upon operations.
	 */
	public Vector<MailDTO> viewMail(int msgid, String mailbox)
			throws ConnectionException {
		Vector<MailDTO> vmail = new Vector<MailDTO>();
		System.out.println(msgid);
		System.out.println(mailbox);
		MailDTO mail = null;
		try {
			con = ConnectionFactory.getConnection();
			if (mailbox.equals("outbox"))
				pstmt = con.prepareStatement(SqlConstants._VIEW_OUT_MAIL);
			else
				pstmt = con.prepareStatement(SqlConstants._VIEW_IN_MAIL);
			pstmt.setInt(1, msgid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mail = new MailDTO();
				mail.setMessageid(rs.getInt(1));
				mail.setFrommailid(rs.getInt(2));
				mail.setTomailid(rs.getInt(3));
				pstmt = con.prepareStatement(SqlConstants._VIEW_MAILID);
				pstmt.setInt(1, rs.getInt(3));
				rs1 = pstmt.executeQuery();
				if (rs1.next()) {
					mail.setEmploginid(rs1.getString(1));
				}
				mail.setMailsub(rs.getString(4));
				mail.setMailbody(rs.getString(5));
				System.out.println(rs.getString(5));
				mail.setMaildate(DateWrapper.parseDate(rs.getDate(6)));
				vmail.add(mail);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		} finally {
			closeConnection();
		}
		return vmail;
	}

	public boolean insestAttachment(MailDTO mail) throws ConnectionException,
			FileNotFoundException {
		boolean flag = false;
		String filepath = mail.getFilepath();
		String fileType = "";
		String fullpath = filepath;
		String[] extension = fullpath.split("\\.");
		int i;
		for (i = 0; i < extension.length; i++) {
			System.out.println(extension[i]);
			fileType = extension[i];
		}

		File file = new File(mail.getFilepath());
		File file1 = new File(mail.getFilepath());
		FileInputStream fisfile = new FileInputStream(file);
		FileInputStream fisfile1 = new FileInputStream(file1);
		try {
			con = ConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._INBOX_ATTACHMENT_FILE);
			pstmt1 = con.prepareStatement(SqlConstants._OUTBOX_ATTACHMENT_FILE);

			pstmt.setBinaryStream(1, fisfile, (int) file.length());
			pstmt.setString(2, fileType);
			pstmt1.setBinaryStream(1, fisfile1, (int) file1.length());
			pstmt1.setString(2, fileType);

			int j = pstmt.executeUpdate();
			int l = pstmt1.executeUpdate();
			if (j > 0 && l > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical prablum Occering please try later");
		} finally {
			closeConnection();
		}
		return flag;
	}

	public Vector<MailDTO> viewMailAttachment(int msgid, String mailbox,
			String realpath) throws ConnectionException {
		Vector<MailDTO> vmail = new Vector<MailDTO>();

		MailDTO mail = null;
		String path = "";
		try {
			con = ConnectionFactory.getConnection();
			if (mailbox.equals("outbox"))
				pstmt = con
						.prepareStatement("select * from OUTBOX_MAIL_ATTACHMENT where ATTACHMENTMAILID=?");
			else
				pstmt = con
						.prepareStatement("select * from INBOX_MAIL_ATTACHMENT where ATTACHMENTMAILID=?");
			pstmt.setInt(1, msgid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				path = "";
				path = realpath;
				mail = new MailDTO();
				mail.setMessageid(rs.getInt(1));
				mail.setAttachmentmailid(rs.getInt(2));
				Blob b = rs.getBlob(3);
				byte b1[] = b.getBytes(1, (int) b.length());
				path = path + "/" + rs.getInt(1) + "." + rs.getString(4);
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				System.out.println(path);
				mail.setAttachmentfile(path);
				vmail.add(mail);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		} finally {
			closeConnection();
		}
		return vmail;
	}
}
