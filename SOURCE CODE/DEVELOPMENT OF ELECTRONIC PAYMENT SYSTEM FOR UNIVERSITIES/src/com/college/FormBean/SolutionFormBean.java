package com.college.FormBean;

import java.io.Serializable;



public class SolutionFormBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String from,cname;
	private String to;
	private String query;
	private String sdate;
	private String rdate;
private String	solution;
private int sid;
private int qid;
private int quid;
private int userid;
private String status;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getQuid() {
	return quid;
}
public void setQuid(int quid) {
	this.quid = quid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getQid() {
	return qid;
}
public void setQid(int qid) {
	this.qid = qid;
}
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}
public String getSdate() {
	return sdate;
}
public void setSdate(String sdate) {
	this.sdate = sdate;
}
public String getRdate() {
	return rdate;
}
public void setRdate(String rdate) {
	this.rdate = rdate;
}
public String getSolution() {
	return solution;
}
public void setSolution(String solution) {
	this.solution = solution;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}

}
