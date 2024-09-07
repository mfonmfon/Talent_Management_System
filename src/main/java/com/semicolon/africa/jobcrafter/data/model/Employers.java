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
public class Employers {
    private String id;
    private String firstName;
    private String lastName;
    private String companyName;

}
