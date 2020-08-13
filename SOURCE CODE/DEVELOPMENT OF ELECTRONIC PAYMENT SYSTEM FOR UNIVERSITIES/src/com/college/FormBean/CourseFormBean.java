package com.college.FormBean;

import java.io.Serializable;

public class CourseFormBean  implements Serializable{
	
	
	private String useri[]=new String[6];
	private String coursei[];
	
	
	private String subi[];
	private String exami[];
	private String smark[];
	private String passpercentage[];
	private String average[];
	private String firstname;
	private String bdescription;
	private String ddescription;

	private String branchname;
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	private String departmentname;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String[] getPasspercentage() {
		return passpercentage;
	}
	public void setPasspercentage(String[] passpercentage) {
		this.passpercentage = passpercentage;
	}
	public String[] getAverage() {
		return average;
	}
	public void setAverage(String[] average) {
		this.average = average;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	 
	
	
	
	
	
	public String[] getCoursei() {
		return coursei;
	}
	public void setCoursei(String[] coursei) {
		this.coursei = coursei;
	}
	public String[] getSubi() {
		return subi;
	}
	public void setSubi(String[] subi) {
		this.subi = subi;
	}
	public String[] getExami() {
		return exami;
	}
	public void setExami(String[] exami) {
		this.exami = exami;
	}
	public String[] getSmark() {
		return smark;
	}
	public void setSmark(String[] smark) {
		this.smark = smark;
	}
	public String[] getUseri() {
		return useri;
	}
	public void setUseri(String[] useri) {
		this.useri = useri;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int courseid,subid,examid,tmarks,smarks,passpercentages;
	private int averages;
	private String acctno;
	private String toacctno;
	public String getToacctno() {
		return toacctno;
	}
	public void setToacctno(String toacctno) {
		this.toacctno = toacctno;
	}
	public String getAcctno() {
		return acctno;
	}
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}
	private String cname,bname,sname, ename,etype;
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	private double fee,tamount;
	public double getTamount() {
		return tamount;
	}
	public void setTamount(double tamount) {
		this.tamount = tamount;
	}
	private double titalfee,paidfee,duefee;
	public double getPaidfee() {
		return paidfee;
	}
	public void setPaidfee(double paidfee) {
		this.paidfee = paidfee;
	}
	public double getDuefee() {
		return duefee;
	}
	public void setDuefee(double duefee) {
		this.duefee = duefee;
	}
	public double getTitalfee() {
		return titalfee;
	}
	public void setTitalfee(double titalfee) {
		this.titalfee = titalfee;
	}
	private String duration;
	private String subject;
	private String paidate;
	
	
  
public String getPaidate() {
		return paidate;
	}
	public void setPaidate(String paidate) {
		this.paidate = paidate;
	}
private String cdescription,sdescription;
  private String cdate,sdate, edate,rdate;
  private String cstatus;
  private String cfaculty;
  private String cstudent;
  private String login;
  private String material;
  private String mdate;
  
  private String mname;
  private String fname;
  private String lname;
  private int userid;
  private String email;
  private String fax;
  private double cf;
	public double getCf() {
		return cf;
	}

	public void setCf(double cf) {
		this.cf = cf;
	}

	public double getUf() {
		return uf;
	}

	public void setUf(double uf) {
		this.uf = uf;
	}

	public double getLf() {
		return lf;
	}

	public void setLf(double lf) {
		this.lf = lf;
	}

	public double getMf() {
		return mf;
	}

	public void setMf(double mf) {
		this.mf = mf;
	}

	public double getTf() {
		return tf;
	}

	public void setTf(double tf) {
		this.tf = tf;
	}

	public double getHf() {
		return hf;
	}

	public void setHf(double hf) {
		this.hf = hf;
	}
	private double ef;
	private double pf;
	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getEf() {
		return ef;
	}

	public void setEf(double ef) {
		this.ef = ef;
	}

	public double getAf() {
		return af;
	}

	public void setAf(double af) {
		this.af = af;
	}
	private int fid;
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}
	private double af;
	private double uf;
	private double lf;
	private double mf;
	private double tf;
	private double hf;
	private int COURSEIDREF;
	public int getCOURSEIDREF() {
		return COURSEIDREF;
	}

	public void setCOURSEIDREF(int cOURSEIDREF) {
		COURSEIDREF = cOURSEIDREF;
	}

	public String getLdate() {
		return ldate;
	}

	public void setLdate(String ldate) {
		this.ldate = ldate;
	}

	private String ldate;
  private int mid;
  
  private int bid;
  private int did;
  
  public String getBdescription() {
	return bdescription;
}
public void setBdescription(String bdescription) {
	this.bdescription = bdescription;
}
public String getDdescription() {
	return ddescription;
}
public void setDdescription(String ddescription) {
	this.ddescription = ddescription;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
private String qcode;
  private String qdescription;
  private String qpaper;
  private int subjid;
  private String qdate;
  private int qid;
  
	public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCstatus() {
		return cstatus;
	}
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}
	public String getCfaculty() {
		return cfaculty;
	}
	public void setCfaculty(String cfaculty) {
		this.cfaculty = cfaculty;
	}
	public String getCstudent() {
		return cstudent;
	}
	public void setCstudent(String cstudent) {
		this.cstudent = cstudent;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getQcode() {
		return qcode;
	}
	public void setQcode(String qcode) {
		this.qcode = qcode;
	}
	public String getQdescription() {
		return qdescription;
	}
	public void setQdescription(String qdescription) {
		this.qdescription = qdescription;
	}
	public String getQpaper() {
		return qpaper;
	}
	public void setQpaper(String qpaper) {
		this.qpaper = qpaper;
	}
	public int getSubjid() {
		return subjid;
	}
	public void setSubjid(int subjid) {
		this.subjid = subjid;
	}
	public String getQdate() {
		return qdate;
	}
	public void setQdate(String qdate) {
		this.qdate = qdate;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSdescription() {
		return sdescription;
	}
	public void setSdescription(String sdescription) {
		this.sdescription = sdescription;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public int getExamid() {
		return examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
	public int getTmarks() {
		return tmarks;
	}
	public void setTmarks(int tmarks) {
		this.tmarks = tmarks;
	}
	public int getSmarks() {
		return smarks;
	}
	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getPasspercentages() {
		return passpercentages;
	}
	public void setPasspercentages(int passpercentages) {
		this.passpercentages = passpercentages;
	}
	
	public int getAverages() {
		return averages;
	}
	public void setAverages(int averages) {
		this.averages = averages;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
