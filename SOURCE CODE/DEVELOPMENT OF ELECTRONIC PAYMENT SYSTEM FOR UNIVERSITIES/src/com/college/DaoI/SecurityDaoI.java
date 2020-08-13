package com.college.DaoI;

import java.util.Vector;

import com.college.FormBean.LoginForm;




public interface SecurityDaoI {
	
	
	 public Vector<LoginForm> loginCheck(LoginForm lto);
	 public void loginaudit(String loginid);
	 

	

}
