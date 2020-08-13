package com.college.FormBean;

import java.io.Serializable;



public class FeedBackFormBean  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String feedback;
	
	private String cname,mobile;
	private String fdate;
	private String email;
	
	
	
	private int fid;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	


	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	
	
	
}
