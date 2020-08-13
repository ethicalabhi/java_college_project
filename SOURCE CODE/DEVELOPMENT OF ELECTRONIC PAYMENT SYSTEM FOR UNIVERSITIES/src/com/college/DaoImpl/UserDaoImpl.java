package com.college.DaoImpl;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.college.DaoI.UserDAoI;
import com.college.FormBean.CourseFormBean;
import com.college.FormBean.RegisterFormBean;
import com.college.Util.CoreList;
import com.college.Util.LoggerManager;
import com.college.db.ConnectionFactory;



import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;




public class UserDaoImpl implements UserDAoI{

	
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	
	
	public UserDaoImpl()
	{
		con=ConnectionFactory.getConnection();
		
	}
	public CoreList getEmployees(String path)
    {
    	CoreList aCoreList = new CoreList();
    	
    	String userid="";
    
    	RegisterFormBean rb=null;
		aCoreList.clear();
		Statement st;
		try {
		
		
			pstmt = con.prepareStatement("select userid,logintype,firstname,lastname,TO_CHAR(dob,'DD-MM-YYYY'),emailid,photo from userdetails where logintype =?");
			pstmt.setString(1, "manager");
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				
				rb=new RegisterFormBean();
				userid=rs.getString(1);
			
				rb.setUserid(userid);
				rb.setLogintype(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setLname(rs.getString(4));
				rb.setDob(rs.getString(5));
				rb.setEmail(rs.getString(6));
			
				Blob b=rs.getBlob(7);
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
			
				rb.setPhoto(userid+".jpg");
			
				aCoreList.add(rb);
			}	
    	}
    	catch(SQLException se)
    	{
    		LoggerManager.writeLogWarning(se);
    	}
    	catch(Exception e)
    	{
    		LoggerManager.writeLogWarning(e);
    	}
    	finally
    	{
    		try
    		{
    			con.close();
    		}
    		catch(SQLException se)
    		{
    			LoggerManager.writeLogWarning(se);
    		}
    	}
    	return aCoreList;
    }  
		
	
		
		
	public CoreList getStudents(String path)
    {
		CoreList aCoreList = new CoreList();
     
    	
    	String ctitle="";
    	RegisterFormBean rb=null;
		aCoreList.clear();
		
		String userid="";
		int cid=0;
		
		try {
			
			pstmt = con.prepareStatement("select u.userid,u.logintype,u.firstname,u.lastname,TO_CHAR(u.dob,'DD-MM-YYYY'),u.emailid,photo,c.courseidref,a.phno,a.city,a.state,a.country from userdetails u,coursedetails c,addresses a where u.userid=c.useridref and u.userid=a.useridref and logintype =?");
			
			pstmt.setString(1,"student");
		     rs = pstmt.executeQuery();
			
			
			while(rs.next())
			{
				
				rb=new RegisterFormBean();
				userid=rs.getString(1);
			
				rb.setUserid(userid);
				rb.setLogintype(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setLname(rs.getString(4));
				rb.setDob(rs.getString(5));
				rb.setEmail(rs.getString(6));
			
				Blob b=rs.getBlob(7);
				if(b!=null){
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
			
				rb.setPhoto(userid+".jpg");
				}
				
				 cid=rs.getInt(8);
				
				System.out.println("from database cid is''''''''''''''''>"+cid);
				rb.setCourseid(cid);
			  rb.setMobile(rs.getString(9));
			  System.out.println("mobile no is "+rs.getString(9));
			  rb.setCity(rs.getString(10));
			  System.out.println("city  is "+rs.getString(10));
			  rb.setState(rs.getString(11));
			  System.out.println("state is "+rs.getString(11));
			  rb.setCountry(rs.getString(12));
			  System.out.println("country is "+rs.getString(12));
				stmt=con.createStatement();
				
				rs1=stmt.executeQuery("select cname from course where courseid="+cid);
				
				if(rs1.next()){
					
					ctitle=rs1.getString(1);
					System.out.println("in dao class cname is===============>"+ctitle);
					
				}
				rb.setCname(ctitle);
				
			
				aCoreList.add(rb);
			}	
    	}
    	catch(SQLException se)
    	{
    		LoggerManager.writeLogWarning(se);
    	}
    	catch(Exception e)
    	{
    		LoggerManager.writeLogWarning(e);
    	}
    	finally
    	{
    		try
    		{
    			con.close();
    		}
    		catch(SQLException se)
    		{
    			LoggerManager.writeLogWarning(se);
    		}
    	}
    	return aCoreList;
    	
    }  
		
		
	public Vector<CourseFormBean> getStudentCourseInfo(int userid){
		
		Vector<CourseFormBean> vcb=null;
		
		try{
		
		
			System.out.println("in dao class of getStudent info/////"+userid);
			pstmt=con.prepareStatement("select DISTINCT  c.courseid,c.cname,s.subjid,s.subname,e.examid,e.examtitle,e.etype,e.tmarks,TO_CHAR(e.examdate,'DD-MM-YY') from course c,subject s,examschedule e,userdetails u,coursedetails cd where cd.useridref=u.userid and cd.courseidref=c.courseid and u.userid=?");
			
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
			  // cb.setPasspercentages(rs.getInt(10));
			  // cb.setAverages(rs.getFloat(11));
			   
			   vcb.add(cb);
			   
			   
		   }
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vcb;
	}
		
		
		
		
	public boolean deleteEmployee(int cid,String login)
	{
		int uid=0;
		boolean flag=true;
		try
		{
			
			pstmt=con.prepareStatement("");
			
			
			
			stmt=con.createStatement();
			  rs=stmt.executeQuery("select userid from userdetails where loginid="+"'"+login+"'");
			  
			  System.out.println("in DAo login is ....,,,,,,,,,,,"+login);
			  
			  if(rs.next())
			  {
				 uid=rs.getInt(1);
				 
				 System.out.println("in Dao userid is.............."+uid);
			  }
			
			pstmt.setInt(1, uid);
			pstmt.setInt(2, cid);
			
			
			int delete=pstmt.executeUpdate();
			
			if(delete>0)
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
		
	
	
	public boolean deleteCollege(int cid,int uid)
	{
		
		boolean flag=true;

		try
		{
			
			pstmt=con.prepareStatement("");
			
			pstmt.setInt(1, uid);
			pstmt.setInt(2, cid);
			
			
			int delete=pstmt.executeUpdate();
			
			if(delete>0)
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
	
	
	public Vector<RegisterFormBean> studentNames(String login)
	{
		
		boolean flag=true;

		try
		{
			
			pstmt=con.prepareStatement("select firstname,lastname from userdetails where loginid=?");
			
			
			
			
			int delete=pstmt.executeUpdate();
			
			if(delete>0)
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
	return null;
	}

	public CoreList getFaculties(String path) {
       CoreList aCoreList = new CoreList();
    	String userid="";
    	RegisterFormBean rb=null;
		aCoreList.clear();
		Statement st;
		try {
		
		
			pstmt = con.prepareStatement("select userid,logintype,firstname,lastname,TO_CHAR(dob,'DD-MM-YYYY'),emailid,photo from userdetails where logintype =?");
			pstmt.setString(1, "faculty");
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				
				rb=new RegisterFormBean();
				userid=rs.getString(1);
			
				rb.setUserid(userid);
				rb.setLogintype(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setLname(rs.getString(4));
				rb.setDob(rs.getString(5));
				rb.setEmail(rs.getString(6));
			
				Blob b=rs.getBlob(7);
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
			
				rb.setPhoto(userid+".jpg");
			
				aCoreList.add(rb);
			}	
    	}
    	catch(SQLException se)
    	{
    		LoggerManager.writeLogWarning(se);
    	}
    	catch(Exception e)
    	{
    		LoggerManager.writeLogWarning(e);
    	}
    	finally
    	{
    		try
    		{
    			con.close();
    		}
    		catch(SQLException se)
    		{
    			LoggerManager.writeLogWarning(se);
    		}
    	}
    	return aCoreList;
    }  
		
	
	
	
	
}
