package com.college.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.college.DaoI.SolutionDAOI;
import com.college.FormBean.SolutionFormBean;
import com.college.db.ConnectionFactory;




public class SolutionDaoImpl implements SolutionDAOI {

	
	
	
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	
	
	
	public SolutionDaoImpl(){
		con=ConnectionFactory.getConnection();
		}
	
	public boolean insertSolution(SolutionFormBean sf)
	{
		
		boolean flag=true;
		
		int update=0;
		try{
		
			pstmt=con.prepareStatement("insert into solution values(?,?,?)");
			
			int qid=sf.getQid();
			 String sdate=sf.getRdate();
			 System.out.println("in DAo date is..........."+sdate);
			 String solution=sf.getSolution();
			 
			 pstmt.setInt(1, qid);
			 pstmt.setString(2,  sdate);
			 pstmt.setString(3, solution);
			 
			 int insert=pstmt.executeUpdate();
			 
			 
			 if(insert>0)
			 {
				 stmt=con.createStatement();
				update=stmt.executeUpdate("update query set qstatus='solved' where queryid="+qid);
			
				
				 
			 }
			 
			
			
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

		
		public Vector<SolutionFormBean> getQueryStatus(String login)
		{
			
			Vector<SolutionFormBean> vsb=null;
			
		
			
			try{
				
	
				
				/*pstmt=con.prepareStatement("select userid from userdetails where loginid=?");
				
				String login=sfb.getFrom();
				pstmt.setString(1, login);
				rs=pstmt.executeQuery();
				if(rs.next())
					
				 uid=rs.getInt(1);
				
				stmt=con.createStatement();
				rs=stmt.executeQuery("select queryid from query where userid="+uid);
				
				if(rs.next())
					
					 id=rs.getInt(1);
				*/
				
				
				pstmt=con.prepareStatement("select q.queryid,q.useridref,q.queryto,q.query,TO_CHAR(q.qdate,'DD-MM-YYYY'),s.soldate,s.solution ,c.userid,q.qstatus from query q , solution s ,userdetails c where q.queryid=s.queryidref and q.USERIDREF=c.userid and c.loginid=?");
				
                  
				
				System.out.println("in Solution DAo loginid is..........."+login);
				
				pstmt.setString(1,login);
				
				rs=pstmt.executeQuery();
				
				vsb=new Vector<SolutionFormBean>();
				String cname="";
				while(rs.next())
				{
					
					int qid=rs.getInt(1);
					int quid=rs.getInt(2);
					String queryto=rs.getString(3);
					String description=rs.getString(4);
					String qdate=rs.getString(5);
					String sdate=rs.getString(6);
					String solution=rs.getString(7);
					int userid=rs.getInt(8);
					String status=rs.getString(9);
					
						SolutionFormBean sb=new SolutionFormBean();
					
					sb.setQid(qid);
					sb.setRdate(sdate);
					sb.setSolution(solution);
					sb.setQuery(description);
					sb.setRdate(qdate);
					sb.setUserid(userid);
					sb.setQuid(quid);
					sb.setTo(queryto);
					sb.setStatus(status);
				
					vsb.add(sb);
					
				}
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			return vsb;
		}
	
	
		
		
		public Vector<SolutionFormBean> getSolution(int qid,String login)
		{
			
			Vector<SolutionFormBean> vsb=null;
			
		
			
			try{
				
			pstmt=con.prepareStatement("select q.queryid,q.query,TO_CHAR(q.qdate,'DD-MM-YYYY'),TO_CHAR(s.soldate,'DD-MM-YYYY'),s.solution ,q.qstatus from query q , solution s  where q.queryid=s.queryidref and s.queryidref=? ");
				System.out.println("in Dao Class Query id is ........"+qid);
				
				
				pstmt.setInt(1, qid);
			//	pstmt.setString(2, login);
				System.out.println("in Dao Class login id is ........"+login);
				
				rs=pstmt.executeQuery();
				
				vsb=new Vector<SolutionFormBean>();
				String cname="";
				while(rs.next())
				{
					
					int qid1=rs.getInt(1);
					//int quid=rs.getInt(2);
					String description=rs.getString(2);
					String qdate=rs.getString(3);
					String sdate=rs.getString(4);
					String solution=rs.getString(5);
				//	int userid=rs.getInt(6);
					String status=rs.getString(6);
					
					
					SolutionFormBean sb=new SolutionFormBean();
					
					
					
					sb.setQid(qid1);
					sb.setRdate(sdate);
					sb.setSolution(solution);
					sb.setQuery(description);
					
					sb.setSdate(qdate);
					//sb.setUserid(userid);
				//	sb.setQuid(quid);
					sb.setStatus(status);
					sb.setCname(cname);
					
					vsb.add(sb);
					
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return vsb;
		}
	
	
	
}
