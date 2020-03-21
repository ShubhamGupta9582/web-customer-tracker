package com.crm.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String user = "springstudent";
		String pass = "springstudent";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to Database: " + jdbcUrl);
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			con.close();
			
			out.println("SUCCESS!!!");
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	
	}

}
