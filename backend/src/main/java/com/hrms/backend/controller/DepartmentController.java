package com.hrms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.backend.service.DepartmentService;
import com.hrms.backend.entity.Department;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    // Get all departments
    // localhost:8080/api/departments
    @GetMapping("/api/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // Get department by ID
    // localhost:8080/api/departments/{id}
    @GetMapping("/api/departments/{id}")
    public Department getDepartmentById(Long id) {
        return departmentService.getDepartmentById(id).orElse(null);
    }

    // Create department
    // localhost:8080/api/departments
    @PostMapping("/api/departments")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    // Update department
    // localhost:8080/api/departments/{id}
    @PutMapping("/api/departments/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        return departmentService.updateDepartment(id, updatedDepartment);
    }

    // Delete department
    // localhost:8080/api/departments/{id}
    @DeleteMapping("/api/departments/{id}")
    public void deleteDepartment(Long id) {
        departmentService.deleteDepartment(id);
    }
}
