package com.hrms.backend.mapper;

import com.hrms.backend.dto.DepartmentDTO;
import com.hrms.backend.entity.Department;

public class DepartmentMapper {
    public static DepartmentDTO toDTO(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setActive(department.isActive());
        return dto;
    }

    public static Department toEntity(DepartmentDTO dto) {
        if (dto == null) {
            return null;
        }
        Department department = new Department();
        department.setId(dto.getId());
        department.setName(dto.getName());
        department.setActive(dto.isActive());
        return department;
    }
}
