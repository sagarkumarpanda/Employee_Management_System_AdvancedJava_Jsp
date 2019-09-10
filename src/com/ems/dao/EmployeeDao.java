package com.ems.dao;

import java.sql.*;
import java.util.*;
import com.ems.model.Employee;

public interface EmployeeDao{
	public Connection getConnection() throws SQLException;
	public boolean saveEmployee(Employee e) throws SQLException;
	public boolean deleteEmployee(String EmpId) throws SQLException;
	public Employee getEmployee(String empid) throws SQLException;
	public List<Employee> getAllEmployees() throws Exception;
	public boolean updateEmployee(Employee emp) throws SQLException;	
	}




