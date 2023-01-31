package com.vaibhav.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaibhav.demo.model.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
	//get Emplyee
	@Query(value = "select * from employee where is_deleted = 0",nativeQuery = true)
	public List<Employee> getEmployees();
	
	//delete Employee
	@Modifying
	@Transactional
	@Query(value = "update employee set is_deleted = 1 where employee_id = ?1",nativeQuery = true)
	public int deleteEmployee(long employeeId);
	
	
	// get by Id
	@Query(value = "select * from employee where is_deleted = 0 and employee_id = ?1",nativeQuery = true)
	public Employee getEmployeeById(long employeeId);

}
