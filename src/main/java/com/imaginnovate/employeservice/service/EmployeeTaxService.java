package com.imaginnovate.employeservice.service;

import java.util.List;

import com.imaginnovate.employeservice.model.Employee;
import com.imaginnovate.employeservice.model.EmployeePackage;

public interface EmployeeTaxService {
	
	 public int saveEmployee(Employee employee);
	 
	 public List<EmployeePackage> getEmployeeTax(String year);

}
