package com.example.organizationcrud.service;

import com.example.organizationcrud.db.dto.request.OrganizationRequest;
import com.example.organizationcrud.db.dto.response.OrganizationInnerResponse;
import com.example.organizationcrud.db.dto.response.OrganizationResponse;
import com.example.organizationcrud.db.dto.response.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrganizationService {
    List<OrganizationResponse> getAllOrganizations();

    OrganizationInnerResponse getOrganizationById(Long organizationId);

    SimpleResponse saveNewOrganization(OrganizationRequest organizationRequest);

    SimpleResponse updateOrganization(Long organizationId, OrganizationRequest organizationRequest);

    SimpleResponse addFilesToOrganization(Long organizationId, List<String> files);

    SimpleResponse deleteOrganization(Long organizationId);

}
