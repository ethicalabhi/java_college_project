package com.college.DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.college.DaoI.SecurityDaoI;
import com.college.FormBean.*;
import com.college.db.ConnectionFactory;





public class SecurityDaoImpl implements SecurityDaoI{

	Connection con;
	PreparedStatement pstmt,pstmt1;
	Statement stmt;
	ResultSet rs,rs1;

	 public Vector<LoginForm> loginCheck(LoginForm lf)
	 {
		 
		
			LoginForm loginForm=null;
			Vector<LoginForm> vpro=new Vector<LoginForm>();
		 try{
		 con=ConnectionFactory.getConnection();
		 
		 System.out.println("in DAo impl is..con is....."+con);
		 
		 pstmt=con.prepareStatement("select userid,logintype from userdetails where loginid=? and password=?");
		 
		 String uname=lf.getUsername();
		 System.out.println("in Security DAO class.....uname is"+uname);
		 String pwd=lf.getPassword();
		 System.out.println("in Security DAO class.....password is"+pwd);
		 
		 pstmt.setString(1, uname);
		 pstmt.setString(2, pwd);
		 
		 rs=pstmt.executeQuery();
		 
		 
		 if(rs.next()) {
				loginForm=new LoginForm();
				loginForm.setUserid(rs.getInt(1));
				loginForm.setLogintype(rs.getString(2));
				
			vpro.add(loginForm);
			}
	
	 }
		 catch (SQLException e) {
			 
			 e.printStackTrace();
			System.out.println("Exception raised"+e);
		}
		 return vpro;
			
	
	 }

	 //Method for login audit
	    public void loginaudit(String loginid)
	    {
	        try 
	        { 
	        	
	        	 con=ConnectionFactory.getConnection();
	        	
	            CallableStatement cstmt=con.prepareCall("{call signoutprocedure(?)}");
	            cstmt.setString(1,loginid);
	            
	            System.out.println("in loginaudit");
	           cstmt.execute();
	           
	            con.close();
	        }
	        catch(Exception e)
	        {
	             
	            e.printStackTrace();
	            }
	    }
	
	
}
