package com.example.organizationcrud.repository;

import com.example.organizationcrud.db.dto.response.OrganizationInnerResponse;
import com.example.organizationcrud.db.dto.response.OrganizationResponse;
import com.example.organizationcrud.db.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query("""
            SELECT NEW com.example.organizationcrud.db.dto.response.OrganizationResponse(
            o.id, o.name, o.fullNameOfDirector, o.phoneNumber, o.address, SIZE(o.employees)
            )
            FROM Organization o
            """)
    List<OrganizationResponse> getAllOrganizations();

    @Query("""
            SELECT NEW com.example.organizationcrud.db.dto.response.OrganizationInnerResponse(
            o.id, o.ownershipForm, o.legalForm, o.name, o.fullNameOfDirector, o.fax, o.phoneNumber, o.webpage, o.login, o.licenseNumber,
            o.dateOfGetLicense, o.evidenceNumber, o.dateOfGetEvidence, o.address
            )
            FROM Organization o
            WHERE o.id = :organizationId
            """)
    Optional<OrganizationInnerResponse> getOrganizationById(Long organizationId);
}