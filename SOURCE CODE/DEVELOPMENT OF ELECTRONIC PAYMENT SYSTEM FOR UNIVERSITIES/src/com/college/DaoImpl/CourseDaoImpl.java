package com.college.DaoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import com.college.DaoI.CourseDAOI;
import com.college.FormBean.CourseFormBean;
import com.college.FormBean.TransactionFormBean;
import com.college.FormBean.NotificationBean;
import com.college.Util.DateWrapper;
import com.college.db.ConnectionFactory;

public class CourseDaoImpl implements CourseDAOI {

	PreparedStatement pstmt, pstmt1, pstmt2, pstmt3, pstmt4, pstmt5, pstmt6,
			pstmt7, pstmt8, pstmt9, pstmt10;
	Statement stmt, stmt1;
	ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6;
	Connection con;

	public CourseDaoImpl() {
		con = ConnectionFactory.getConnection();
	}

	public boolean insertCourse(CourseFormBean cb) {
		boolean flag = true;
		int userid = 0;

		try {

			pstmt = con
					.prepareStatement("insert into course values((select nvl(max(courseid),110)+1 from course),?,?,?,?,sysdate,?)");

			pstmt.setString(1, cb.getCname());
			pstmt.setString(2, cb.getCdescription());
			pstmt.setDouble(3, cb.getFee());
			pstmt.setString(4, cb.getDuration());
			pstmt.setString(5, "available");

			int insert = pstmt.executeUpdate();

			if (insert > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public boolean insertCourseFee(CourseFormBean cb) {
		boolean flag = true;

		double ammount =  cb.getTamount();
		double totalfee = cb.getTitalfee();
		double duefee =  cb.getDuefee();
		System.out.println("ammount-----------------------------" + ammount);
		System.out.println("totalfee-----------------------------" + totalfee);
		System.out.println("duefee-----------------------------" + duefee);
		// float due = totalfee - ammount;
		double due = duefee - ammount;
		// System.out.println(due);
		System.out.println("duefee-----------------------------" + due);
		double accbal = 0;
		double balance = 0;
		int accno = 0;
		int update = 0;
		int update1 = 0;

		try {

			pstmt = con
					.prepareStatement("update STUDENTFEERECORD set STUDENTNAME=?,COURSE=?,TOTALFEE=?,PAIDFEE=?,DUEFEE=?,PAYDATE=sysdate,BRANCH=? where STUDENTID=?");

			pstmt.setString(1, cb.getLogin());
			pstmt.setString(2, cb.getCname());

			pstmt.setDouble(3, cb.getTitalfee());
			pstmt.setDouble(4, cb.getTamount());
			pstmt.setDouble(5, due);
			pstmt.setString(6, cb.getBranchname());
			pstmt.setInt(7, cb.getUserid());
			int insert = pstmt.executeUpdate();

			if (insert > 0)

			{
				pstmt4 = con
						.prepareStatement("select accno,accbal from accountdetails where userid=?");

				pstmt4.setInt(1, cb.getUserid());

				rs4 = pstmt4.executeQuery();
				while (rs4.next()) {

					accno = rs4.getInt(1);
					accbal = (float) rs4.getDouble(2);

				}
				if (accbal != 0)

				{

					balance = accbal - ammount;

					pstmt5 = con
							.prepareStatement("update accountdetails set accbal=? where accno=?");

					pstmt5.setDouble(1, balance);
					pstmt5.setInt(2, accno);

					update = pstmt5.executeUpdate();

					double bal = 0.0;
					pstmt6 = con
							.prepareStatement("select accbal from accountdetails where ACCNO=?");

					pstmt6.setString(1, cb.getToacctno());

					rs6 = pstmt6.executeQuery();
					while (rs6.next()) {

						bal = rs6.getDouble(1);

					}

					bal = bal + ammount;

					pstmt7 = con
							.prepareStatement("update accountdetails set accbal=? where accno=?");

					pstmt7.setDouble(1, bal);
					pstmt7.setString(2, cb.getToacctno());

					update1 = pstmt7.executeUpdate();

				}

				if (update1 > 0) {

					con.commit();
				} else {
					flag = false;
					con.rollback();
				}

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public boolean insertfacultysubjects(CourseFormBean cb) {
		boolean flag = true;
		int userid = 0;

		try {

			System.out.println("Userid========>" + cb.getUserid());
			System.out.println("subject id===========>" + cb.getSubject());
			pstmt = con
					.prepareStatement("insert into FACULTYSUBJECT values((select nvl(max(sno),10)+1 from FACULTYSUBJECT),?,?)");

			pstmt.setInt(1, cb.getUserid());
			pstmt.setString(2, cb.getSubject());

			int insert = pstmt.executeUpdate();

			if (insert > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public boolean deleteCourse(int courseid) {

		boolean flag = true;

		try {

			pstmt = con.prepareStatement("delete from course where courseid=?");
			pstmt.setInt(1, courseid);

			int delete = pstmt.executeUpdate();

			if (delete > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public Vector<CourseFormBean> viewCourse() {
		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select courseid,cname,cdescription,cfee,cduration,TO_CHAR(cdate,'DD-MM-YYYY'),cstatus from course");

			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setCourseid(rs.getInt(1));
				cb.setCname(rs.getString(2));
				cb.setCdescription(rs.getString(3));
				cb.setFee(rs.getDouble(4));
				cb.setDuration(rs.getString(5));

				cb.setCdate(rs.getString(6));
				cb.setCstatus(rs.getString(7));

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;
	}

	public Vector<CourseFormBean> viewCourseAt(int cid) {
		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select courseid,cname,cdescription,cfee,cduration,TO_CHAR(cdate,'DD-MM-YYYY'),cstatus from course where courseid=?");

			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setCourseid(rs.getInt(1));
				cb.setCname(rs.getString(2));
				cb.setCdescription(rs.getString(3));
				cb.setFee(rs.getDouble(4));
				cb.setDuration(rs.getString(5));

				cb.setCdate(rs.getString(6));
				cb.setCstatus(rs.getString(7));

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;
	}

	public boolean updateCourse(CourseFormBean cb) {
		boolean flag = true;
		try {

			pstmt = con
					.prepareStatement("update course set cname=?,cdescription=?,cfee=?,cduration=?, cstatus=? where courseid=?");

			pstmt.setString(1, cb.getCname());
			pstmt.setString(2, cb.getCdescription());
			pstmt.setDouble(3, cb.getFee());
			pstmt.setString(4, cb.getDuration());

			pstmt.setString(5, cb.getCstatus());
			pstmt.setInt(6, cb.getCourseid());

			int update = pstmt.executeUpdate();

			if (update > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public boolean insertNotification(NotificationBean ab)
			throws FileNotFoundException {

		boolean flag = true;
		int uid = 0;

		try {
			String notification = ab.getNotification();
			pstmt = con
					.prepareStatement("insert into announcement values((select nvl(max(aid),1000)+1 from announcement),?,?,?,sysdate,?)");

			int cid = ab.getCourseid();

			System.out.println("in DAo class courseid is........." + cid);
			String announcement = ab.getDescription();
			String login = ab.getLogin();

			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select userid from userdetails where loginid="
							+ "'" + login + "'");

			if (rs.next()) {
				uid = rs.getInt(1);
			}

			pstmt.setInt(1, cid);
			pstmt.setInt(2, uid);

			pstmt.setString(3, announcement);
			File file = new File(notification);
			FileInputStream fis = new FileInputStream(file);

			pstmt.setBinaryStream(4, fis, (int) file.length());

			int insert = pstmt.executeUpdate();

			if (insert > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public Vector<NotificationBean> viewNotification(int cid, String path)
			throws FileNotFoundException {
		Vector<NotificationBean> vab = null;
		String ctitle = "";
		String fname = "";
		String lname = "";
		String email = "";
		String fax = "";

		try {

			pstmt = con
					.prepareStatement("select aid,courseid,description,TO_CHAR(adate,'DD-MM-YYYY'),userid from announcement");

			pstmt.setInt(1, cid);

			rs = pstmt.executeQuery();

			vab = new Vector<NotificationBean>();

			while (rs.next()) {

				int nid = rs.getInt(1);
				int courseid = rs.getInt(2);
				String description = rs.getString(3);

				String adate = rs.getString(4);
				int uid = rs.getInt(5);

				pstmt1 = con
						.prepareStatement("select cname from course where courseid=?");
				pstmt1.setInt(1, courseid);

				rs1 = pstmt1.executeQuery();
				if (rs1.next()) {

					ctitle = rs1.getString(1);
				}

				stmt = con.createStatement();

				NotificationBean ab = new NotificationBean();

				ab.setAdate(adate);
				ab.setAid(nid);
				ab.setDescription(description);
				ab.setCourseid(courseid);
				ab.setUserid(uid);
				ab.setCtitle(ctitle);
				ab.setFax(fax);
				ab.setFname(fname);
				ab.setLname(lname);
				ab.setEmail(email);
				ab.setNotification(".doc");

				vab.add(ab);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vab;

	}

	public Vector<NotificationBean> viewAllNotification(String path)
			throws FileNotFoundException {
		Vector<NotificationBean> vab = null;
		String ctitle = "";
		String fname = "";
		String lname = "";
		String email = "";
		String fax = "";

		try {

			pstmt = con
					.prepareStatement("select aid,courseid,description,TO_CHAR(adate,'DD-MM-YYYY'),userid,notification from announcement");

			rs = pstmt.executeQuery();

			vab = new Vector<NotificationBean>();

			while (rs.next()) {
				NotificationBean ab = new NotificationBean();
				int nid = rs.getInt(1);
				System.out.println("id value" + nid);
				ab.setAid(nid);

				int courseid = rs.getInt(2);
				System.out.println("cid value" + courseid);
				ab.setCourseid(courseid);

				String description = rs.getString(3);
				System.out.println("description value" + description);
				ab.setDescription(description);

				Blob b = rs.getBlob(6);

				if (b != null) {
					byte b1[] = b.getBytes(1, (int) b.length());

					OutputStream fout = new FileOutputStream(path + "/" + nid
							+ ".doc");
					try {
						fout.write(b1);

						ab.setNotification("/" + nid + ".doc");

						System.out.println("path========>"
								+ ab.getNotification());
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
				// ab.setNotification("/"+nid+ ".doc");

				String adate = rs.getString(4);
				System.out.println("adate value" + adate);
				ab.setAdate(adate);

				int uid = rs.getInt(5);
				System.out.println("uid value" + uid);
				ab.setUserid(uid);

				pstmt1 = con
						.prepareStatement("select cname from course where courseid=?");
				pstmt1.setInt(1, courseid);

				rs1 = pstmt1.executeQuery();
				if (rs1.next()) {

					ctitle = rs.getString(1);
					System.out.println("title is " + ctitle);
					ab.setCtitle(ctitle);

				}

				ab.setFax(fax);
				ab.setFname(fname);
				ab.setLname(lname);
				ab.setEmail(email);

				vab.add(ab);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vab;

	}

	public boolean uploadQpaper(CourseFormBean cb) throws FileNotFoundException {

		boolean flag = true;
		int uid = 0;
		String edate = "";

		try {

			pstmt = con
					.prepareStatement("insert into qpaper values((select nvl(max(pid),100)+1 from qpaper),?,?,?,?,?,sysdate,?)");

			int cid = cb.getCourseid();

			System.out.println("in DAo courseid is,,,,,,,,,,,,,,,,,,," + cid);
			String login = cb.getLogin();

			String qpaper = cb.getQpaper();

			int subjid = cb.getSubjid();

			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select userid from userdetails where loginid="
							+ "'" + login + "'");

			System.out.println("in DAo login is ....,,,,,,,,,,," + login);

			if (rs.next()) {
				uid = rs.getInt(1);

				System.out.println("in Dao userid is.............." + uid);
			}

			pstmt1 = con
					.prepareStatement("select TO_CHAR(examdate,'DD-MM-YYYY') from examschedule where courseidref=? and subjidref=?");
			pstmt1.setInt(1, cid);
			pstmt1.setInt(2, subjid);

			rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				edate = rs1.getString(1);

				System.out
						.println("from exam scgedule edate is--------------->"
								+ DateWrapper.parseDate(edate));

			}

			pstmt.setInt(1, cid);
			pstmt.setInt(2, subjid);
			pstmt.setInt(3, uid);
			pstmt.setString(4, DateWrapper.parseDate(edate));

			File file = new File(qpaper);
			FileInputStream fis = new FileInputStream(file);
			pstmt.setBinaryStream(5, fis, (int) file.length());

			pstmt.setString(6, cb.getQdescription());

			int insert = pstmt.executeUpdate();

			if (insert > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public Vector<CourseFormBean> viewQpaper(String path, int cid, int subjid) {

		Vector<CourseFormBean> vcb = null;

		String sdate = "";
		String edate = "";
		String time = "";

		try {

			pstmt1 = con
					.prepareStatement("select examdate,time from examschedule where courseidref=? and subjidref=?");

			pstmt1.setInt(1, cid);
			pstmt1.setInt(2, subjid);

			rs1 = pstmt1.executeQuery();

			if (rs1.next()) {

				edate = rs1.getString(1);

				time = rs1.getString(2);

			}

			int length = time.length();

			String edtime = time.substring(0, 2);

			System.out
					.println("in Dao Class trim time is.....=====================>"
							+ edtime);

			int etime = Integer.parseInt(edtime);

			System.out.println("exam time is........." + etime);

			Calendar calendar = Calendar.getInstance();

			Date date = new Date();
			System.out.println("current date" + date);
			calendar.set(date.getYear(), date.getMonth(), date.getDate(), date
					.getHours(), date.getMinutes());

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date today = df.parse(edate);
			Calendar c1 = Calendar.getInstance();
			System.out.println("exam date is" + today);
			c1.set(today.getYear(), today.getMonth(), today.getDate());

			if (date.after(today)) {

				pstmt = con
						.prepareStatement("select pid,paper,TO_CHAR(pdate,'DD-MM-YY'),useridref,TO_CHAR(examdate,'DD-MM-YY') from qpaper where courseidref=? and subjidref=?");

				pstmt.setInt(1, cid);
				pstmt.setInt(2, subjid);

				rs = pstmt.executeQuery();

				vcb = new Vector<CourseFormBean>();

				while (rs.next()) {

					int qid = rs.getInt(1);

					Blob b = rs.getBlob(2);
					byte b1[] = b.getBytes(1, (int) b.length());

					OutputStream fout = new FileOutputStream(path + "/" + qid
							+ ".doc");
					// System.out.println(fout+"*********************");
					fout.write(b1);

					CourseFormBean cb = new CourseFormBean();

					cb.setQid(qid);
					cb.setQpaper(".doc");

					cb.setQdate(rs.getString(3));
					cb.setUserid(rs.getInt(4));
					cb.setQdate(rs.getString(5));

					vcb.add(cb);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vcb;

	}

	public boolean insertDepartment(CourseFormBean cb) {

		boolean flag = true;
		int userid = 0;

		try {

			pstmt = con
					.prepareStatement("insert into DEPARTMENT values((select nvl(max(DEPTID),0)+1 from DEPARTMENT),?,?)");

			pstmt.setString(1, cb.getDepartmentname());
			pstmt.setString(2, cb.getDdescription());

			int insert = pstmt.executeUpdate();

			if (insert > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	public boolean deleteDepartment(int subid) {
		boolean flag = true;

		try {

			pstmt = con
					.prepareStatement("delete from Department where DEPTID=?");
			pstmt.setInt(1, subid);

			int delete = pstmt.executeUpdate();

			if (delete > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	//
	public Vector<CourseFormBean> viewDepartment() {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select DEPTID,DEPARTNAME,DESCRIPTION from department");

			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setDid(rs.getInt(1));
				cb.setDepartmentname(rs.getString(2));
				cb.setDdescription(rs.getString(3));

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	//
	public Vector<CourseFormBean> viewDepartmentAt(int sid) {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select DEPTID,DEPARTNAME,DESCRIPTION from department where DEPTID=?");

			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();
				cb.setDid(rs.getInt(1));
				cb.setDepartmentname(rs.getString(2));
				cb.setDdescription(rs.getString(3));
				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	//
	public boolean updateDepartment(CourseFormBean cb) {

		boolean flag = true;
		try {

			pstmt = con
					.prepareStatement("update Department set DEPARTNAME=?,DESCRIPTION=? where DEPTID=?");

			pstmt.setString(1, cb.getDepartmentname());
			pstmt.setString(2, cb.getDdescription());

			pstmt.setInt(3, cb.getDid());

			int update = pstmt.executeUpdate();

			if (update > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	public boolean insertBranch(CourseFormBean cb) {

		boolean flag = true;
		int userid = 0;

		try {

			pstmt = con
					.prepareStatement("insert into BRANCH values((select nvl(max(BRANCHID),110)+1 from BRANCH),?,?)");

			pstmt.setString(1, cb.getBranchname());
			pstmt.setString(2, cb.getBdescription());

			int insert = pstmt.executeUpdate();

			if (insert > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	//
	public boolean deleteBranch(int subid) {
		boolean flag = true;

		try {

			pstmt = con.prepareStatement("delete from BRANCH where BRANCHID=?");
			pstmt.setInt(1, subid);

			int delete = pstmt.executeUpdate();

			if (delete > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	//
	public Vector<CourseFormBean> viewBranch() {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select BRANCHID,BRANCHNAME,DESCRIPTION from BRANCH");

			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setBid(rs.getInt(1));
				cb.setBranchname(rs.getString(2));
				cb.setBdescription(rs.getString(3));

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	//
	public Vector<CourseFormBean> viewBranchAt(int sid) {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select BRANCHID,BRANCHNAME,DESCRIPTION from BRANCH where BRANCHID=?");

			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setBid(rs.getInt(1));
				cb.setBranchname(rs.getString(2));
				cb.setBdescription(rs.getString(3));

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	//
	public boolean updateBranch(CourseFormBean cb) {

		boolean flag = true;
		try {

			pstmt = con
					.prepareStatement("update branch set BRANCHNAME=?,DESCRIPTION=? where BRANCHID=?");

			pstmt.setString(1, cb.getBranchname());
			pstmt.setString(2, cb.getBdescription());

			pstmt.setInt(3, cb.getBid());

			int update = pstmt.executeUpdate();

			if (update > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	public boolean insertFee(CourseFormBean cb) {

		boolean flag = true;
		int userid = 0;

		try {

			pstmt = con
					.prepareStatement("insert into feeinfo values((select nvl(max(FEEID),110)+1 from feeinfo),?,?,?,?,?,?,?,?,?)");

			String ldate = DateWrapper.parseDate(cb.getLdate());
			System.out.println(" in dao dob" + ldate);

			pstmt.setInt(1, cb.getCourseid());
			pstmt.setDouble(2, cb.getAf());
			pstmt.setDouble(3, cb.getEf());
			pstmt.setDouble(4, cb.getLf());
			pstmt.setDouble(5, cb.getPf());
			pstmt.setDouble(6, cb.getTf());
			pstmt.setDouble(7, cb.getHf());
			pstmt.setString(8, ldate);
			double tf = cb.getAf() + cb.getEf() + cb.getLf() + cb.getPf()
					+ cb.getTf() + cb.getHf();
			pstmt.setDouble(9, tf);
			int insert = pstmt.executeUpdate();

			if (insert > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	public boolean deleteFee(int subid) {
		boolean flag = true;

		try {

			pstmt = con.prepareStatement("delete from feeinfo where FEEID=?");
			pstmt.setInt(1, subid);

			int delete = pstmt.executeUpdate();

			if (delete > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	//
	public Vector<CourseFormBean> viewFee() {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select FEEID,courseidref,AF,EF,LF,PF,TF,HF,TO_CHAR(LASTDATE,'DD-MM-YYYY') from feeinfo");

			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setFid(rs.getInt(1));
				cb.setAf(rs.getDouble(3));
				cb.setEf(rs.getDouble(4));
				cb.setLf(rs.getDouble(5));
				cb.setPf(rs.getDouble(6));
				cb.setTf(rs.getDouble(7));
				cb.setHf(rs.getDouble(8));

				cb.setCourseid(rs.getInt(2));

				int cid = rs.getInt(2);

				cb.setLdate(rs.getString(9));

				stmt = con.createStatement();
				rs1 = stmt
						.executeQuery("select cname from course where courseid="
								+ cid);

				while (rs1.next()) {

					cname = rs1.getString(1);

				}

				cb.setCname(cname);

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	//
	public Vector<CourseFormBean> viewFeeAt(int sid) {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select FEEID,courseidref,AF,EF,LF,PF,TF,HF,TO_CHAR(LASTDATE,'DD-MM-YYYY') from feeinfo where FEEID=?");

			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setFid(rs.getInt(1));
				cb.setAf(rs.getDouble(3));
				cb.setEf(rs.getDouble(4));
				cb.setLf(rs.getDouble(5));
				cb.setPf(rs.getDouble(6));
				cb.setTf(rs.getDouble(7));
				cb.setHf(rs.getDouble(8));

				cb.setCourseid(rs.getInt(2));

				int cid = rs.getInt(2);

				cb.setLdate(rs.getString(9));

				stmt = con.createStatement();
				rs1 = stmt
						.executeQuery("select cname from course where courseid="
								+ cid);

				while (rs1.next()) {

					cname = rs1.getString(1);

				}

				cb.setCname(cname);

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	//
	public boolean updateFee(CourseFormBean cb) {

		boolean flag = true;
		try {

			pstmt = con
					.prepareStatement("update FEEINFO set AF=?,EF=?,LF=?,PF=?,TF=?,HF=?,LASTDATE=?,totalfee=? where FEEID=?");

			String ldate = DateWrapper.parseDate(cb.getLdate());
			System.out.println(" in dao dob" + ldate);

			pstmt.setDouble(1, cb.getAf());
			pstmt.setDouble(2, cb.getEf());
			pstmt.setDouble(3, cb.getLf());
			pstmt.setDouble(4, cb.getPf());
			pstmt.setDouble(5, cb.getTf());
			pstmt.setDouble(6, cb.getHf());
			pstmt.setString(7, ldate);
			double tf = cb.getAf() + cb.getEf() + cb.getLf() + cb.getPf()
					+ cb.getTf() + cb.getHf();
			pstmt.setDouble(8, tf);
			pstmt.setInt(9, cb.getFid());

			int update = pstmt.executeUpdate();

			if (update > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	//
	public boolean insertSubject(CourseFormBean cb) {

		boolean flag = true;
		int userid = 0;

		try {

			pstmt = con
					.prepareStatement("insert into subject values((select nvl(max(subjid),110)+1 from subject),?,?,?,sysdate)");

			pstmt.setInt(1, cb.getCourseid());
			pstmt.setString(2, cb.getSname());
			pstmt.setString(3, cb.getSdescription());

			int insert = pstmt.executeUpdate();

			if (insert > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	//
	public boolean deleteSubject(int subid) {
		boolean flag = true;

		try {

			pstmt = con.prepareStatement("delete from subject where subjid=?");
			pstmt.setInt(1, subid);

			int delete = pstmt.executeUpdate();

			if (delete > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	//
	public Vector<CourseFormBean> viewSubject() {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select subjid,subname,sdescription,courseidref,TO_CHAR(sdate,'DD-MM-YYYY') from subject");

			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setSubid(rs.getInt(1));
				cb.setSname(rs.getString(2));
				cb.setSdescription(rs.getString(3));
				cb.setCourseid(rs.getInt(4));

				int cid = rs.getInt(4);

				cb.setSdate(rs.getString(5));

				stmt = con.createStatement();
				rs1 = stmt
						.executeQuery("select cname from course where courseid="
								+ cid);

				while (rs1.next()) {

					cname = rs1.getString(1);

				}

				cb.setCname(cname);

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	//
	public Vector<CourseFormBean> viewSubjectAt(int sid) {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select subjid,subname,sdescription,courseidref,TO_CHAR(sdate,'DD-MM-YYYY') from subject where subjid=?");

			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setSubid(rs.getInt(1));
				cb.setSname(rs.getString(2));
				cb.setSdescription(rs.getString(3));
				cb.setCourseid(rs.getInt(4));

				cb.setSdate(rs.getString(5));

				int cid = rs.getInt(4);

				cb.setSdate(rs.getString(5));

				stmt = con.createStatement();
				rs1 = stmt
						.executeQuery("select cname from course where courseid="
								+ cid);

				while (rs1.next()) {

					cname = rs1.getString(1);

				}

				cb.setCname(cname);

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	//
	public boolean updateSubject(CourseFormBean cb) {

		boolean flag = true;
		try {

			pstmt = con
					.prepareStatement("update Subject set subname=?,sdescription=? where subjid=?");

			pstmt.setString(1, cb.getSname());
			pstmt.setString(2, cb.getSdescription());

			pstmt.setInt(3, cb.getSubid());

			int update = pstmt.executeUpdate();

			if (update > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;

	}

	public Vector<CourseFormBean> viewStudentFee(String login) {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select u.userid,u.LOGINID,c.CNAME, b.branchname,s.af,s.ef,s.lf,s.pf,s.tf,s.hf,s.totalfee,a.accno,r.duefee from userdetails u ,feeinfo s ,course c ,branch b,accountdetails a,studentfeerecord r where c.COURSEID=u.COURSEID and c.COURSEID=s.COURSEIDREF and b.BRANCHID=u.BRANCHID and u.userid=a.USERID and r.studentid=u.userid and loginid=?");
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setUserid(rs.getInt(1));
				cb.setLogin(rs.getString(2));
				cb.setCname(rs.getString(3));
				cb.setBranchname(rs.getString(4));
				cb.setAf(rs.getDouble(5));
				cb.setEf(rs.getDouble(6));
				cb.setLf(rs.getDouble(7));
				cb.setPf(rs.getDouble(8));
				cb.setTf(rs.getDouble(9));
				cb.setHf(rs.getDouble(10));
				cb.setTitalfee(rs.getDouble(11));
				cb.setAcctno(rs.getString(12));
				cb.setDuefee(rs.getDouble(13));

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	public Vector<CourseFormBean> StudentFee(String login) {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select studentid,studentname,course,branch,totalfee,paidfee,DUEFEE,TO_CHAR(paydate,'DD-MM-YYYY') from STUDENTFEERECORD where  studentname=?");
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setUserid(rs.getInt(1));
				cb.setLogin(rs.getString(2));
				cb.setCname(rs.getString(3));
				cb.setBranchname(rs.getString(4));

				cb.setTitalfee(rs.getDouble(5));
				cb.setPaidfee(rs.getDouble(6));
				cb.setDuefee(rs.getDouble(7));
				cb.setPaidate(rs.getString(8));

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	public Vector<CourseFormBean> AllStudentFee() {

		Vector<CourseFormBean> vcb = null;

		try {

			pstmt = con
					.prepareStatement("select studentid,studentname,course,branch,totalfee,paidfee,DUEFEE,TO_CHAR(paydate,'DD-MM-YYYY') from STUDENTFEERECORD");

			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();
			String cname = "";

			while (rs.next()) {

				CourseFormBean cb = new CourseFormBean();

				cb.setUserid(rs.getInt(1));
				cb.setLogin(rs.getString(2));
				cb.setCname(rs.getString(3));
				cb.setBranchname(rs.getString(4));

				cb.setTitalfee(rs.getDouble(5));
				cb.setPaidfee(rs.getDouble(6));
				cb.setDuefee(rs.getDouble(7));
				cb.setPaidate(rs.getString(8));

				vcb.add(cb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vcb;

	}

	public Vector<CourseFormBean> viewAllQpaper(String path) {

		Vector<CourseFormBean> vcb = null;
		String cname = "";
		String subname = "";

		try {

			pstmt = con
					.prepareStatement("select pid,paper,TO_CHAR(pdate,'DD-MM-YY'),TO_CHAR(examdate,'DD-MM-YY'),courseidref,subjidref,description from qpaper");

			rs = pstmt.executeQuery();

			vcb = new Vector<CourseFormBean>();

			while (rs.next()) {

				int qid = rs.getInt(1);

				Blob b = rs.getBlob(2);
				byte b1[] = b.getBytes(1, (int) b.length());

				OutputStream fout = new FileOutputStream(path + "/" + qid
						+ ".doc");

				fout.write(b1);

				int cid = rs.getInt(5);
				int subid = rs.getInt(6);

				stmt = con.createStatement();
				rs1 = stmt
						.executeQuery("select cname from course where courseid="
								+ cid);
				while (rs1.next()) {

					cname = rs1.getString(1);
				}
				cname = Integer.toString(qid);
				stmt1 = con.createStatement();
				rs2 = stmt1
						.executeQuery("select subname from subject where subjid="
								+ subid);
				while (rs2.next()) {

					subname = rs2.getString(1);
				}

				CourseFormBean cb = new CourseFormBean();

				cb.setQid(qid);
				cb.setQpaper(".doc");
				cb.setQdate(rs.getString(3));
				cb.setEdate(rs.getString(4));
				cb.setCourseid(rs.getInt(5));
				cb.setSubid(rs.getInt(6));
				cb.setQdescription(rs.getString(7));
				cb.setCname(cname);
				cb.setSname(subname);

				vcb.add(cb);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vcb;

	}

}
