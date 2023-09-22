package com.example.organizationcrud.api;

import com.example.organizationcrud.db.dto.request.OrganizationRequest;
import com.example.organizationcrud.db.dto.response.OrganizationInnerResponse;
import com.example.organizationcrud.db.dto.response.OrganizationResponse;
import com.example.organizationcrud.db.dto.response.SimpleResponse;
import com.example.organizationcrud.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@Tag(name = "Organization controller")
public class OrganizationController {
    private final OrganizationService organizationService;

    @Operation(summary = "Get all organizations")
    @GetMapping
    public List<OrganizationResponse> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @Operation(summary = "Get organization by id")
    @GetMapping("/{organizationId}")
    public OrganizationInnerResponse getOrganizationById(@PathVariable Long organizationId) {
        return organizationService.getOrganizationById(organizationId);
    }

    @Operation(summary = "Save a new organization")
    @PostMapping
    public SimpleResponse saveNewOrganization(@RequestBody @Valid OrganizationRequest organizationRequest) {
        return organizationService.saveNewOrganization(organizationRequest);
    }

    @Operation(summary = "Update organization by id")
    @PutMapping("/{organizationId}")
    public SimpleResponse updateOrganization(
            @PathVariable Long organizationId,
            @RequestBody @Valid OrganizationRequest organizationRequest) {
        return organizationService.updateOrganization(organizationId, organizationRequest);
    }

    @Operation(summary = "Add files to organization")
    @PostMapping("/{organizationId}")
    public SimpleResponse addFilesToOrganization(
            @PathVariable Long organizationId,
            @RequestParam List<String> files
    ) {
        return organizationService.addFilesToOrganization(organizationId, files);
    }

    @Operation(summary = "Delete the organization")
    @DeleteMapping("/{organizationId}")
    public SimpleResponse deleteOrganization(@PathVariable Long organizationId) {
        return organizationService.deleteOrganization(organizationId);
    }
}
