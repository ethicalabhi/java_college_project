package com.college.ServiceI;

import java.util.Vector;

import com.college.FormBean.SolutionFormBean;


     public interface SolutionServiceI {
	public boolean insertSolution(SolutionFormBean sf);
	public Vector<SolutionFormBean> getQueryStatus(String login);
	public Vector<SolutionFormBean> getSolution(int qid,String login);
}
