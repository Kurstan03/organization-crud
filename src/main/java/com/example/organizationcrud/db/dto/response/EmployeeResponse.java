package com.example.organizationcrud.db.dto.response;


public record EmployeeResponse(
        Long id,
        String email,
        String homePhoneNumber,
        String mobilePhoneNumber,
        String workPhoneNumber,
        String homeAddress,
        String webpage,
        String jobPosition
) {
}
