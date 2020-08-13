package com.college.DaoI;

import com.college.Util.CoreList;

public interface UserDAoI {
	
	
	public CoreList getEmployees(String path);
	
	public CoreList getStudents(String path);

	public boolean deleteEmployee(int cid,String login);
	public boolean deleteCollege(int cid,int uid);

	public CoreList getFaculties(String path);

}
