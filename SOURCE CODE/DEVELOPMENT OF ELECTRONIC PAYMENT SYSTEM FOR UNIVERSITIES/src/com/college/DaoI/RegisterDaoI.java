package com.college.DaoI;

import java.io.FileNotFoundException;

import com.college.FormBean.RegisterFormBean;




public interface RegisterDaoI {

	 public boolean insertNewUser(RegisterFormBean rto)throws FileNotFoundException;
	 
	 public void logout1(String user);
	 public boolean logout(String loginid);
	 public String passwordRecovery(RegisterFormBean rto);
	 
	 public boolean checkAvailability(String userid);
	 public double checkbalAvailability(String userid);
	 public boolean changePass(RegisterFormBean rto);
	 public boolean changeQuestion(RegisterFormBean rto);
	 
	 public boolean RegisterStudent(RegisterFormBean cp) throws FileNotFoundException;
	 public boolean CollegeChangePass(RegisterFormBean rto);
	
	
}
