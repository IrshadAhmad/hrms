package com.hrms.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.backend.entity.Department;

public interface DepartmenrRepository extends JpaRepository<Department, Long> {
    // Make deleteById method public as soft delete
    // @Override
    public default void deleteById(Long id) {
        Department department = findById(id).orElse(null);
        if (department != null) {
            department.setActive(false);
            save(department);
        }
    }
}
