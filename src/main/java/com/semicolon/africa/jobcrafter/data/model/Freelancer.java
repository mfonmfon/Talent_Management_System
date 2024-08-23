package com.semicolon.africa.jobcrafter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Freelancer {
    @Id
    private String Id;
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
    private LocalDateTime dateUpdated;

    @DBRef
    List<Task> allTask = new ArrayList<>();
}
