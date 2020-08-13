package com.college.DaoI;

import java.util.Vector;

import com.college.FormBean.SolutionFormBean;




public interface SolutionDAOI {

	public boolean insertSolution(SolutionFormBean sf);
	public Vector<SolutionFormBean> getQueryStatus(String login);
	public Vector<SolutionFormBean> getSolution(int qid,String login);
}
