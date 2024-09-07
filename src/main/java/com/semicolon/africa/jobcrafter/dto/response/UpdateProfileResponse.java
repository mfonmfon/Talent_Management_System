package com.semicolon.africa.jobcrafter.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String bio;
    private String password;
    private String phoneNumber;
    private String stateOfOrigin;
    private String residence;
    private String country;
    private String message;
}
