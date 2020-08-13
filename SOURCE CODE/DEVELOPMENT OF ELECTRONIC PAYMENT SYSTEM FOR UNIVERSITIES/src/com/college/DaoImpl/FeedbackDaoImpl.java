package com.college.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.college.DaoI.FeedbackDAOI;
import com.college.FormBean.FeedBackFormBean;
import com.college.db.ConnectionFactory;



public class FeedbackDaoImpl implements FeedbackDAOI{
	
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	Connection con;
	public FeedbackDaoImpl(){
	con=ConnectionFactory.getConnection();
		}
	
public boolean insertFeedBack(FeedBackFormBean fb)
	{     boolean flag=true;
		try{
			pstmt=con.prepareStatement("insert into feddback values((select nvl(max(fid),100)+1 from feddback),?,?,?,?,sysdate)");
			
			String feedback=fb.getFeedback();
			String name=fb.getCname();
			
			String email=fb.getEmail();
		
			String mobile=fb.getMobile();
		
			
			pstmt.setString(1, feedback);
			pstmt.setString(2, name);
			pstmt.setString(3, mobile);
			pstmt.setString(4, email);
		
			int insert=pstmt.executeUpdate();
			if(insert>0){
            con.commit();
        }
        else{
       	 flag=false;
       	 con.rollback();
        }
			} 
   catch (SQLException e) 
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
	 catch(SQLException e){
		 
		 e.printStackTrace();
	 }
	}
return flag;
}
	
	
	public Vector<FeedBackFormBean>  getFeedBack(int fid1)
	{
		Vector<FeedBackFormBean> vfb=null;
		
		try{
			
		
			pstmt=con.prepareStatement("select *from feddback where fid=?");
			pstmt.setInt(1, fid1);
			rs=pstmt.executeQuery();
			
			vfb=new Vector<FeedBackFormBean>();
			while(rs.next())
			{
			
			int fid=rs.getInt(1);
			String feedback=rs.getString(2);
			String username=rs.getString(3);
			String mobile=rs.getString(4);
			String email=rs.getString(5);
			String fdate=rs.getString(6);
			
			
			FeedBackFormBean fb=new FeedBackFormBean();
			
			
			fb.setEmail(email);
			fb.setFeedback(feedback);
			fb.setMobile(mobile);
			fb.setCname(username);
			fb.setFid(fid);
			fb.setFdate(fdate);
			
			vfb.add(fb);
			
			
			}
			
			
			
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return vfb;
		
	}
	
	
	
	
	public Vector<FeedBackFormBean>  getAllFeedBack()
	{
		Vector<FeedBackFormBean> vfb=null;
		
		try{
			
			
			pstmt=con.prepareStatement("select *from feddback ");
			
		
			
			
			rs=pstmt.executeQuery();
			
			vfb=new Vector<FeedBackFormBean>();
			while(rs.next())
			{
			
				int fid=rs.getInt(1);
				String feedback=rs.getString(2);
				String username=rs.getString(3);
				String mobile=rs.getString(4);
				String email=rs.getString(5);
				String fdate=rs.getString(6);
				
				
				FeedBackFormBean fb=new FeedBackFormBean();
				
				
				fb.setEmail(email);
				fb.setFeedback(feedback);
				fb.setMobile(mobile);
				fb.setCname(username);
				fb.setFid(fid);
				fb.setFdate(fdate);
			
			vfb.add(fb);
			
			
			}
			
			
			
			
			
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		return vfb;
		
	}
	
	public boolean cancelFeedBack(int fid)
	{
		
		
		boolean flag=true;
		
		try{
			System.out.println("impl fid value is vbbc"+fid);
			FeedBackFormBean f=new FeedBackFormBean();
		
		pstmt=con.prepareStatement("delete from feddback where fid=?");
		
	
	
	pstmt.setInt(1, fid);
	
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
 catch(SQLException e){
	 e.printStackTrace();
	 
 }
}
return flag;
}

}
