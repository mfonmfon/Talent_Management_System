package com.semicolon.africa.jobcrafter.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateResumeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String position;
    private String volunteer;
    private String personalProjects;
    private String workExperience;
    private String skills;
    private String formerCompany;
    private String educationStatus;
    private String marriageStatus;
    private String certificate;
}
