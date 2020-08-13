package com.college.DaoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.college.DaoI.RegisterDaoI;
import com.college.FormBean.RegisterFormBean;
import com.college.Util.DateWrapper;
import com.college.db.ConnectionFactory;


public class RegisterDaoImpl implements RegisterDaoI {

	Connection con;
	PreparedStatement pstmt,pstmt1,pstmt2,pstmt3,pstmt4,pstmt5,pstmt6,pstmt7,pstmt8;
	Statement stmt;
	ResultSet rs,rs1,rs2,rs3,rs5;
	
	
	public RegisterDaoImpl(){
		
		
		con=ConnectionFactory.getConnection();
		
	}
	
	 public boolean insertNewUser(RegisterFormBean cp) throws FileNotFoundException
	    
	    {
	    	boolean flag=true;
	    	int insert=0;	 
	    	int j=0;
	    	try{	    		
	    		
		    	System.out.println("in registerDAO connection is ."+con);	          	
	            pstmt=con.prepareStatement("insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?)");	            		    		
	    		System.out.println();
	    		String photo =cp.getPhoto();
	    		
	    		String dob=DateWrapper.parseDate(cp.getDob());
	    		System.out.println(" in dao dob"+dob);
	    		
	    		String fname=cp.getFname();
	    		String lname=cp.getLname();
	    		String squestion=cp.getQuestn();
	    		String ans=cp.getAnsr();
	    		String email=cp.getEmail();
	    		String phone=cp.getMobile();
	    		String course=cp.getCourse();
	    	
	    		String logintype=cp.getRole();
	    		String loginid=cp.getUserid();
	    		String pwd=cp.getUserpwd();	    			    		
	    		String hno=cp.getHno();
	    		String street=cp.getStreet();
	    		String city=cp.getCity();
	    		String state=cp.getState();
	    		String country=cp.getCountry();
	    		String pin=cp.getPin();	    		
	    		System.out.println("photo="+photo);
	        	File f=new File(photo);
	        	FileInputStream fis=new FileInputStream(f); 
	        	System.out.println("fole="+f.length());	        	
	        	
	        		    		        	
	            pstmt.setString(1, fname);
	            pstmt.setString(2, lname);
	            pstmt.setString(3, dob);
	            pstmt.setString(4, loginid);
	            pstmt.setString(5, pwd);
	            pstmt.setString(6, logintype);
	            pstmt.setString(7, squestion);
	            pstmt.setString(8, ans);
	          
	          pstmt.setBinaryStream(9, fis,(int)f.length());
	        
	          pstmt.setString(10, email);
	        
	          pstmt.setString(11, "yes");
	          pstmt.setString(12, "yes");
	          pstmt.setInt(13, 114);
	          pstmt.setInt(14, 112);
	      
	          int i=pstmt.executeUpdate();
	          
	          if(i>0)
	          {	        	  
	        	  pstmt1=con.prepareStatement("insert into addresses values((select max(userid) from userdetails),?,?,?,?,?,?,?)");	        	  	        	  
	        	  pstmt1.setString(1, hno);
	        	  pstmt1.setString(2, street);
	        	  pstmt1.setString(3, city);
	        	  pstmt1.setString(4, state);
	        	  pstmt1.setString(5, country);
	        	  pstmt1.setString(6,pin);
	        	  pstmt1.setString(7, phone);
	        	  insert=pstmt1.executeUpdate();
	        	  }	          	          
	          
	          
	          if(insert>0)
		         {
		         
	        	  pstmt2=con.prepareStatement("insert into accountdetails values( (select nvl(max(accno),1020304050)+1 from accountdetails),?,(select max(userid) from userdetails),?,?,sysdate)");
	        	  
	        	   pstmt2.setString(1, cp.getAcctype());
	        	   pstmt2.setString(2, cp.getBname());
	        	   pstmt2.setDouble(3, cp.getAccbal());
	        	  
	        	   
	        	   j=pstmt2.executeUpdate();
	        	  
		         }
	          
	          if(j>0){
	        	  flag=true;
		          con.commit();
		         }
		         else
		         {
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
			 catch(SQLException e){}
			}
		return flag;
	}
	 
	 public boolean RegisterStudent(RegisterFormBean cp) throws FileNotFoundException 
	    
	 
	    {
	    	boolean flag=true;
	    	int insert=0;	 
	    	int j=0;
	    	int k=0;
	    	int l=0;
	    	try{	    		
	    		
		    	System.out.println("in registerDAO connection is ."+con);	          	
	            pstmt=con.prepareStatement("insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?)");	            		    		
	    		System.out.println();
	    		String photo =cp.getPhoto();
	    		
	    		String dob=DateWrapper.parseDate(cp.getDob());
	    		System.out.println(" in dao dob"+dob);
	    		
	    		String fname=cp.getFname();
	    		String lname=cp.getLname();
	    		String squestion=cp.getQuestn();
	    		String ans=cp.getAnsr();
	    		String email=cp.getEmail();
	    		String phone=cp.getMobile();
	    		int cid=cp.getCourseid();
	    		int bid=cp.getBid();
	    		String bus=cp.getBus();
	    		String hostel=cp.getHostel();
	    	
	    		String logintype=cp.getRole();
	    		String loginid=cp.getUserid();
	    		String pwd=cp.getUserpwd();	    			    		
	    		String hno=cp.getHno();
	    		String street=cp.getStreet();
	    		String city=cp.getCity();
	    		String state=cp.getState();
	    		String country=cp.getCountry();
	    		String pin=cp.getPin();	    		
	    		System.out.println("photo="+photo);
	        	File f=new File(photo);
	        	FileInputStream fis=new FileInputStream(f); 
	        	System.out.println("fole="+f.length());	        	
	        	
	        		    		        	
	            pstmt.setString(1, fname);
	            pstmt.setString(2, lname);
	            pstmt.setString(3, dob);
	            pstmt.setString(4, loginid);
	            pstmt.setString(5, pwd);
	            pstmt.setString(6, logintype);
	            pstmt.setString(7, squestion);
	            pstmt.setString(8, ans);
	          
	          pstmt.setBinaryStream(9, fis,(int)f.length());
	        
	          pstmt.setString(10, email);
	        
	          pstmt.setString(11, bus);
	          pstmt.setString(12, hostel);
	          pstmt.setInt(13, cid);
	          pstmt.setInt(14, bid);
	          int i=pstmt.executeUpdate();
	          
	          
	          if(i>0){
	        	  
		        	 pstmt2=con.prepareStatement("insert into coursedetails values((select nvl(max(cdid),101)+1 from coursedetails),?,(select max(userid) from userdetails),sysdate)"); 
		        	  
		        	  pstmt2.setInt(1, cid);
		        	  
		        	  System.out.println("in dao class of register student cid===========>"+cid);
		        	  
		        	   j=pstmt2.executeUpdate();
		        	   
		        	   con.commit();
		        	   
		        	   System.out.println("n dao class of register student jis=========?>"+j);
		        	 
		          }
	          
	          if(j>0)
	          {	        	  
	        	  pstmt1=con.prepareStatement("insert into addresses values((select max(userid) from userdetails),?,?,?,?,?,?,?)");	        	  	        	  
	        	  pstmt1.setString(1, hno);
	        	  pstmt1.setString(2, street);
	        	  pstmt1.setString(3, city);
	        	  pstmt1.setString(4, state);
	        	  pstmt1.setString(5, country);
	        	  pstmt1.setString(6,pin);
	        	  pstmt1.setString(7, phone);
	        	  insert=pstmt1.executeUpdate();
	        	  }	          	          
	          
	          
	          if(insert>0)
		         {
		         
	        	  pstmt2=con.prepareStatement("insert into accountdetails values( (select nvl(max(accno),1020304050)+1 from accountdetails),?,(select max(userid) from userdetails),?,?,sysdate)");
	        	  
	        	   pstmt2.setString(1, cp.getAcctype());
	        	   pstmt2.setString(2, cp.getBname());
	        	   pstmt2.setDouble(3, cp.getAccbal());
	        	  
	        	   
	        	   k=pstmt2.executeUpdate();
	        	  
		         }
	          
	          if(k>0)
	          {	        
	        	      double total=0.0;
	        	      double due=0.0;
	        	      String course=null;
	        	      String branch=null;
	        	  
	        	    pstmt5=con.prepareStatement("select totalfee from feeinfo where COURSEIDREF=?");
		            pstmt5.setInt(1,cid);
		            rs1=pstmt5.executeQuery();
		            if(rs1.next())
		            {
		            	total=rs1.getDouble(1);
		            
		            }
		            pstmt6=con.prepareStatement("select cname from course where COURSEID=?");
		            pstmt6.setInt(1,cid);
		            rs2=pstmt6.executeQuery();
		            if(rs2.next())
		            {
		            	course=rs2.getString(1);
		            
		            }
		            pstmt7=con.prepareStatement("select branchname from branch where BRANCHID=?");
		            pstmt7.setInt(1,bid);
		            rs3=pstmt7.executeQuery();
		            if(rs3.next())
		            {
		            	branch=rs3.getString(1);
		            
		            }
		        
	        	  
	        	  
	        	  
	        	  
	        	    pstmt3=con.prepareStatement("insert into STUDENTFEERECORD values((select nvl(max(sfrid),555)+1 from STUDENTFEERECORD),(select max(userid) from userdetails),?,?,?,?,?,sysdate,?)");	        	  	        	  
	        	    pstmt3.setString(1,loginid);
	        	    pstmt3.setString(2,course);
	                pstmt3.setDouble(3,total);
	                pstmt3.setDouble(4,due);
	         	    pstmt3.setDouble(5,total);
	         	    pstmt3.setString(6,branch);
	        	   l=pstmt3.executeUpdate();
	        	  }	          	          
	          
	          if(l>0){
	        	  flag=true;
		          con.commit();
		         }
		         else
		         {
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
			 catch(SQLException e){}
			}
		return flag;
	}
	 
	 
	 
	 public void logout1(String user){
	    	
	    	
	    	try{
	    		pstmt=con.prepareStatement("update loginmaster set logofftime=sysdate where userid=? and logofftime=null");
	    		pstmt.setString(1, user);
	    		int c=pstmt.executeUpdate();
	    		if(c>0){
	     			con.commit();
	    		}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    }
	 public boolean logout(String loginid)
	    {
		 
		 boolean flag=true;
	        try 
	        {
	        	
	        	
	        int uid=0;
	      
	        System.out.println("in logout Dao login id is........."+loginid);
	        	
	            pstmt=con.prepareStatement("select userid from userdetails where loginid=?");
	            pstmt.setString(1,loginid);
	            rs=pstmt.executeQuery();
	            if(rs.next())
	            	
	            	uid=rs.getInt(1);
	            
	            System.out.println("in logout method");
	            
	            System.out.println("in DAo userid is ........."+uid);
	           
	            pstmt1=con.prepareStatement("update loginmaster set logofftime=sysdate where logofftime is null and userid=?");
	            pstmt1.setInt(1, uid);
	            
	            int update=pstmt1.executeUpdate();
	            
	            System.out.println("from db update is ."+update);

				if(update>0)
		         {
		         
		          con.commit();
		         }
		         else
		         {
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
			 catch(SQLException e){}
			}
		return flag;
	}
	 
	 
	 public String passwordRecovery(RegisterFormBean rto){
	    	String password="";
	        try{
	        	
	        	 String question=rto.getQuestn();
				 String ans=rto.getAnsr();
				 String loginid=rto.getUserid();
				
	        	pstmt=con.prepareStatement("select password from userdetails where loginid=? and forgotpwquestion=? and forgotpwanswer=?");
	        	pstmt.setString(1, loginid);
	        	pstmt.setString(2, question);
	        	pstmt.setString(3, ans);
	        	rs=pstmt.executeQuery();
	        	if(rs.next()){
	        		password=rs.getString(1);
	        	}
	        }catch(SQLException e){
	        	e.printStackTrace();
	        }
	    	return password;
	    }
	 
	 
	 public boolean checkAvailability(String userid){
	    	boolean flag=false;
	    	try{
	    		pstmt=con.prepareStatement("select userid from userdetails where loginid=?");
	    		pstmt.setString(1, userid);
	    		rs=pstmt.executeQuery();
	    		if(rs.next()){
	    			flag=true;
	    		}
	    	}catch(SQLException e){
	    		e.printStackTrace();
	    	}
	    	return flag;
	    }
	    
	 public double checkbalAvailability(String userid){
	    	Double bal=0.0;
	    	try{
	    		pstmt=con.prepareStatement("select ACCBAL from ACCOUNTDETAILS where USERID=?");
	    		pstmt.setString(1, userid);
	    		rs=pstmt.executeQuery();
	    		if(rs.next()){
	    			bal=rs.getDouble(1);
	    		}
	    	}catch(SQLException e){
	    		e.printStackTrace();
	    	}
	    	return bal;
	    }
	    
	 
	 public boolean changePass(RegisterFormBean rto){
	    	boolean flag=false;
	    	try{
	    		
	    
	    		
	    		String newpass=rto.getNewpassword();
	    		System.out.println("in DAO class//////////////////"+newpass);
	    		String user=rto.getUsername();
	    		System.out.println("in DAo ............userid .is........."+user);
	    		String oldpass=rto.getOldpassword();
	    		System.out.println("in DAo ............old password .is........."+oldpass);
	    		
	    		pstmt=con.prepareStatement("update userdetails set password=? where loginid=? and password=?");
	    		pstmt.setString(1, newpass);
	    		pstmt.setString(2, user);
	    		pstmt.setString(3, oldpass);
	    		int c=pstmt.executeUpdate();
	    		if(c>0){
	    			flag=true;
	    			con.commit();
	    		}
	    	}catch(SQLException e){
	    		e.printStackTrace();
	    	}
	    	return flag;
	    }
	 
	 
	 public RegisterFormBean getprofile(String name,String path)
	    {
			
	    	RegisterFormBean rb=null;
			
			
			String userid="";
			
			
			try {
				
				pstmt = con.prepareStatement("select u.userid,u.logintype,u.firstname,u.lastname,TO_CHAR(u.dob,'DD-MM-YYYY'),u.emailid,u.photo,a.PHNO,a.houseno,a.street,a.city,a.state,a.country,a.pincode from userdetails u ,addresses a where u.logintype =? and u.userid=a.USERIDREF and u.loginid=?");
				
				pstmt.setString(1,"student");
				pstmt.setString(2, name);
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
					
					rb.setMobile(rs.getString(8));
					
					rb.setHno(rs.getString(9));
					rb.setStreet(rs.getString(10));
					rb.setCity(rs.getString(11));
					rb.setState(rs.getString(12));
					rb.setCountry(rs.getString(13));
					rb.setPin(rs.getString(14));
					
					}
					
				}	
	    	}
	    	catch(SQLException se)
	    	{
	    		//LoggerManager.writeLogWarning(se);
	    	}
	    	catch(Exception e)
	    	{
	    	//	LoggerManager.writeLogWarning(e);
	    	}
	    	
	    	return rb;
	    }  
		
	 public boolean changeQuestion(RegisterFormBean rto)
	 {
		 boolean flag=true;
		 
		 try{
			 
			 
			
			 
			 String question=rto.getQuestn();
			 System.out.println("in Dao qusetion is..."+question);
			 String ans=rto.getAnsr();
			 System.out.println("in Dao ans is..."+ans);
			 String loginid=rto.getUserid();
			 System.out.println("in Dao loginid is..."+loginid);
			 String pwd=rto.getUserpwd();
			 System.out.println("in Dao pwd is..."+pwd);
			 
			 pstmt=con.prepareStatement("update userdetails set forgotpwquestion=?,forgotpwanswer=? where loginid=? and password=?");
			 pstmt.setString(1, question);
			 pstmt.setString(2, ans);
			 pstmt.setString(3, loginid);
			 pstmt.setString(4, pwd);
			 
			 int update=pstmt.executeUpdate();
			 
			 
			 if(update>0)
	         {
	         
	          con.commit();
	         }
	         else
	         {
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
		 catch(SQLException e){}
		}
	return flag;
}
	
	 
	 public boolean CollegeChangePass(RegisterFormBean rto){
		 
		 boolean flag=false;
		 
		 try{
		 String newpass=rto.getNewpassword();
 		System.out.println("in DAO class//////////////////"+newpass);
 		String user=rto.getUsername();
 		System.out.println("in DAo ............userid .is........."+user);
 		
 		pstmt=con.prepareStatement("update collegedetails set password=? where loginid=?");
 		pstmt.setString(1, newpass);
 		pstmt.setString(2, user);
 		int c=pstmt.executeUpdate();
 		if(c>0){
 			flag=true;
 			con.commit();
 		}
 	}catch(SQLException e){
 		e.printStackTrace();
 	}
 	return flag;
		 
		 
		 
		 
		 
	 }
	
}
