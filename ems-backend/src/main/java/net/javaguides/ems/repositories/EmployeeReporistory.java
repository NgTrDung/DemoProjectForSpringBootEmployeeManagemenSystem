package net.javaguides.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.ems.entity.Employee;

public interface EmployeeReporistory extends JpaRepository<Employee, Long>{

	
	
}
