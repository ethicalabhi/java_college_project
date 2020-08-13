package com.college.DaoImpl;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.college.db.ConnectionFactory;
import com.college.FormBean.RegisterFormBean;
import com.college.FormBean.TransactionFormBean;
import com.college.Util.CoreList;
import com.college.Util.DateWrapper;
import com.college.Util.LoggerManager;



public class AccountDAO {
	
	PreparedStatement pstmt,pstmt1;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	
	
	public AccountDAO(){
		
		con=ConnectionFactory.getConnection();
		
	}
	
	
	
	
	
	public Vector<TransactionFormBean> getAccno(String login){
		
		int uid=0;
		String accno=null;
		Vector<TransactionFormBean> vfb=null;
		
		try{
		  
		 
		 pstmt1=con.prepareStatement("select userid from userdetails  where loginid=?");
			
			pstmt1.setString(1, login);
			rs1=pstmt1.executeQuery();
			
			if(rs1.next())
				uid=rs1.getInt(1);
			
			
		 pstmt=con.prepareStatement("select accno from accountdetails where userid=?");
		 
		 pstmt.setInt(1, uid);
		 
		 rs=pstmt.executeQuery();
		    
		 vfb=new Vector<TransactionFormBean>();
		 
		 while(rs.next()){
			 
			 accno=rs.getString(1);
			 
			 TransactionFormBean tb=new TransactionFormBean();
			 
			 tb.setAcctno(accno);
			 
			 vfb.add(tb);
			 
			 
			}
		
	}
		catch (SQLException e) {
		e.printStackTrace();
	}
		
	return vfb;
	
	}
	
	
	public ArrayList<TransactionFormBean> getusers(String path,String login)
    {
		
		ArrayList<TransactionFormBean>  atb=new ArrayList<TransactionFormBean> ();
    	
    	
    	String userid="";
    	
    	TransactionFormBean rb=null;
		
		Statement st;
		try {
		
			st = con.createStatement();
			int count = 0;
			
			  /*and ul.loginid="+"'"+login+"';*/
			
			ResultSet rs = st.executeQuery("select ul.USERID,ul.firstname,ul.lastname,to_char(ul.dob,'DD-MM-YYYY'),ul.emailid,ul.photo,a.accno,a.acctype,a.accbal from userdetails ul,accountdetails a where ul.userid=a.userid and ul.loginid="+"'"+login+"'");
		
			while(rs.next())
			{
				
				rb=new TransactionFormBean();
				
				userid=rs.getString(1);
				//inventory.setBrandID(rs.getInt(1));
				rb.setUser(userid);
				
				System.out.println("userid---------------"+userid);
				
				rb.setFname(rs.getString(2));
				rb.setLname(rs.getString(3));
				rb.setBdate(rs.getString(4));
				rb.setEmail(rs.getString(5));
								
				Blob b=rs.getBlob(6);
				System.out.println(":::::::::::::::::::::::::::::::::"+b);
				if(b!=null){
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
				}
				rb.setAcctno(rs.getString(7));
				rb.setAcctype(rs.getString(8));
				rb.setAccbal(rs.getDouble(9));
				
			     
				rb.setPhoto(path+"/"+ userid+".jpg");
		
				count++;
				atb.add(rb);
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
    	return atb;
    }  
	

	public boolean insertTransaction(TransactionFormBean tfb)
	{
		boolean flag=true;
		
		int update=0;
		int accbal=0;
		
		try{
			
			
			pstmt=con.prepareStatement("insert into transaction values((select nvl(max(transid),100)+1 from transaction),?,?,?,sysdate)");
			
			String  ttype=tfb.getTtype();
			System.out.println("in transaction Dao..........."+ttype);
			
			String accno=tfb.getAcctno();
			double amount=tfb.getTamount();
			
			pstmt.setString(1, accno);
			pstmt.setString(2, ttype);
			pstmt.setDouble(3, amount);
					
			int insert=pstmt.executeUpdate();
			System.out.println("No of rows inserted into transaction is..............."+insert);
			
			
			stmt=con.createStatement();
			rs=stmt.executeQuery("select accbal from accountdetails where accno="+accno);
			if(rs.next())
			 accbal=rs.getInt(1);
			
			System.out.println("in Dao balance from accountdetails ........."+accbal);
			
			if((insert>0)&&(ttype.equalsIgnoreCase("deposit")))
			{
				System.out.println("in side accountdetails");
			
				System.out.println("in side deposite accountdetails");
			pstmt=con.prepareStatement("update accountdetails set accbal=accbal+?,acdate=sysdate where accno=?");
			pstmt.setDouble(1, amount);
		
			pstmt.setString(2, accno);
			
			 update=pstmt.executeUpdate(); 
			 
			 System.out.println("in deposite rows updated is.............."+update);
			 
			}

	            if(update>0){
	            	
	            	flag=true;
	            	con.commit();
	            	
	            }
		}catch (Exception e) {
			e.printStackTrace();
		}

	return flag;

		}
		
	
	
	
	
	}
