package com.college.ServiceImpl;

import com.college.DaoI.UserDAoI;
import com.college.DaoImpl.UserDaoImpl;
import com.college.ServiceI.UserServiceI;
import com.college.Util.CoreList;




public class UserServiceImpl implements UserServiceI{
	
	UserDAoI udao=new UserDaoImpl();
	
	boolean flag=false;

	public boolean deleteEmployee(int cid, String login)
			 {
		flag=udao.deleteEmployee(cid, login);
		   
			return flag;
		}

	public boolean deleteCollege(int cid, int uid)
			 {
		
		flag=udao.deleteCollege(cid, uid);
		
		 
			return flag;
		}

	public CoreList getEmployees(String path)  {
		
		CoreList cl=udao.getEmployees(path);
		
      
		      return cl;
		      }

	

	public CoreList getStudents(String path)  {
		
		
		CoreList cl=udao.getStudents(path);
		
		
		      return cl;
		}

	
	
	public CoreList getFaculties(String path)
	{CoreList cl=udao.getFaculties(path);
	return cl;
		
	}
	
	/*public CoreList getFaculties(String path) {
		
		CoreList cl=udao.getFaculties(path);
		return cl;
	}*/

	
	
	
	

}
