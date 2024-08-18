package com.semicolon.africa.jobcrafter.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreelancerLoginRequest {
    private String email;
    private String password;
}
