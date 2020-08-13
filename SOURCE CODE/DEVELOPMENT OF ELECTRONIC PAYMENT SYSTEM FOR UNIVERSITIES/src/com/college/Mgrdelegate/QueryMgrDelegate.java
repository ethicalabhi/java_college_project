package com.college.Mgrdelegate;

import java.util.Vector;

import com.college.FormBean.QueryFormBean;
import com.college.ServiceI.QueryServiceI;
import com.college.ServiceImpl.QueryServiveImpl;



public class QueryMgrDelegate {
	
	QueryServiceI qsi=new QueryServiveImpl();
	
	public Vector<QueryFormBean> getQueries()  {
		
		return qsi.getQueries();
	}
	public Vector<QueryFormBean> getQueriesAt(int qid1)  {
		return qsi.getQueriesAt(qid1);
	}
	public boolean insertQuery(QueryFormBean qfb)  {
     return qsi.insertQuery(qfb);
     }
}