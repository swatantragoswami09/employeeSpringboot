package com.nagarro.employeemanagementapi.repositories;

import com.nagarro.employeemanagementapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
