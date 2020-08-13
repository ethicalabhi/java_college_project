package com.college.ServiceImpl;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.college.DaoI.CourseDAOI;
import com.college.DaoImpl.CourseDaoImpl;
import com.college.FormBean.CourseFormBean;
import com.college.FormBean.NotificationBean;
import com.college.FormBean.TransactionFormBean;
import com.college.ServiceI.CourseServiceI;


public class CourseServiceImpl implements CourseServiceI{
	
	CourseDAOI cdao=new CourseDaoImpl();
	
	boolean flag=false;
	
	Vector<CourseFormBean> vcto=null;
	Vector<NotificationBean> vato=null;

	public boolean insertCourse(CourseFormBean cb){
		
		flag=cdao.insertCourse(cb);
		
		return flag;
		}
public boolean insertfacultysubjects(CourseFormBean cb){
		
		flag=cdao.insertfacultysubjects(cb);
		
		return flag;
		}
	
	public boolean deleteCourse(int courseid) {
		
		flag= cdao.deleteCourse(courseid);
		
			return flag;
		
	}
	public Vector<CourseFormBean> viewCourse(){
		
		vcto= cdao.viewCourse();
		
	
		return vcto;
		
		
		
		
	}
	public Vector<CourseFormBean> viewCourseAt(int cid){
		
	   vcto= cdao.viewCourseAt(cid);
      
		return vcto;
		
		
	}
	public boolean updateCourse(CourseFormBean cb){
		
		flag= cdao.updateCourse(cb);
		
		
		return flag;
		
		
		
		
	}
	
	

	
	public Vector<CourseFormBean> viewDepartmentAt(int cid){
		
	   vcto= cdao.viewDepartmentAt(cid);
      
		return vcto;
		
		
	}
	public boolean updateDepartment(CourseFormBean cb){
		
		flag= cdao.updateDepartment(cb);
		
		
		return flag;
		
		
		
		
	}
	
	public Vector<CourseFormBean> viewBranchAt(int cid){
		
		   vcto= cdao.viewBranchAt(cid);
	      
			return vcto;
			
			
		}
		public boolean updateBranch(CourseFormBean cb){
			
			flag= cdao.updateBranch(cb);
			
			
			return flag;
			
			
			
			
		}
		public Vector<CourseFormBean> viewFeeAt(int cid){
			
			   vcto= cdao.viewFeeAt(cid);
		      
				return vcto;
				
				
			}
			public boolean updateFee(CourseFormBean cb){
				
				flag= cdao.updateFee(cb);
				
				
				return flag;
				
				
				
				
			}
	
	
	public boolean insertNotification(NotificationBean ab) throws FileNotFoundException{
		
		flag= cdao.insertNotification(ab);
		
		return flag;
		}
	public Vector<NotificationBean> viewNotification(int cid,String path) throws FileNotFoundException{
		
	       vato= cdao.viewNotification(cid,path);
	   
	      return vato;
	      }
	public Vector<NotificationBean> viewAllNotification(String path) throws FileNotFoundException{
		
		vato= cdao.viewAllNotification(path);
		 
			   return vato;
			   }
	public boolean uploadQpaper(CourseFormBean cb)throws FileNotFoundException {
		
		flag= cdao.uploadQpaper(cb);
		
		return flag;
		
	}
	public Vector<CourseFormBean> viewQpaper(String path,int cid,int subid){
		
		vcto= cdao.viewQpaper(path, cid,subid);
		
		
		      return vcto;
		
	}
	
	
	public boolean insertSubject(CourseFormBean cb){
		
		
		flag=cdao.insertSubject(cb);
		return flag;
		
	}
public boolean insertBranch(CourseFormBean cb){
		
		
		flag=cdao.insertBranch(cb);
		return flag;
		
	}
public boolean insertDepartment(CourseFormBean cb){
	
	
	flag=cdao.insertDepartment(cb);
	return flag;
	
}
public boolean insertFee(CourseFormBean cb){
	
	
	flag=cdao.insertFee(cb);
	return flag;
	
}
	public boolean deleteSubject(int subid){
		
		flag=cdao.deleteSubject(subid);
		return flag;
		
	}
	
	
public boolean deleteDepartment(int subid){
		
		flag=cdao.deleteDepartment(subid);
		return flag;
		
	}
public boolean deleteBranch(int subid){
	
	flag=cdao.deleteBranch(subid);
	return flag;
	
}
public boolean deleteFee(int subid){
	
	flag=cdao.deleteFee(subid);
	return flag;
	
}
	public Vector<CourseFormBean> viewSubject(){
		
		vcto=cdao.viewSubject();
		return vcto;
	}
public Vector<CourseFormBean> viewDepartment(){
		
		vcto=cdao.viewDepartment();
		return vcto;
	}
public Vector<CourseFormBean> viewBranch(){
	
	vcto=cdao.viewBranch();
	return vcto;
}
public Vector<CourseFormBean> viewFee(){
	
	vcto=cdao.viewFee();
	return vcto;
}
	public Vector<CourseFormBean> viewSubjectAt(int sid){
		
		vcto=cdao.viewSubjectAt(sid);
		return vcto;
		
	}
	public boolean updateSubject(CourseFormBean cb){
		
		flag=cdao.updateSubject(cb);
		return flag;
		
	}
	
	public Vector<CourseFormBean> viewAllQpaper(String path){
		
		return cdao.viewAllQpaper(path);
		
	}
	public boolean insertFee(TransactionFormBean cb) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
