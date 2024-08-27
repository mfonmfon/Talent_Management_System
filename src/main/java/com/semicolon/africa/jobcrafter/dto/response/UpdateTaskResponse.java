package com.semicolon.africa.jobcrafter.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateTaskResponse {
    private String title;
    private String description;
    private String deadLine;
    private LocalDateTime dateUpdated;
    private String message;
}
