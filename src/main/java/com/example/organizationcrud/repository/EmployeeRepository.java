package com.example.organizationcrud.repository;

import com.example.organizationcrud.db.dto.response.EmployeeInnerResponse;
import com.example.organizationcrud.db.dto.response.EmployeeResponse;
import com.example.organizationcrud.db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<EmployeeResponse> findAllByOrganizationId(Long organizationId);

    @Query("""
            SELECT NEW com.example.organizationcrud.db.dto.response.EmployeeInnerResponse(
            e.id, e.email, e.homePhoneNumber, e.mobilePhoneNumber, e.workPhoneNumber,
            e.homeAddress, e.webpage, e.jobPosition
            )
            FROM Employee e
            WHERE e.id = :employeeId
            """)
    Optional<EmployeeInnerResponse> getEmployeeById(Long employeeId);

}