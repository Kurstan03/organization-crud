package com.example.organizationcrud.service.impl;

import com.example.organizationcrud.db.dto.request.EmployeeRequest;
import com.example.organizationcrud.db.dto.response.EmployeeInnerResponse;
import com.example.organizationcrud.db.dto.response.EmployeeResponse;
import com.example.organizationcrud.db.dto.response.SimpleResponse;
import com.example.organizationcrud.db.model.Employee;
import com.example.organizationcrud.db.model.Organization;
import com.example.organizationcrud.exceptions.BadRequestException;
import com.example.organizationcrud.exceptions.NotFoundException;
import com.example.organizationcrud.repository.EmployeeRepository;
import com.example.organizationcrud.repository.OrganizationRepository;
import com.example.organizationcrud.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final OrganizationRepository organizationRepository;

    @Override
    public List<EmployeeResponse> getAllEmployeesOfOrganization(Long organizationId) {
        return employeeRepository.findAllByOrganizationId(organizationId);
    }

    @Override
    public EmployeeInnerResponse getEmployeeById(Long employeeId) {
        EmployeeInnerResponse employeeInnerResponse = employeeRepository.getEmployeeById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee by id - %s not found.".formatted(employeeId)));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee by id - %s not found.".formatted(employeeId)));
        employeeInnerResponse.setBankDetails(employee.getBankDetails());
        return employeeInnerResponse;
    }

    @Override
    public SimpleResponse addNewEmployeeToOrganization(Long organizationId, EmployeeRequest employeeRequest) {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new NotFoundException("Organization by id - %s not found.".formatted(organizationId)));
        Employee employee = new Employee();
        employee.setEmail(employeeRequest.email());
        employee.setHomePhoneNumber(employeeRequest.homePhoneNumber());
        employee.setMobilePhoneNumber(employeeRequest.mobilePhoneNumber());
        employee.setWorkPhoneNumber(employeeRequest.workPhoneNumber());
        employee.setHomeAddress(employeeRequest.homeAddress());
        employee.setWebpage(employeeRequest.webpage());
        employee.setJobPosition(employeeRequest.jobPosition());
        employee.setBankDetails(employeeRequest.bankDetails());
        employee.setOrganization(organization);
        employeeRepository.save(employee);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Employee - %s saved successfully.".formatted(employee.getEmail()))
                .build();
    }

    @Override
    public SimpleResponse updateEmployee(Long employeeId, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new NotFoundException("Employee by id - %s not found.".formatted(employeeId)));
        employee.setEmail(employeeRequest.email());
        employee.setHomePhoneNumber(employeeRequest.homePhoneNumber());
        employee.setMobilePhoneNumber(employeeRequest.mobilePhoneNumber());
        employee.setWorkPhoneNumber(employeeRequest.workPhoneNumber());
        employee.setHomeAddress(employeeRequest.homeAddress());
        employee.setWebpage(employeeRequest.webpage());
        employee.setJobPosition(employeeRequest.jobPosition());
        employee.setBankDetails(employeeRequest.bankDetails());
        employeeRepository.save(employee);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Employee - %s updated successfully.".formatted(employee.getEmail()))
                .build();
    }

    @Override
    public SimpleResponse deleteEmployee(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new BadRequestException("Employee with id - %s does not exists.".formatted(employeeId));
        }
        employeeRepository.deleteById(employeeId);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Employee with id - %s deleted successfully.".formatted(employeeId))
                .build();
    }
}
