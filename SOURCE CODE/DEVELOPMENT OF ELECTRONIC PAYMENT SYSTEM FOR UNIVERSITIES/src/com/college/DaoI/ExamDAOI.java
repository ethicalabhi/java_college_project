package com.college.DaoI;


import java.util.Vector;

import com.college.FormBean.ExamFormBean;




public interface ExamDAOI {

	
	public boolean scheduleExam(ExamFormBean eb);
	public Vector<ExamFormBean> viewSchedule();
	
	public boolean insertCircular(ExamFormBean eb);
	public Vector<ExamFormBean> viewCircular(String path) throws Exception;
	
}
