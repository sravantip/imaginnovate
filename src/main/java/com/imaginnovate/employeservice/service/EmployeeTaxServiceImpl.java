package com.imaginnovate.employeservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.employeservice.model.Employee;
import com.imaginnovate.employeservice.model.EmployeePackage;
import com.imaginnovate.employeservice.repo.EmployeeRepo;
import com.imaginnovate.employeservice.service.EmployeeTaxService;

@Service
public class EmployeeTaxServiceImpl implements EmployeeTaxService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public int saveEmployee(Employee employee) {

        return employeeRepo.save(employee).getId();
    }

    private double getTax(double salary) {
        double tax = 0.0;
        try {
            if (salary <= 250000) {
                System.out.println("no Tax  employee salary is less than 2,50,000/-");
                tax = 0.0;
            } else if (salary > 250000 && salary <= 500000) {
                System.out.println(" employee salary is between 2,50,000/- and 5,00,000/-");
                tax = (salary - 250000) * 0.05;
                System.out.println(" calculated Tax is : "+tax);
            } else if (salary > 500000 && salary <= 100000) {
                tax = 12500 + (salary - 500000) * 0.1;
                System.out.println(" employee Tax is : "+tax);
            } else if (salary > 1000000) {
                tax = (salary - 1000000) * 0.2 + 62500;
                System.out.println(" employee Tax is : "+tax);
            }
            return tax;
        }catch(Exception e) {
            System.out.println("Exception while calculating employee tax : "+ e.getMessage());
        }
        return tax;
    }

    private Double getCess(double income) {
        double cess = 0.0;
        try {
            if (income > 2500000) {
                cess = income*0.02;
                System.out.println("cess amount is : "+cess);
            }
            return cess;
        }catch(Exception e) {
            System.out.println("Exception in Cess Method: "+ e.getMessage());
        }
        return cess;
    }

    @Override
    public List<EmployeePackage> getEmployeeTax(String fromYear) {

        List<EmployeePackage> empPackageList = new ArrayList<EmployeePackage>();
        String toYear = String.valueOf(Integer.parseInt(fromYear) + 1);
        Optional<List<Employee>> employee = employeeRepo.getEmployeeData(fromYear, toYear);
        if (employee.isPresent()) {
            List<Employee> empList = employee.get();
            for (Employee emp : empList) {
                EmployeePackage empPackage = new EmployeePackage();
                empPackage.setFirstName(emp.getFirstName());
                empPackage.setEmpCode(emp.getId());
                empPackage.setLastName(emp.getLastName());
                empPackage.setSalary(emp.getSal() * 12);
                empPackage.setTax(getTax(emp.getSal() * 12));
                empPackage.setCess(getCess(emp.getSal() * 12));
                empPackageList.add(empPackage);
            }
        }

        return empPackageList;
    }

}
