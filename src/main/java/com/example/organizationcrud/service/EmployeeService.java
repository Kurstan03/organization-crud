package com.example.organizationcrud.service;

import com.example.organizationcrud.db.dto.request.EmployeeRequest;
import com.example.organizationcrud.db.dto.response.EmployeeInnerResponse;
import com.example.organizationcrud.db.dto.response.EmployeeResponse;
import com.example.organizationcrud.db.dto.response.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeResponse> getAllEmployeesOfOrganization(Long organizationId);

    EmployeeInnerResponse getEmployeeById(Long employeeId);

    SimpleResponse addNewEmployeeToOrganization(Long organizationId, EmployeeRequest employeeRequest);

    SimpleResponse updateEmployee(Long employeeId, EmployeeRequest employeeRequest);

    SimpleResponse deleteEmployee(Long employeeId);
}