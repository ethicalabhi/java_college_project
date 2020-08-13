package com.college.ServiceImpl;

import java.util.Vector;

import com.college.DaoI.ExamDAOI;
import com.college.DaoImpl.ExamDaoImpl;
import com.college.FormBean.ExamFormBean;
import com.college.ServiceI.ExamServiceI;



public class ExamServiceImpl implements ExamServiceI{
	
	ExamDAOI edao=new ExamDaoImpl();
	
	Vector<ExamFormBean> veto=null;
	boolean flag=false;
	
	public boolean scheduleExam(ExamFormBean eb){
		
		return edao.scheduleExam(eb);
		
		
	}
	public Vector<ExamFormBean> viewSchedule(){
		return edao.viewSchedule();
	}
	
	public boolean insertCircular(ExamFormBean eb){
		return edao.insertCircular(eb);
		
	}
	public Vector<ExamFormBean> viewCircular(String path) throws Exception{
		
		return edao.viewCircular(path);
		
	}
	
	
	

}
