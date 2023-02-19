package com.employee.details.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.details.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
 
}
