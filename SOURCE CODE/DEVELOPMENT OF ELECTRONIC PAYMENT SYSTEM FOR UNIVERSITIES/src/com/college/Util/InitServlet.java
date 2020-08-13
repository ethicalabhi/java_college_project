package com.college.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import com.college.db.ConnectionFactory;




public class InitServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4687490192082358340L;
	ConnectionFactory dobject;

	public void init(ServletConfig sc)
	{
		ServletContext ctx = sc.getServletContext();
		InputStream fis = ctx.getResourceAsStream(sc.getInitParameter("config"));
		Properties props = new Properties();
		
		try
		{
			props.load(fis);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		dobject = new ConnectionFactory();
		dobject.setProperties(props);

		LoggerManager.logger = new LoggerManager().getLogger(props.getProperty("logfile"));
		LoggerManager.writeLogInfo("Logger Instantiated");

		}
}
