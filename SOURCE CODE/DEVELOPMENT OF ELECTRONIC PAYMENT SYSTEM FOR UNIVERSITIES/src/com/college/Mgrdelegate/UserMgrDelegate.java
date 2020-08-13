package com.college.Mgrdelegate;

import com.college.ServiceI.UserServiceI;
import com.college.ServiceImpl.UserServiceImpl;
import com.college.Util.CoreList;


public class UserMgrDelegate {

	UserServiceI usi=new UserServiceImpl();
	
	public boolean deleteEmployee(int cid, String login)
	 {
		
		return usi.deleteEmployee(cid, login);
	}
	public boolean deleteCollege(int cid, int uid)
	 {
		return usi.deleteCollege(cid, uid);
	}
	public CoreList getEmployees(String path)  {
		return usi.getEmployees(path);
	}
	
	public CoreList getFaculties(String path)  {
		return usi.getFaculties(path);
	}
	
	public CoreList getStudents(String path)  {
		return usi.getStudents(path);
	}
	
}
