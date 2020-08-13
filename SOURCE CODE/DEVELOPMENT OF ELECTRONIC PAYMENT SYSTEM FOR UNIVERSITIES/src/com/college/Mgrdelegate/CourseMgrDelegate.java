package com.college.Mgrdelegate;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.college.FormBean.CourseFormBean;
import com.college.FormBean.NotificationBean;
import com.college.ServiceI.CourseServiceI;
import com.college.ServiceImpl.CourseServiceImpl;





public class CourseMgrDelegate {
    CourseServiceI csi=new CourseServiceImpl();
    
	public boolean insertCourse(CourseFormBean cb){
		return csi.insertCourse(cb);
	}
	public boolean insertfacultysubjects(CourseFormBean cb){
		return csi.insertfacultysubjects(cb);
	}
      public boolean deleteCourse(int courseid) {
		return csi.deleteCourse(courseid);
		}
 
      public boolean deleteDepartment(int courseid) {
  		return csi.deleteDepartment(courseid);
  		}
      public boolean deleteBranch(int courseid) {
  		return csi.deleteBranch(courseid);
  		}
      public boolean deleteFee(int courseid) {
  		return csi.deleteFee(courseid);
  		}
	public Vector<CourseFormBean> viewCourse(){
		return csi.viewCourse();
		}
	public Vector<CourseFormBean> viewCourseAt(int cid){
		return csi.viewCourseAt(cid);
	}
	public boolean updateCourse(CourseFormBean cb){
		return csi.updateCourse(cb);
	}
	
	public Vector<CourseFormBean> viewBranchAt(int cid){
		return csi.viewBranchAt(cid);
	}
	public boolean updateBranch(CourseFormBean cb){
		return csi.updateBranch(cb);
	}
	public Vector<CourseFormBean> viewDepartmentAt(int cid){
		return csi.viewDepartmentAt(cid);
	}
	public boolean updateDepartment(CourseFormBean cb){
		return csi.updateDepartment(cb);
	}
	public Vector<CourseFormBean> viewFeeAt(int cid){
		return csi.viewFeeAt(cid);
	}
	public boolean updateFee(CourseFormBean cb){
		return csi.updateFee(cb);
	}
   public boolean insertNotification(NotificationBean ab) throws FileNotFoundException{
		return csi.insertNotification(ab);
	}
	public Vector<NotificationBean> viewNotification(int cid,String path) throws FileNotFoundException{
		return csi.viewNotification(cid,path);
	}
	public Vector<NotificationBean> viewAllNotification(String path) throws FileNotFoundException{
		return csi.viewAllNotification(path);
	}
	public boolean uploadQpaper(CourseFormBean cb)throws FileNotFoundException{
		return csi.uploadQpaper(cb);
	}
	public Vector<CourseFormBean> viewQpaper(String path,int cid,int subid){
		return csi.viewQpaper(path, cid,subid);
	}
	
	public Vector<CourseFormBean> viewAllQpaper(String path){
		return csi.viewAllQpaper(path);
	}
	
	
	public boolean insertSubject(CourseFormBean cb){
		
		return csi.insertSubject(cb);
	}
     public boolean insertDepartment(CourseFormBean cb){
		
		return csi.insertDepartment(cb);
	}
     public boolean insertBranch(CourseFormBean cb){
 		
 		return csi.insertBranch(cb);
 	}
     public boolean insertFee(CourseFormBean cb){
 		
 		return csi.insertFee(cb);
 	}
	public boolean deleteSubject(int subid){
		return csi.deleteSubject(subid);
	}
	public Vector<CourseFormBean> viewSubject(){
		return csi.viewSubject();
	}
	public Vector<CourseFormBean> viewDepartment(){
		return csi.viewDepartment();
	}
	public Vector<CourseFormBean> viewBranch(){
		return csi.viewBranch();
	}
	public Vector<CourseFormBean> viewFee(){
		return csi.viewFee();
	}
		public Vector<CourseFormBean> viewSubjectAt(int sid){
		
		return csi.viewSubjectAt(sid);
	}
	public boolean updateSubject(CourseFormBean cb){
		
		return csi.updateSubject(cb);
	}
	
}
