package com.semicolon.africa.jobcrafter.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AddTaskResponse {
    private String taskId;
    private String title;
    private String description;
    private String deadLine;
    private LocalDateTime dateCreated;
    private String message;
}
