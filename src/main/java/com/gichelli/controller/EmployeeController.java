package com.gichelli.controller;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gichelli.errors.NotFound;
import com.gichelli.model.Employee;
import com.gichelli.service.EmployeeService;







@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//get all the employees
	@GetMapping(value = "/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	//get one employee
	@GetMapping(value = "/employees/{employeeId}")
	//@ResponseStatus(HttpStatus.OK)
	public Optional<Employee> getEmployee(@PathVariable Long employeeId) {
		if(employeeService.exist(employeeId))
			return employeeService.getEmployee(employeeId);
		else
			throw new NotFound("Employee does not exist");
		
	}
	

	//create a new employee
	 @PostMapping(value = "/employees")
	 //@ResponseStatus(HttpStatus.CREATED)
	 public void addEmployee(@RequestBody Employee employee) {	 
		 employeeService.addEmployee(employee);
	 }
	 

	//delete a employee
	@DeleteMapping(value = "/employees/{employeeId}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable Long employeeId) throws Exception {
		try {
			if(!employeeService.equals(null))
				employeeService.deleteEmployee(employeeId);
		}catch(Exception e) {
			throw new NotFound("Error cannot delete, there is no such user in the database");
		}
	}
		
	//replace all fields in one employee
	@PutMapping(value = "/employees/{employeeId}")
	//@ResponseStatus(HttpStatus.OK)
	 public void putEmployee(@RequestBody Employee employee, @PathVariable Long employeeId) {
		if(employeeService.exist(employeeId))
			employeeService.putEmployee(employeeId, employee);
		else
			throw new NotFound("Employee does not exist");
	}
	 
	 
	//make changes just to an specific or specific fields in one employee
	@PatchMapping(value = "/employees/{employeeId}")
	 public void updateEmployee(@RequestBody Employee employee, @PathVariable Long employeeId) {
		if(employeeService.exist(employeeId))	
			employeeService.patchEmployee(employeeId, employee);
		else
			throw new NotFound("Employee does not exist");
	}
	
	
	

}
