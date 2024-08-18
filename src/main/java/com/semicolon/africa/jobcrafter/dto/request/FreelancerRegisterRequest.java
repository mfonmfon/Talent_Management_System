package com.semicolon.africa.jobcrafter.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreelancerRegisterRequest {
    private String email;
    private String userName;
    private String password;
}
