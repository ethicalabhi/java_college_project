package com.college.FormBean;

import javax.mail.Address;

public class MailDTO {

	private String subject;
	private Address from;
	private Object content;
	private String receiver;
	private String message;
	private String attachmentfile;
	private String mailid;
	private int empid;
	private String mailsub;
	private String mailbody;
	private int frommailid;
	private int messageid;
	private int tomailid;
	private int attachmentmailid;
	private String maildate;
	private String loginid;
	private String emploginid;
	private String requesttype;
	private String mailbox;
	private String filepath;
	private int attachcount;

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Address getFrom() {
		return from;
	}

	public void setFrom(Address from) {
		this.from = from;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getAttachmentfile() {
		return attachmentfile;
	}

	public void setAttachmentfile(String attachmentfile) {
		this.attachmentfile = attachmentfile;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getMailsub() {
		return mailsub;
	}

	public void setMailsub(String mailsub) {
		this.mailsub = mailsub;
	}

	public String getMailbody() {
		return mailbody;
	}

	public void setMailbody(String mailbody) {
		this.mailbody = mailbody;
	}

	public int getFrommailid() {
		return frommailid;
	}

	public void setFrommailid(int frommailid) {
		this.frommailid = frommailid;
	}

	public int getMessageid() {
		return messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	public int getTomailid() {
		return tomailid;
	}

	public void setTomailid(int tomailid) {
		this.tomailid = tomailid;
	}

	public String getMaildate() {
		return maildate;
	}

	public void setMaildate(String maildate) {
		this.maildate = maildate;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getEmploginid() {
		return emploginid;
	}

	public void setEmploginid(String emploginid) {
		this.emploginid = emploginid;
	}

	public String getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getAttachcount() {
		return attachcount;
	}

	public void setAttachcount(int attachcount) {
		this.attachcount = attachcount;
	}

	public int getAttachmentmailid() {
		return attachmentmailid;
	}

	public void setAttachmentmailid(int attachmentmailid) {
		this.attachmentmailid = attachmentmailid;
	}

}
