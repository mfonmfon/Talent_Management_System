package com.semicolon.africa.jobcrafter.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreelancerRegisterResponse {
    private String userName;
    private String email;
    private String password;
    private String message;
}
