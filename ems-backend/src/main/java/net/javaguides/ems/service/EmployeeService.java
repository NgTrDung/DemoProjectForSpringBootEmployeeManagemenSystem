package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO getEmployeeById(Long employeeId);
	
}
