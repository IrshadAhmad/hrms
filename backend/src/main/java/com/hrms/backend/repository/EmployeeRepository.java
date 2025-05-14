package com.hrms.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Implement soft delete logic here
    // For example, set isActive to false instead of deleting the record
    public default void deleteById(Long id) {
        Employee employee = findById(id).orElse(null);
        if (employee != null) {
            employee.setActive(false);
            save(employee);
        }
    }
}
