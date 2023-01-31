package com.vaibhav.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.demo.model.Employee;
import com.vaibhav.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(String employeeName, double employeeSalary) {

		Employee emp = new Employee();
		emp.setEmployeeName(employeeName);
		emp.setEmployeeSalary(employeeSalary);

		Employee empNew = employeeRepository.save(emp);
		return empNew;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.getEmployees();
	}

	@Override
	public int deleteEmployee(long parseLong) {
		// TODO Auto-generated method stub
		return employeeRepository.deleteEmployee(parseLong);
	}

	@Override
	public Employee getEmployeeById(long parseLong) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeById(parseLong);
	}
}
