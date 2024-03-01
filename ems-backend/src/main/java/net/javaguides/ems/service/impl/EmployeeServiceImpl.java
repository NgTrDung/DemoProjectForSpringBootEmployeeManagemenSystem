package net.javaguides.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDTO;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.NotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repositories.EmployeeReporistory;
import net.javaguides.ems.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeReporistory employeeReporistory;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee savedEmployee = employeeReporistory.save(employee);

		return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
	}

	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {
		Employee employee = employeeReporistory.findById(employeeId).orElseThrow(
				() -> new NotFoundException("Employee is not exist"));
//		Employee employee = employeeReporistory.findById(employeeId).get();
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> employees = employeeReporistory.findAll();
		return employees.stream().map((employee) -> 
				EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
		Employee employee = employeeReporistory.findById(employeeId).orElseThrow(
				() -> new NotFoundException("Employee is not exist"));
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		employeeReporistory.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

}
