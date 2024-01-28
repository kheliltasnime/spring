package com.example.demo.Service;

import java.util.List;

import com.example.demo.Dto.RequestDepartment;
import com.example.demo.Dto.ResponseDepartement;
import com.example.demo.Entities.Department;

public interface DepartmentService {
    List<ResponseDepartement> getAllDepartment();
  boolean deleteDepartment(Long id);
    void createDepartment(RequestDepartment departmentRequest);
Department updateDepartment(Long id,RequestDepartment departmentRequest);
   ResponseDepartement getDepartmentById(Long id);
    ResponseDepartement getDepartmentByIdWithUser(Long id);

}
