package com.semicolon.africa.jobcrafter.dto.response;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdatePostResponse {
    private String title;
    private String description;
    private String fixedPrice;
    private Resume cv;
    private String location;
    private LocalDateTime dateUpdated;
    private String message;
}

