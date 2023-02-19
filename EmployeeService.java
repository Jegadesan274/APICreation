package com.employee.details.Service;



import java.util.List;

import com.employee.details.Exception.EmployeeException;
import com.employee.details.dto.EmployeeDTO;

public interface EmployeeService {

	public EmployeeDTO getEmployee(Integer Id) throws EmployeeException;
	public List<EmployeeDTO> getAllEmployee() throws EmployeeException;
	public Integer addEmployee(EmployeeDTO employee) throws EmployeeException;
	public void updateEmployee(Integer Id,String emailId) throws EmployeeException;
	public void deleteEmployee(Integer Id)throws EmployeeException;
}
