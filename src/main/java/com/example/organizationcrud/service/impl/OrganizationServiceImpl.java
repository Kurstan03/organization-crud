package com.example.organizationcrud.service.impl;

import com.example.organizationcrud.db.dto.request.OrganizationRequest;
import com.example.organizationcrud.db.dto.response.OrganizationInnerResponse;
import com.example.organizationcrud.db.dto.response.OrganizationResponse;
import com.example.organizationcrud.db.dto.response.SimpleResponse;
import com.example.organizationcrud.db.model.Organization;
import com.example.organizationcrud.exceptions.BadRequestException;
import com.example.organizationcrud.exceptions.NotFoundException;
import com.example.organizationcrud.repository.OrganizationRepository;
import com.example.organizationcrud.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public List<OrganizationResponse> getAllOrganizations() {
        return organizationRepository.getAllOrganizations();
    }

    @Override
    public OrganizationInnerResponse getOrganizationById(Long organizationId) {
        OrganizationInnerResponse organizationInnerResponse = organizationRepository
                .getOrganizationById(organizationId).orElseThrow(
                        () -> new NotFoundException("Organization by id - %s not found.".formatted(organizationId)));
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new NotFoundException("Organization by id - %s not found.".formatted(organizationId)));
        organizationInnerResponse
                .setFiles(organization.getFiles());
        return organizationInnerResponse;
    }

    @Override
    public SimpleResponse saveNewOrganization(OrganizationRequest organizationRequest) {
        Organization organization = new Organization();
        organization.setOwnershipForm(organizationRequest.ownershipForm());
        organization.setLegalForm(organizationRequest.legalForm());
        organization.setName(organizationRequest.name());
        organization.setFullNameOfDirector(organizationRequest.fullNameOfDirector());
        organization.setFax(organizationRequest.fax());
        organization.setPhoneNumber(organizationRequest.phoneNumber());
        organization.setWebpage(organizationRequest.webpage());
        organization.setLogin(organizationRequest.login());
        organization.setLicenseNumber(organizationRequest.licenseNumber());
        organization.setDateOfGetLicense(organizationRequest.dateOfGetLicense());
        organization.setEvidenceNumber(organizationRequest.evidenceNumber());
        organization.setDateOfGetEvidence(organizationRequest.dateOfGetEvidence());
        organization.setAddress(organizationRequest.address());
        organizationRepository.save(organization);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("The organization - %s is saved successfully.".formatted(organization.getName()))
                .build();
    }

    @Override
    @Transactional
    public SimpleResponse updateOrganization(Long organizationId, OrganizationRequest organizationRequest) {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new NotFoundException("Organization by id - %s not found.".formatted(organizationId)));
        organization.setOwnershipForm(organizationRequest.ownershipForm());
        organization.setLegalForm(organizationRequest.legalForm());
        organization.setName(organizationRequest.name());
        organization.setFullNameOfDirector(organizationRequest.fullNameOfDirector());
        organization.setFax(organizationRequest.fax());
        organization.setPhoneNumber(organizationRequest.phoneNumber());
        organization.setWebpage(organizationRequest.webpage());
        organization.setLogin(organizationRequest.login());
        organization.setLicenseNumber(organizationRequest.licenseNumber());
        organization.setDateOfGetLicense(organizationRequest.dateOfGetLicense());
        organization.setEvidenceNumber(organizationRequest.evidenceNumber());
        organization.setDateOfGetEvidence(organizationRequest.dateOfGetEvidence());
        organization.setAddress(organizationRequest.address());
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("The organization - %s is updated successfully.".formatted(organization.getName()))
                .build();
    }

    @Override
    @Transactional
    public SimpleResponse addFilesToOrganization(Long organizationId, List<String> files) {
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new NotFoundException("Organization by id - %s not found.".formatted(organizationId)));
        organization.addFiles(files);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Files added successfully for org. - %s".formatted(organization.getName()))
                .build();
    }

    @Override
    public SimpleResponse deleteOrganization(Long organizationId) {
        if (!organizationRepository.existsById(organizationId)) {
            throw new BadRequestException("Organization by id - % does not exists.".formatted(organizationId));
        }
        organizationRepository.deleteById(organizationId);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Organization by id - %s is deleted successfully.".formatted(organizationId))
                .build();
    }
}
