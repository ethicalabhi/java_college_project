package com.college.ServiceI;

import java.util.Vector;

import com.college.FormBean.QueryFormBean;

public interface QueryServiceI {
	public boolean insertQuery(QueryFormBean qfb);
	public Vector<QueryFormBean> getQueries();
	public Vector<QueryFormBean> getQueriesAt(int qid1);
}
