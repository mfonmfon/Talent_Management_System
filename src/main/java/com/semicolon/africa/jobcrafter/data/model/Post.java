package com.semicolon.africa.jobcrafter.data.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Post {
    @Id
    private String id;
    private String title;
    private String description;
    private String fixedPrice;
    private String location;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    @DBRef
    List<Post> AllPost = new ArrayList<>();
}
