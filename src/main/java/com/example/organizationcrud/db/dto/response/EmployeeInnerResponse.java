package com.example.organizationcrud.db.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeInnerResponse {
    private Long id;
    private String email;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String workPhoneNumber;
    private String homeAddress;
    private String webpage;
    private String jobPosition;
    private List<String> bankDetails;

    public EmployeeInnerResponse(Long id, String email, String homePhoneNumber, String mobilePhoneNumber, String workPhoneNumber, String homeAddress, String webpage, String jobPosition) {
        this.id = id;
        this.email = email;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.workPhoneNumber = workPhoneNumber;
        this.homeAddress = homeAddress;
        this.webpage = webpage;
        this.jobPosition = jobPosition;
    }
}
