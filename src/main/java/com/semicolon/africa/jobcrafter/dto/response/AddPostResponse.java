package com.semicolon.africa.jobcrafter.dto.response;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AddPostResponse {
    private String postId;
    private String title;
    private String description;
    private Resume cv;
    private String fixedPrice;
    private String location;
    private LocalDateTime dateCreated;
    private String message;
}
