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
import java.util.Vector;

import com.college.DaoI.ExamDAOI;
import com.college.FormBean.CourseFormBean;
import com.college.FormBean.ExamFormBean;
import com.college.Util.DateWrapper;
import com.college.db.ConnectionFactory;




public class ExamDaoImpl implements ExamDAOI{

	
	
	PreparedStatement pstmt,pstmt1;
	Statement stmt;
	ResultSet rs,rs1,rs2;
	Connection con;
	
	
	public ExamDaoImpl()
	{
		
	con=ConnectionFactory.getConnection();
	
	}
	

	public boolean scheduleExam(ExamFormBean eb)
	{
		boolean flag=true;
		try{
			
			pstmt=con.prepareStatement("insert into examschedule values((select nvl(max(examid),1020)+1 from examschedule),?,?,?,?,?,?,?,?)");
			
		   int cid=eb.getCourseid();
		   int subid=eb.getSubid();
			
			String edate=eb.getExamdate();
			String day=eb.getDay();
			String time=eb.getTime();
			String etype=eb.getEtype();
			int marks=eb.getTmarks();
			String ename=eb.getEname();
			
			pstmt.setString(1,ename);
			pstmt.setInt(2, cid);
			pstmt.setInt(3, subid);
			pstmt.setString(4, etype);
			pstmt.setInt(5, marks);
			pstmt.setString(6,DateWrapper.parseDate(edate));
			pstmt.setString(7,day);
			pstmt.setString(8,time);
			
			
			
         int insert=pstmt.executeUpdate();
			
			if(insert>0)
	        {
	        
	         con.commit();
	        }
	        else
	        {
	       	 flag=false;
	       	 con.rollback();
	        }

	   } 
	   
	   catch (Exception e) 
	   {
	       e.printStackTrace();
	       flag=false;
	       try 
	       {
	           con.rollback();
	       } 
	       catch (SQLException se) 
	       {
	           se.printStackTrace();
	       }
	   }
	   
	   finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(Exception e){}
		}
	return flag;
	}
	
	
	public Vector<ExamFormBean> viewSchedule()   
	{
		
		Vector<ExamFormBean> veb=null;
		
		try{
			
			pstmt=con.prepareStatement("select examid,courseidref,subjidref,TO_CHAR(examdate,'DD-MM-YYYY'),day,time,examtitle,tmarks from examschedule");
			
			
			rs=pstmt.executeQuery();
			veb=new Vector<ExamFormBean>();
			String ctitle="";
			String subname="";
			
			
			while(rs.next())
			{
				
				int eid=rs.getInt(1);
				int courseid=rs.getInt(2);
				int subid=rs.getInt(3);
				String edate=rs.getString(4);
				String day=rs.getString(5);
				String time=rs.getString(6);
				String ename=rs.getString(7);
				int tmarks=rs.getInt(8);
				
				 pstmt1=con.prepareStatement("select cname from course where courseid=?");
					pstmt1.setInt(1, courseid);
					
					rs1=pstmt1.executeQuery();
					if(rs1.next())
					{
						
					   ctitle=rs1.getString(1);
						}
					
					
					stmt=con.createStatement();
				    rs2=stmt.executeQuery("select subname from subject where subjid="+subid);
				    while(rs2.next()){
				    	
				    	subname=rs2.getString(1);
				    }
				
				ExamFormBean eb=new ExamFormBean();
				
				eb.setExamdate(edate);
				eb.setCourseid(courseid);
				eb.setSubid(subid);
				eb.setDay(day);
				eb.setTime(time);
				eb.setCname(ctitle);
			    eb.setSname(subname);
			    eb.setEname(ename);
			    eb.setTmarks(tmarks);
				
				veb.add(eb);
				
		}
			
	}
		catch (SQLException e) {
		e.printStackTrace();
		}
		
		
		return veb;
		
}
	
	public boolean insertCircular(ExamFormBean eb){
		
		boolean flag=true;
		int userid=0;
		try{
			
     pstmt1=con.prepareStatement("select userid from userdetails where loginid=?");
			
			pstmt1.setString(1, eb.getLogin());
			rs=pstmt1.executeQuery();
			while(rs.next()){
				
				 userid=rs.getInt(1);
		
			}
			
			pstmt=con.prepareStatement("insert into circular values((select nvl(max(cid),10)+1 from circular),?,?,sysdate,?)");
			
		  
			
			pstmt.setString(1,eb.getCdescription());
			
		
			String circular=eb.getCircular();
			
			System.out.println("photo="+circular);
        	File f=new File(circular);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());	 
        	
        	pstmt.setBinaryStream(2, fis,(int)f.length());
			
			pstmt.setInt(3,userid);
		
			
			
			
         int insert=pstmt.executeUpdate();
			
			if(insert>0)
	        {
	        
	         con.commit();
	        }
	        else
	        {
	       	 flag=false;
	       	 con.rollback();
	        }

	   } 
	   
	   catch (Exception e) 
	   {
	       e.printStackTrace();
	       flag=false;
	       try 
	       {
	           con.rollback();
	       } 
	       catch (SQLException se) 
	       {
	           se.printStackTrace();
	       }
	   }
	   
	   finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(Exception e){}
		}
	return flag;
		
		
	}
	public Vector<ExamFormBean> viewCircular(String path) throws Exception{
		
		Vector<ExamFormBean> veb=null;
		
		try{
			 pstmt=con.prepareStatement("select cid,cdescription,circular,TO_CHAR(cdate,'DD-MM-YYY') from circular");
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				
				int cid=rs.getInt(1);
				ExamFormBean eb=new ExamFormBean();
				
				eb.setCirid(rs.getInt(1));
				eb.setCdescription(rs.getString(2));
				
				Blob b=rs.getBlob(3);
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ cid+".jpg");
				fout.write(b1);
				
				eb.setCircular(cid+".jpg");
				
				
				
				veb.add(eb);
				
				
			}
			
		
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return veb;
		
		
		
		
	}
	
	
	
	
	public Vector<ExamFormBean> getExam(int cid,int sid){
		
		Vector<ExamFormBean> veb=null;
		String ctitle="";
		String subname="";
		
		
		
		try{
			
			pstmt=con.prepareStatement("select examid from examschedule where courseidref=? and subjidref=?");
			
			pstmt.setInt(1, cid);
			pstmt.setInt(2, sid);
			
			rs=pstmt.executeQuery();
			
			veb=new Vector<ExamFormBean>();
			
			while(rs.next()){
				
				int examid=rs.getInt(1);
				
				
				
				pstmt1=con.prepareStatement("select cname from course where courseid=?");
				pstmt1.setInt(1, cid);
				
				rs1=pstmt1.executeQuery();
				if(rs1.next())
				{
					
				   ctitle=rs1.getString(1);
					}
				stmt=con.createStatement();
			    rs2=stmt.executeQuery("select subname from subject where subjid="+sid);
			    while(rs2.next()){
			    	
			    	subname=rs2.getString(1);
			    }
				
				
				
				
				ExamFormBean eb=new ExamFormBean();
				
				eb.setExamid(examid);
				eb.setCname(ctitle);
				eb.setSname(subname);
				
			
				veb.add(eb);
		
			}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return veb;
		
		
	}
	
	
	public boolean addMarks(CourseFormBean cb){
		
		
       boolean flag=false;
		
		try{
		
		pstmt=con.prepareStatement("insert into marks values(?,?,?,sysdate,?,?,?)");
		
		System.out.println("subject id======>"+cb.getSubjid());
		System.out.println("cb.getExamid()=========>"+cb.getExamid());
		System.out.println("cb.getUserid()========>"+cb.getUserid());
		System.out.println("cb.getSmarks()=========>"+cb.getSmarks());
		System.out.println("cb.getSubjid()==========>"+cb.getSubjid());
		System.out.println("cb.getPasspercentages()==========>"+cb.getPasspercentages());
		System.out.println("cb.getAverages()==========>"+cb.getAverages());
		
		pstmt.setInt(1, cb.getExamid());
		pstmt.setInt(2, cb.getUserid());
		pstmt.setInt(3, cb.getSmarks());
		pstmt.setInt(4,cb.getSubjid());
		pstmt.setInt(5, cb.getPasspercentages());
		pstmt.setInt(6, cb.getAverages());
		
		
		int i=pstmt.executeUpdate();
		
		if(i>0){
			
			flag=true;
			con.commit();
			
		}
		else{
			con.rollback();
			
		}
		
	}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	return flag;
}
	
	
	
public Vector<CourseFormBean> viewmarks(int userid){
		
		Vector<CourseFormBean> vcb=null;
		
		try{
	pstmt=con.prepareStatement("select  c.courseid,c.cname,s.subjid,s.subname,e.examid,e.examtitle,e.etype,e.tmarks,TO_CHAR(e.examdate,'DD-MM-YY'),m.smarks,rdate,m.average from course c,subject s,examschedule e,userdetails u,coursedetails cd,marks m where cd.useridref=u.userid and cd.courseidref=c.courseid and m.examid=e.examid and u.userid=m.userid and u.userid=?");
		
		pstmt.setInt(1, userid);
		
		rs=pstmt.executeQuery();
		
		vcb=new Vector<CourseFormBean>();
		while(rs.next()){
			
			CourseFormBean cb=new CourseFormBean();
			   
			   cb.setCourseid(rs.getInt(1));
			   cb.setCname(rs.getString(2));
			   cb.setSubid(rs.getInt(3));
			   cb.setSname(rs.getString(4));
			   cb.setExamid(rs.getInt(5));
			   cb.setEname(rs.getString(6));
			   cb.setEtype(rs.getString(7));
			   cb.setTmarks(rs.getInt(8));
			   cb.setEdate(rs.getString(9));
			   cb.setSmarks(rs.getInt(10));
			   cb.setRdate(rs.getString(11));
			   cb.setAverages(rs.getInt(12));
			   
			   
			   vcb.add(cb);
			
		}
	
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return vcb;
	
}
	
public Vector<CourseFormBean> viewFacultySubjects(int userid){
		
		Vector<CourseFormBean> vcb=null;
		
		try{
	//pstmt=con.prepareStatement("select c.courseid,c.cname,s.subjid,s.subname,e.examid,e.examtitle,e.etype,e.tmarks,TO_CHAR(e.examdate,'DD-MM-YY'),m.smarks,rdate from course c,subject s,examschedule e,userdetails u,coursedetails cd,marks m where cd.useridref=u.userid and cd.courseidref=c.courseid and m.examid=e.examid and u.userid=m.userid and     m.subjid=s.subjid  and    u.userid=?");
	//pstmt=con.prepareStatement("select DISTINCT f.subject,c.cname,TO_CHAR(c.cdate,'DD-MM-YY'),m.passpercentage from course c,facultysubject f,userdetails u,marks m,coursedetails cd where f.facultyid=u.userid and cd.courseidref=c.courseid  and    u.userid=?");	
			pstmt=con.prepareStatement("select DISTINCT f.subject,u.firstname from facultysubject f,userdetails u where u.userid=f.facultyid and u.userid=?");	
			pstmt.setInt(1, userid);
		
		rs=pstmt.executeQuery();
		
		vcb=new Vector<CourseFormBean>();
		while(rs.next()){
			
			CourseFormBean cb=new CourseFormBean();
			   
			   cb.setSubject(rs.getString(1));
			   cb.setFname(rs.getString(2));
			   //cb.setCname(rs.getString(2));
			   //cb.setCdate(rs.getString(3));
			   //cb.setPasspercentages(rs.getInt(4));
			  
			   
			   
			   vcb.add(cb);
			
		}
	
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return vcb;
	
}
}
