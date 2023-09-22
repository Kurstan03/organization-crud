package com.example.organizationcrud.db.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public record EmployeeRequest(
        @NotBlank(message = "Write email of employee")
        @Email(message = "Email should be valid")
        String email,
        @NotBlank(message = "Write home phone number")
        String homePhoneNumber,
        @NotBlank(message = "Write mobile phone number")
        String mobilePhoneNumber,
        @NotBlank(message = "Write work phone number")
        String workPhoneNumber,
        @NotBlank(message = "Write home address")
        String homeAddress,
        @NotBlank(message = "Write webpage")
        String webpage,
        @NotBlank(message = "Write job position")
        String jobPosition,
        @NotEmpty(message = "Write bank details")
        List<String> bankDetails
) {
}
