package com.vaibhav.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.demo.model.Employee;
import com.vaibhav.demo.service.EmployeeService;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// Save Employee
	@RequestMapping(value = "/save")
	public Employee saveEmployee(@RequestParam("employeeName") String employeeName,
			@RequestParam("employeeSalary") double employeeSalary) {

		Employee emp = employeeService.saveEmployee(employeeName, employeeSalary);
		return emp;
	}

	// Get List Of Employee
	@GetMapping(value = { "/list", "" })
	public List<Employee> getEmployees() {
		List<Employee> list = employeeService.getEmployees();
		return list;
	}

	// Delete Employee
	@GetMapping(value = { "/delete/{id}" })
	public String deletEmployee(@PathVariable("id") String employeeId) {
		String result = "false";
		if (StringUtils.isNotBlank(employeeId)) {
			try {
				int res = employeeService.deleteEmployee(Long.parseLong(employeeId));
				result = "true";
			} catch (Exception e) {
				e.printStackTrace();
				result = "false";
			}

		}
		return result;

	}

	// Get Employee By Id
	@GetMapping(value = { "/{id}" })
	public Employee getEmployeeById(@PathVariable("id") String employeeId) {
		Employee emp = null;
		if (StringUtils.isNotBlank(employeeId)) {
			try {
				emp = employeeService.getEmployeeById(Long.parseLong(employeeId));

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return emp;

	}
}
