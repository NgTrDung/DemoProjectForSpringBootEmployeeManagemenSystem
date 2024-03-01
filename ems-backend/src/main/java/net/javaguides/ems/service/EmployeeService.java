package net.javaguides.ems.service;

import java.util.List;

import net.javaguides.ems.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO getEmployeeById(Long employeeId);
	
	List<EmployeeDTO> getAllEmployee();
	
	EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee);
	
}
