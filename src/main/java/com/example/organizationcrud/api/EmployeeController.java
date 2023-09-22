package com.example.organizationcrud.api;

import com.example.organizationcrud.db.dto.request.EmployeeRequest;
import com.example.organizationcrud.db.dto.response.EmployeeInnerResponse;
import com.example.organizationcrud.db.dto.response.EmployeeResponse;
import com.example.organizationcrud.db.dto.response.SimpleResponse;
import com.example.organizationcrud.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@Tag(name = "Employee controller")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Operation(summary = "Get all employees of organization by organization id")
    @GetMapping("/{organizationId}")
    public List<EmployeeResponse> getAllEmployeesOfOrganization(@PathVariable Long organizationId) {
        return employeeService.getAllEmployeesOfOrganization(organizationId);
    }

    @Operation(summary = "Get employee by id")
    @GetMapping("/inner/{employeeId}")
    public EmployeeInnerResponse getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @Operation(summary = "Add a new employee to organization")
    @PostMapping("/{organizationId}")
    public SimpleResponse addNewEmployeeToOrganization(
            @PathVariable Long organizationId,
            @RequestBody @Valid EmployeeRequest employeeRequest) {
        return employeeService.addNewEmployeeToOrganization(organizationId, employeeRequest);
    }

    @Operation(summary = "Update the employee")
    @PutMapping("/{employeeId}")
    public SimpleResponse updateEmployee(
            @PathVariable Long employeeId,
            @RequestBody @Valid EmployeeRequest employeeRequest) {
        return employeeService.updateEmployee(employeeId, employeeRequest);
    }

    @Operation(summary = "Delete employee")
    @DeleteMapping("/{employeeId}")
    public SimpleResponse deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
