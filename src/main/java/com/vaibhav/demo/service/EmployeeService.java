package com.vaibhav.demo.service;

import java.util.List;

import com.vaibhav.demo.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(String employeeName,double employeeSalary);

	List<Employee> getEmployees();

	int deleteEmployee(long parseLong);

	Employee getEmployeeById(long parseLong);

}
