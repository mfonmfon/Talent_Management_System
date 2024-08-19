package com.semicolon.africa.jobcrafter.dto.request;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FreelancerUpdateRequest {
    private String jobTitle;
    private String jobDescription;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Resume cv;
    private String jobType;
    private LocalDateTime dateUpdated;

}
