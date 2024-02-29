package net.javaguides.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDTO;
import net.javaguides.ems.service.EmployeeService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	// Build Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO savedEmployeeDTO = employeeService.createEmployee(employeeDTO);

		return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
	}
	
	// Build Get Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Long employeeId) {
		EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDTO);
	}

}
