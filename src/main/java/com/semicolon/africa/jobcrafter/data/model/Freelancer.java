package com.semicolon.africa.jobcrafter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Freelancer {
    private String freelancerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String userName;
    private String skills;
    private boolean isLoggedIn;
    private String expectedPrice;
    private Resume cv;
    private String jobTitle;
    private String jobDescription;
    private String jobType;
    private LocalDateTime dateCreated;

    @DBRef
    List<Freelancer> allFreelancers = new ArrayList<>();
}
