package com.college.DaoI;

import java.util.Vector;

import com.college.FormBean.FeedBackFormBean;




public interface FeedbackDAOI {

	public boolean insertFeedBack(FeedBackFormBean fb);
	public Vector<FeedBackFormBean>  getFeedBack(int fid);
	public Vector<FeedBackFormBean>  getAllFeedBack();
	public boolean cancelFeedBack(int fid);
	
	
}
