package com.college.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.college.DaoI.QueryDAOI;
import com.college.FormBean.QueryFormBean;
import com.college.db.ConnectionFactory;




public class QueryDaoImpl implements QueryDAOI{
	
	
	
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	public QueryDaoImpl(){
		
		con = ConnectionFactory.getConnection();	
	}
	public boolean insertQuery(QueryFormBean qfb)
	{
		boolean flag=true;
		int cid=0;
		
		try{
			pstmt=con.prepareStatement("insert into query values((select nvl(max(queryid),1000)+1 from query),?,?,?,?,sysdate)");
		String query=qfb.getQuery();
		System.out.println("in Dao query is ......"+query);
		String status="insolved";
		
		String from=qfb.getFrom();
		String to=qfb.getTo();
		stmt=con.createStatement();
		rs=stmt.executeQuery("select userid from userdetails where loginid="+"'"+from+"'");
		
		if(rs.next())
			
		 cid=rs.getInt(1);
		System.out.println("in DAo from userdetails userid is........"+cid);
		
		pstmt.setString(1, to);
		pstmt.setInt(2, cid);
		pstmt.setString(3, query);
		pstmt.setString(4, status);

		
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

	public Vector<QueryFormBean> getQueries()
	{
		Vector<QueryFormBean> vqb=null;
		String cname="";
		
		
		try{
			

			pstmt=con.prepareStatement("select queryid,useridref,query,qstatus,to_char(qdate,'dd-mm-yy') from query");
			
			rs=pstmt.executeQuery();
			
			 vqb=new Vector<QueryFormBean>();
			while(rs.next())
			{
				int qid=rs.getInt(1);
				int cid=rs.getInt(2);
				String query=rs.getString(3);
				String status=rs.getString(4);
				String date=rs.getString(5);
				
				stmt=con.createStatement();
				rs1=stmt.executeQuery("select firstname,lastname from userdetails where userid="+cid);
				if(rs1.next())
				 cname=rs1.getString(1);
				
				 QueryFormBean qf=new QueryFormBean();
				
				qf.setDate(date);
				qf.setQid(qid);
				qf.setCname(cname);
				qf.setQuery(query);
			
				qf.setQstatus(status);
				
				System.out.println("in DAo Status is .........."+status);
				
				vqb.add(qf);
			}
		}
		catch (SQLException e) {
		e.printStackTrace();
			
			System.out.println("Exception raised."+e);
		}
		return vqb;
		
		
	}
	
	
	public Vector<QueryFormBean> getQueriesAt(int qid1)
	{
		Vector<QueryFormBean> vqb=null;
		String cname="";
		
		
		try{
			
	
			pstmt=con.prepareStatement("select queryid,useridref,query,qstatus,TO_CHAR(qdate,'dd-mm-yyyy') from query where queryid=?");
			
			pstmt.setInt(1, qid1);
			rs=pstmt.executeQuery();
			
			 vqb=new Vector<QueryFormBean>();
			while(rs.next())
			{
				int qid=rs.getInt(1);
				int cid=rs.getInt(2);
				String query=rs.getString(3);
				String status=rs.getString(4);
				String date=rs.getString(5);
				
				stmt=con.createStatement();
				rs1=stmt.executeQuery("select firstname,lastname from userdetails where userid="+cid);
				if(rs1.next())
				 cname=rs1.getString(1);
				
				 QueryFormBean qf=new QueryFormBean();
				
				qf.setDate(date);
				qf.setQid(qid);
				qf.setCname(cname);
				qf.setQuery(query);
			
				qf.setQstatus(status);
				
				System.out.println("in DAo Status is .........."+status);
				
				vqb.add(qf);
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception raised."+e);
		}
		return vqb;
		}

}
