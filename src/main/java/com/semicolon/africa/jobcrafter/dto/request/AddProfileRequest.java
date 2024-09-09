package com.semicolon.africa.jobcrafter.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProfileRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String bio;
    private String phoneNumber;
    private String stateOfOrigin;
    private String residence;
    private String country;
}
