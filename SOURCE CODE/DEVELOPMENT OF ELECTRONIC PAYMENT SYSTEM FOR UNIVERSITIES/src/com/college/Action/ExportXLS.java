package com.college.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExportXLS extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("application/vnd.ms-excel");
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession();
		String report = (String)session.getAttribute("Report");
		pw.print(report);
		pw.close();
	}
}
