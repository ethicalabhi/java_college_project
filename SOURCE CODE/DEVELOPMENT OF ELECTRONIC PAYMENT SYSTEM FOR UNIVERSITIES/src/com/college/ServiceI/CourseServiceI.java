package com.college.ServiceI;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.college.FormBean.CourseFormBean;
import com.college.FormBean.NotificationBean;



public interface CourseServiceI {
	
	
	public boolean insertCourse(CourseFormBean cb);
	public boolean insertfacultysubjects(CourseFormBean cb);
	public boolean deleteCourse(int courseid);
	public boolean deleteDepartment(int courseid);
	public boolean deleteFee(int courseid);
	public boolean deleteBranch(int courseid);
	public Vector<CourseFormBean> viewCourse();
	public Vector<CourseFormBean> viewCourseAt(int cid);
	public Vector<CourseFormBean> viewDepartmentAt(int did);
	public Vector<CourseFormBean> viewBranchAt(int bid);
	public Vector<CourseFormBean> viewFeeAt(int fid);
	public boolean updateCourse(CourseFormBean cb);
	public boolean updateDepartment(CourseFormBean cb);
	public boolean updateBranch(CourseFormBean cb);
	public boolean updateFee(CourseFormBean cb);
	public boolean insertNotification(NotificationBean ab)throws FileNotFoundException;
	public Vector<NotificationBean> viewNotification(int cid,String path) throws FileNotFoundException;
	public Vector<NotificationBean> viewAllNotification(String path)throws FileNotFoundException;
	public boolean uploadQpaper(CourseFormBean cb)throws FileNotFoundException;
	public Vector<CourseFormBean> viewQpaper(String path,int cid,int subid);
	
	
	public boolean insertSubject(CourseFormBean cb);
	public boolean insertDepartment(CourseFormBean cb);
	public boolean insertBranch(CourseFormBean cb);
	public boolean insertFee(CourseFormBean cb);
	public boolean deleteSubject(int subid);
	public Vector<CourseFormBean> viewSubject();
	public Vector<CourseFormBean> viewDepartment();
	public Vector<CourseFormBean> viewFee();
	public Vector<CourseFormBean> viewBranch();

	public Vector<CourseFormBean> viewSubjectAt(int sid);
	public boolean updateSubject(CourseFormBean cb);
	public Vector<CourseFormBean> viewAllQpaper(String path);

}
