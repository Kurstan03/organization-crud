package com.example.organizationcrud.db.dto.request;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public record OrganizationRequest(
        @NotBlank(message = "Write ownership form")
        String ownershipForm,
        @NotBlank(message = "Write legal form")
        String legalForm,
        @NotBlank(message = "Write name of organization")
        String name,
        @NotBlank(message = "Write full name of director")
        String fullNameOfDirector,
        @NotBlank(message = "Write fax")
        String fax,
        @NotBlank(message = "Write phone number")
        String phoneNumber,
        @NotBlank(message = "Write webpage")
        String webpage,
        @NotBlank(message = "Write login")
        String login,
        @NotBlank(message = "Write the license number")
        String licenseNumber,
        @NotBlank(message = "Write date of get license")
        LocalDate dateOfGetLicense,
        @NotBlank(message = "Write the evidence number")
        String evidenceNumber,
        @NotBlank(message = "Write date of get evidence")
        LocalDate dateOfGetEvidence,
        @NotBlank(message = "Write address of organization")
        String address
) {
}
