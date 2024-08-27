package com.semicolon.africa.jobcrafter.data.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document
@NoArgsConstructor
public class Profile {
    @Id
    private String id;
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

    @DBRef
     List<Profile> profileList;

}
