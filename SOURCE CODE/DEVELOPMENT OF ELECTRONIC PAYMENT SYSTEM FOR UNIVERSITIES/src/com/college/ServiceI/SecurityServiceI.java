package com.college.ServiceI;

import java.util.Vector;

import com.college.FormBean.LoginForm;


public interface SecurityServiceI {
	
	 public Vector<LoginForm> loginCheck(LoginForm lto);
	 public void loginaudit(String loginid);

}
