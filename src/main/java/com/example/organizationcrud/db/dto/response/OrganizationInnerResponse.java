package com.example.organizationcrud.db.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrganizationInnerResponse {
    private Long id;
    private String ownershipForm;
    private String legalForm;
    private String name;
    private String fullNameOfDirector;
    private String fax;
    private String phoneNumber;
    private String webpage;
    private String login;
    private String licenseNumber;
    private LocalDate dateOfGetLicense;
    private String evidenceNumber;
    private LocalDate dateOfGetEvidence;
    private String address;
    private List<String> files;

    public OrganizationInnerResponse(Long id, String ownershipForm, String legalForm, String name, String fullNameOfDirector, String fax, String phoneNumber, String webpage, String login, String licenseNumber, LocalDate dateOfGetLicense, String evidenceNumber, LocalDate dateOfGetEvidence, String address) {
        this.id = id;
        this.ownershipForm = ownershipForm;
        this.legalForm = legalForm;
        this.name = name;
        this.fullNameOfDirector = fullNameOfDirector;
        this.fax = fax;
        this.phoneNumber = phoneNumber;
        this.webpage = webpage;
        this.login = login;
        this.licenseNumber = licenseNumber;
        this.dateOfGetLicense = dateOfGetLicense;
        this.evidenceNumber = evidenceNumber;
        this.dateOfGetEvidence = dateOfGetEvidence;
        this.address = address;
    }
}
