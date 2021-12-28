package com.nagarro.employeemanagementapi.controller;

import com.nagarro.employeemanagementapi.model.Employee;
import com.nagarro.employeemanagementapi.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.getOne(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.saveAndFlush(employee);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Employee update(@PathVariable Long id,@RequestBody Employee employee){
        Employee existingEmployee = employeeRepository.getOne(id);
        BeanUtils.copyProperties(employee,existingEmployee,"employeeCode");
        return employeeRepository.saveAndFlush(existingEmployee);
    }
}
