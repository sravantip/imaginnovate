package com.imaginnovate.employeservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imaginnovate.employeservice.service.EmployeeTaxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imaginnovate.employeservice.model.Employee;
import com.imaginnovate.employeservice.model.EmployeePackage;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeTaxServiceImpl employeeTaxServiceImpl;

	@PostMapping(path = "/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		int empId = employeeTaxServiceImpl.saveEmployee(employee);
		return ResponseEntity.ok("Employee details saved successfully with Id : "+ empId);
	}
	
	
	@GetMapping(path = "/getTax")
	public ResponseEntity<List<EmployeePackage>> getTax(@RequestParam @javax.validation.constraints.Pattern(regexp="\\d{4}") String year) {
		List<EmployeePackage> employeesList = employeeTaxServiceImpl.getEmployeeTax(year);
		System.out.println("Employee tax details are : "+employeesList);
		return ResponseEntity.ok(employeesList);
	}

}
