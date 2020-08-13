package com.college.Mgrdelegate;

import java.util.Vector;

import com.college.FormBean.ExamFormBean;
import com.college.ServiceI.ExamServiceI;
import com.college.ServiceImpl.ExamServiceImpl;



public class ExamMgrDelegate {
	
	ExamServiceI esi=new ExamServiceImpl();

	public boolean scheduleExam(ExamFormBean eb){
		return esi.scheduleExam(eb);
		
	}
	public Vector<ExamFormBean> viewSchedule(){
		return esi.viewSchedule();
	}
	
	public boolean insertCircular(ExamFormBean eb){
		return esi.insertCircular(eb);
	}
	public Vector<ExamFormBean> viewCircular(String path) throws Exception{
		
		return esi.viewCircular(path);
	}
	
}
