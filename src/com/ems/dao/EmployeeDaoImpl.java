package com.ems.dao;
import com.ems.model.Employee;
import java.util.*;
import java.sql.*;
import java.time.LocalDate;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Employee emp;
	public Connection getConnection() throws SQLException {
		
		con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","sagar","Sagar@1996");
		return con;
	}
	
	public boolean saveEmployee(Employee e) throws SQLException {
		con=getConnection();
		ps=con.prepareStatement("insert into Employee values(?,?,?,?)");
		ps.setString(1, e.getEmpId());
		ps.setString(2, e.getEmpName());
		LocalDate dobRaw = e.getDOB();
//		String strDate = dobRaw.getYear()+"-"+dobRaw.getMonthValue()+"-"+dobRaw.getDayOfMonth();
//		ps.setString(3,strDate);
		ps.setFloat(4,e.getBasicSalary());
		ps.setDate(3,new java.sql.Date(dobRaw.getYear(),dobRaw.getMonthValue(),dobRaw.getDayOfMonth()));
	
		
		int r=ps.executeUpdate();
		return r>0?true:false;
		
	}
	
	public boolean deleteEmployee(String EmpId) throws SQLException {
		con=getConnection();
		ps=con.prepareStatement("delete from Employee where EmpId=?");
		ps.setString(1, EmpId);
		
		int r=ps.executeUpdate();
		return r>0?true:false;
		
	}
	
	public Employee getEmployee(String empid) throws SQLException {
		con=getConnection();
		ps=con.prepareStatement("select * from Employee where EmpId=?");
		ps.setString(1, empid);
		rs=ps.executeQuery();
		if(rs.next())
		{
			java.sql.Date rowdate=rs.getDate(3);
			Employee emp=new Employee(rs.getString(1),rs.getString(2),LocalDate.of(rowdate.getYear(),rowdate.getMonth(),rowdate.getDate()),rs.getFloat(4));
			return emp;
		}
		return null;
	}
	
	public List<Employee> getAllEmployees() throws Exception{
		con=getConnection();
		ps=con.prepareStatement("select * from Employee");
		rs=ps.executeQuery();
		List<Employee> emplist= new ArrayList<>();
		while(rs.next()) {
			java.sql.Date rowdate=rs.getDate(3);
			Employee emp=new Employee(rs.getString(1),rs.getString(2),LocalDate.of(rowdate.getYear(),rowdate.getMonth(),rowdate.getDate()),rs.getFloat(4));
			emplist.add(emp);
		}
		return emplist;
	}
	public boolean updateEmployee(Employee emp) throws SQLException {
		con=getConnection();
		PreparedStatement ps = con.prepareStatement("Update Employee set Ename = ?,Dob=?,Salary=? where EmpId = ?");
		ps.setString(1,emp.getEmpName());
		LocalDate dobRaw = emp.getDOB();
		ps.setDate(2,new java.sql.Date(dobRaw.getYear(),dobRaw.getMonthValue(),dobRaw.getDayOfMonth()));
		ps.setFloat(3,emp.getBasicSalary());
		ps.setString(4, emp.getEmpId());
		int r=ps.executeUpdate();
		return r>0?true:false;
		
	}
}