package com.example.organizationcrud.db.dto.response;

public record OrganizationResponse(
        Long id,
        String name,
        String fullNameOfDirector,
        String phoneNumber,
        String address,
        int quantityOfEmployees
) {
}
