package com.ems.model;

import java.time.LocalDate;

public class Employee {
	
	private String empId;
	private String empName;
	LocalDate DOB;
	private float basicSalary;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", DOB=" + DOB + ", basicSalary=" + basicSalary
				+ "]";
	}
	public Employee(String empId, String empName, LocalDate dOB, float basicSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		DOB = dOB;
		this.basicSalary = basicSalary;
	}
	
	
	
	
}
