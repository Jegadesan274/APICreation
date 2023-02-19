package com.employee.details.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.details.Exception.EmployeeException;
import com.employee.details.dto.EmployeeDTO;
import com.employee.details.entity.Employee;
import com.employee.details.repository.EmployeeRepository;

@Service(value ="employeeService")
@Transactional
public abstract class EmployeedetailsServiceimpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeerepository;
	
	@Override
	public EmployeeDTO getEmployee(Integer Id) throws EmployeeException {
		Optional<Employee> optional = employeerepository.findById(Id);
		Employee Employee = optional.orElseThrow(() -> new EmployeeException("Service.Employee_NOT_FOUND"));
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmailid(Employee.getEmailid());
		employeeDTO.setId(Employee.getId());
		employeeDTO.setName(Employee.getName());
		employeeDTO.setAge(Employee.getAge());
		return employeeDTO;
	}
	@Override
	public List<EmployeeDTO> getAllEmployee() throws EmployeeException {
		Iterable<Employee> employees = employeerepository.findAll();
		List<EmployeeDTO> employee= new ArrayList<>();
		employees.forEach(employee1 -> {
			EmployeeDTO emp = new EmployeeDTO();
			emp.setId(employee1.getId());
			emp.setAge(employee1.getAge());
			emp.setEmailid(employee1.getEmailid());
			emp.setName(employee1.getName());
			
			employee.add(emp);
		});
		if (employee.isEmpty())
			throw new EmployeeException("Service.employees_NOT_FOUND");
		return employee;
	}
	@Override
	public Integer addEmployee(EmployeeDTO employee) throws EmployeeException {
		Employee EmployeeEntity = new Employee();
		EmployeeEntity.setAge(employee.getAge());
		EmployeeEntity.setEmailid(employee.getEmailid());
		EmployeeEntity.setAge(employee.getAge());
		EmployeeEntity.setId(employee.getId());
		Employee EmployeeEntity2 = employeerepository.save(EmployeeEntity);
		return EmployeeEntity2.getId();
	}
	@Override
	public void updateEmployee(Integer Id, String EmailId) throws EmployeeException {
		Optional<Employee> employee = employeerepository.findById(Id);
		Employee emp = employee.orElseThrow(() -> new EmployeeException("Service.Employee_NOT_FOUND"));
		emp.setId(Id);
	}
	
	@Override
	public void deleteEmployee(Integer Id) throws EmployeeException {
		Optional<Employee> emp = employeerepository.findById(Id);
		emp.orElseThrow(() -> new EmployeeException("Service.Employee_NOT_FOUND"));
		employeerepository.deleteById(Id);
	}
	
}

