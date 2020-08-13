

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;

import com.college.db.ConnectionFactory;
import com.college.FormBean.RegisterFormBean;
import com.college.FormBean.TransactionFormBean;
import com.college.Util.CoreList;
import com.college.Util.DateWrapper;
import com.college.Util.LoggerManager;

public class Database {
	Statement st;
	ResultSet rs;
	Connection conn;

	

	  public Connection getConnection()throws ClassNotFoundException {
		Connection con=null;
		try{
			con=ConnectionFactory.getConnection();
		}catch(Exception e){
			
		}
		return con;
		} 

	
}
