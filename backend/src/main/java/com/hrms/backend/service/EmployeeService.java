package com.hrms.backend.service;

import com.hrms.backend.entity.Employee;
import com.hrms.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setLastName(updatedEmployee.getLastName());
                    employee.setEmail(updatedEmployee.getEmail());
                    employee.setJobTitle(updatedEmployee.getJobTitle());
                    employee.setSalary(updatedEmployee.getSalary());
                    employee.setDepartment(updatedEmployee.getDepartment());
                    employee.setActive(updatedEmployee.isActive());
                    return employeeRepository.save(employee);
                })
                .orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}