package com.college.DaoI;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.college.FormBean.CourseFormBean;
import com.college.FormBean.NotificationBean;




 public interface CourseDAOI {

	public boolean insertCourse(CourseFormBean cb);
	public boolean insertBranch(CourseFormBean cb);
	public boolean insertDepartment(CourseFormBean cb);
	public boolean insertFee(CourseFormBean cb);
	public boolean insertfacultysubjects(CourseFormBean cb);
	public boolean deleteCourse(int courseid);
	public Vector<CourseFormBean> viewCourse();
	public Vector<CourseFormBean> viewCourseAt(int cid);
	public Vector<CourseFormBean> viewDepartmentAt(int cid);
	public Vector<CourseFormBean> viewBranchAt(int cid);
	public Vector<CourseFormBean> viewFeeAt(int cid);
	public boolean updateCourse(CourseFormBean cb);
	public boolean updateDepartment(CourseFormBean cb);
	public boolean updateBranch(CourseFormBean cb);
	public boolean updateFee(CourseFormBean cb);
	public boolean insertSubject(CourseFormBean cb);
	public boolean deleteSubject(int subid);
	public boolean deleteDepartment(int subid);
	public boolean deleteBranch(int subid);
	public boolean deleteFee(int subid);
	public Vector<CourseFormBean> viewSubject();
	public Vector<CourseFormBean> viewDepartment();
	public Vector<CourseFormBean> viewBranch();
	public Vector<CourseFormBean> viewFee();
	public Vector<CourseFormBean> viewSubjectAt(int sid);
	public boolean updateSubject(CourseFormBean cb);
	
	public boolean insertNotification(NotificationBean ab)throws FileNotFoundException;
	public Vector<NotificationBean> viewNotification(int cid,String path) throws FileNotFoundException;
	public Vector<NotificationBean> viewAllNotification(String path)throws FileNotFoundException;
	public boolean uploadQpaper(CourseFormBean cb)throws FileNotFoundException;
	public Vector<CourseFormBean> viewQpaper(String path,int cid,int subid);
	
	public Vector<CourseFormBean> viewAllQpaper(String path);

   }  
