package com.employee.details;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.details.Exception.EmployeeException;
import com.employee.details.Service.EmployeeService;
import com.employee.details.dto.EmployeeDTO;

@RestController
@RequestMapping(value="/employee")
public class EmployeeAPI {

	@Autowired
	private EmployeeService employeeService;
    
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/employee")
	public ResponseEntity<List<EmployeeDTO>> getAllCustomers() throws EmployeeException {
		List<EmployeeDTO> empList = employeeService.getAllEmployee();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	@GetMapping(value="/employeedetails/{Id}")
	public ResponseEntity<EmployeeDTO> getemployee( @PathVariable Integer Id) throws EmployeeException {
	EmployeeDTO  employee = employeeService.getEmployee(Id);
	return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping(value = "/employee")
	public ResponseEntity<String> addEmployee( @RequestBody EmployeeDTO employee) throws EmployeeException {
		Integer Id = employeeService.addEmployee(employee);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + Id;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value = "/employee/{Id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer Id, @RequestBody EmployeeDTO employee)
			throws EmployeeException {
		employeeService.updateEmployee(Id, employee.getEmailid());
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@DeleteMapping(value = "/employee/{Id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer Id) throws EmployeeException {
		employeeService.deleteEmployee(Id);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	
}
