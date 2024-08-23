package com.semicolon.africa.jobcrafter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    private String id;
    private String yearsOfExperience;
    private String skills;
    private String formerCompany;
    private String educationStatus;
}
