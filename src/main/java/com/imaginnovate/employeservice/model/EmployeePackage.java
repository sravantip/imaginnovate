package com.imaginnovate.employeservice.model;

public class EmployeePackage {

	private int empCode;
	private String firstName;
	private String lastName;
	private double salary;
	private double tax;
	private Double cess;

	
	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int employeeCode) {
		this.empCode = empCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double yearlySalary) {
		this.salary = salary;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public Double getCess() {
		return cess;
	}

	public void setCess(Double cess) {
		this.cess = cess;
	}

}
