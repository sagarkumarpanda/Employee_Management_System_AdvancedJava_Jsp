package com.ems.service;
import java.util.*;
import com.ems.model.*;
import com.ems.dao.*;

import java.sql.*;
import java.time.*;
import com.ems.util.*;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao dao;
	Connection con;
	public EmployeeServiceImpl() throws SQLException {
		dao =  new EmployeeDaoImpl();
		con = dao.getConnection();
	}

	@SuppressWarnings("unused")
	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		LocalDate dob = emp.getDOB();
		boolean res = true;
		if(emp.getEmpName().length()<4||emp.getEmpName().length()>15) {
			res = false;
			throw new InvalidLengthException("Invalid Name");
		}
	
if(dob.isAfter(LocalDate.of(1995, 12, 31)) || dob.isBefore(LocalDate.of(1900, 1, 1))) {
			
			throw new InvalidDateException("Dob must be in range 1-1-1900 to 31-12-1995 ");
		}
		
		
		
		
		if((emp.getBasicSalary()<20000f)||(emp.getBasicSalary()>80000f)) {
			res = false;
			throw new InvalidSalaryException("Salary not in range");
		}
		
		
		
		return res;
	}

	@Override
	public String generateId(String empName) throws Exception{
		Random rand=new Random();
		String id = String.format("%04d", rand.nextInt(10000));
		String empCode = empName.substring(0, 2)+id;
		return empCode;
		
	}

	@Override
	public boolean save(Employee emp) throws Exception{
		if(validateEmployee(emp)) {
			return dao.saveEmployee(emp);
		}
		return false;
	}

	@Override
	public boolean delete(String empId) throws Exception {
			return dao.deleteEmployee(empId);
	}

	@Override
	public boolean update(Employee emp) throws Exception {
		if(validateEmployee(emp)) {
			return dao.updateEmployee(emp);
		}
		return false;
	}

	@Override
	public Employee getEmployee(String empId) throws Exception {
		return dao.getEmployee(empId);
	}

	@Override
	public List<Employee> getAllEmployees()  throws Exception{
		
			return dao.getAllEmployees();
	}

	public String generateID(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

}
