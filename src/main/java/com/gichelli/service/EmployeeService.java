package com.gichelli.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gichelli.model.Employee;
import com.gichelli.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Retrieve all rows from table and populate list with objects
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employees::add);
		System.out.println(employees.toString());
		return employees;

	}
	
	//Retrieves one row from table based on given id
	public Optional<Employee> getEmployee(Long employeeId) {
		return this.employeeRepository.findById(employeeId);
	}
	
	//Inserts row into table 
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	//delete one employee
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}

	//update values on one employee in the database. replace all values on one employee
	public void putEmployee(Long employeeId, Employee employee) {
		Optional<Employee> currentEmployee = employeeRepository.findById(employeeId);		
		if(currentEmployee.isPresent()) {
			Employee e1 = currentEmployee.get();
			
			e1.setFirstName(employee.getFirstName());
			e1.setLastName(employee.getLastName());
			e1.setStreetName(employee.getStreetName());
			e1.setStreetNumber(employee.getStreetNumber());
			
			employeeRepository.save(e1);
		}

	}
	
	//update only specific given fields on one employee
	public void patchEmployee(Long employeeId, Employee employee) {
		Optional<Employee> currentEmployee = employeeRepository.findById(employeeId);
		if(currentEmployee.isPresent()) {
			Employee e1 = currentEmployee.get();
		
			if(employee.getFirstName() != null)
				e1.setFirstName(employee.getFirstName());
			if(employee.getLastName() != null)
				e1.setLastName(employee.getLastName());
			
			if(employee.getStreetName()!=null)
				e1.setStreetName(employee.getStreetName());
			
			if(employee.getStreetNumber()!= 0)
				e1.setStreetNumber(employee.getStreetNumber());

			employeeRepository.save(e1);
		}
	}

	public boolean exist(Long employeeId) {
		return employeeRepository.existsById(employeeId);
	}

	
}
