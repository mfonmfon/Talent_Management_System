package com.semicolon.africa.jobcrafter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private String id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime dateCreated;

}
