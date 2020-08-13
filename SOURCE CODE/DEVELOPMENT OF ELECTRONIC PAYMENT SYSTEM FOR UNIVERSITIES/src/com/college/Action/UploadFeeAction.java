package com.college.Action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.college.DaoImpl.CourseDaoImpl;
import com.college.FormBean.CourseFormBean;
import com.college.Mgrdelegate.CourseMgrDelegate;

public class UploadFeeAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CourseFormBean cb = new CourseFormBean();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(cb, map);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
		String path = "";
		boolean flag = false;

		try {

			Vector<CourseFormBean> vqb = null;
			HttpSession session = request.getSession();
			String login = (String) session.getAttribute("loginuser");
			System.out.println(login);
			flag = new CourseDaoImpl().insertCourseFee(cb);

			if (flag) {
				vqb = new CourseDaoImpl().StudentFee(login);

			}

			System.out.println("in Action class vcb..........." + flag);

			if (!vqb.isEmpty()) {
				request.setAttribute("feeInfo", vqb);
				path = "Success.jsp";
				request.setAttribute("status", "Fees submited Successfully");
			} else {

				path = "Success.jsp";
				request.setAttribute("status", "some problem is there ");

			}

		} catch (Exception e) {
			e.printStackTrace();
			path = "Success.jsp";
			request.setAttribute("status", "No Fee info Available");
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
