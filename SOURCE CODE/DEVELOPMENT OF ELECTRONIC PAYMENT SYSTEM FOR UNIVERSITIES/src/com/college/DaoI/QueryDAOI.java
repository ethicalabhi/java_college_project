package com.college.DaoI;

import java.util.Vector;

import com.college.FormBean.QueryFormBean;




public interface QueryDAOI {
	
	
	public boolean insertQuery(QueryFormBean qfb);
	public Vector<QueryFormBean> getQueries();
	public Vector<QueryFormBean> getQueriesAt(int qid1);

}
