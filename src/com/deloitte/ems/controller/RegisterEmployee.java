package com.deloitte.ems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class RegisterEmployee
 */
@WebServlet("/Register")
public class RegisterEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	EmployeeService es;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = "";
		String empID="";
		String empName = request.getParameter("empName");
		
		String strDate =request.getParameter("dob");
		System.out.println("strDate="+strDate);
		StringTokenizer stk = new StringTokenizer(strDate,"-");
		int date = Integer.parseInt(stk.nextToken());
		int month = Integer.parseInt(stk.nextToken());
		int year = Integer.parseInt(stk.nextToken());
		LocalDate dob = LocalDate.of(year, month, date);
		
		//LocalDate dob = request.getParameter("dob");
		float salary = Float.parseFloat(request.getParameter("basicSal"));
		try {
			es = new EmployeeServiceImpl();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			empID = es.generateId(empName);
			
		}catch(Exception e) {
			//response.sendRedirect("error.jsp");
			page = "error.jsp";
		}
		Employee emp = new Employee(empID,empName,dob,salary);
		try {
			 es.save(emp);
			page = "success.jsp";
			//response.sendRedirect("success.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			page = "error.jsp";
			//response.sendRedirect("error.jsp");
		}
		response.sendRedirect(page);
	}

}
