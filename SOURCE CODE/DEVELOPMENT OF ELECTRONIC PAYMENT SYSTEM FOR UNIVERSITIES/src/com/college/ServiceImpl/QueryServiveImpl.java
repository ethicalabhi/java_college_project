package com.college.ServiceImpl;

import java.util.Vector;

import com.college.DaoI.QueryDAOI;
import com.college.DaoImpl.QueryDaoImpl;
import com.college.FormBean.QueryFormBean;
import com.college.ServiceI.QueryServiceI;


public class QueryServiveImpl implements QueryServiceI{

	QueryDAOI qdao=new QueryDaoImpl();
	
	Vector<QueryFormBean> vqto=null;
	
	boolean flag=false;

	public Vector<QueryFormBean> getQueries() {
		
		vqto=qdao.getQueries();
		
		
			      return vqto;
	
	}

	public Vector<QueryFormBean> getQueriesAt(int qid1) {
		
		vqto=qdao.getQueriesAt(qid1);
		
			      return vqto;

	}

	public boolean insertQuery(QueryFormBean qfb)  {
		
		flag=qdao.insertQuery(qfb);
		
		
		return flag;
	
	}
	
	
	
	
	

}
