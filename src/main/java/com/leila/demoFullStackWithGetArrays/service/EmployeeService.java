package com.leila.demoFullStackWithGetArrays.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leila.demoFullStackWithGetArrays.Repository.EmployeeRepository;
import com.leila.demoFullStackWithGetArrays.execption.UserNotFoundException;
import com.leila.demoFullStackWithGetArrays.model.Employee;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return repo.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return repo.findAll();
	}
	
	public Employee UpdateEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		return repo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User  " + id + " was not found"));
	}
	
	public void deleteEmployee(Long id) {
		repo.deleteEmployeeById(id);
	}
	

}
