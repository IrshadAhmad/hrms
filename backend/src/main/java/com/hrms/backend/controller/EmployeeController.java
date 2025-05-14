package com.hrms.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.backend.entity.Employee;
import com.hrms.backend.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //get all employees
    //localhost:8080/api/employees
    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //get employee by id
    //localhost:8080/api/employees/{id}
    @GetMapping("/api/employees/{id}")
    public Employee getEmployeeById(Long id) {
        return employeeService.getEmployeeById(id).orElse(null);
    }

    //create employee
    //localhost:8080/api/employees
    @PostMapping("/api/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    //update employee
    //localhost:8080/api/employees/{id}
    @PutMapping("/api/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    //delete employee
    //localhost:8080/api/employees/{id}
    @DeleteMapping("/api/employees/{id}")
    public void deleteEmployee(Long id) {
        employeeService.deleteEmployee(id);
    }
}
