package net.javaguides.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDTO;
import net.javaguides.ems.service.EmployeeService;

@CrossOrigin("*")
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
	
	// Build GET ALL Employee REST API
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
		List<EmployeeDTO> employees = employeeService.getAllEmployee();
		return ResponseEntity.ok(employees);
	}
	
	// Build UPDATE Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId, 
			@RequestBody EmployeeDTO updatedEmployee){
		EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDTO);
	}
	
	// Build DELETE Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long enployeeId){
		employeeService.deleteEmployee(enployeeId);
		return ResponseEntity.ok("Employee is deleted successfully!");
	}

}
