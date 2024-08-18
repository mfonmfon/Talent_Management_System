package com.semicolon.africa.jobcrafter.dto.request;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddPostRequest {
    private String title;
    private String description;
    private Resume cv;
    private String fixedPrice;
    private String location;
    private LocalDateTime dateCreated;
}
