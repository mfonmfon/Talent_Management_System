package com.semicolon.africa.jobcrafter.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class AddTaskRequest {
    private String title;
    private String description;
    private String deadLine;
    private LocalDateTime dateCreated;
}
