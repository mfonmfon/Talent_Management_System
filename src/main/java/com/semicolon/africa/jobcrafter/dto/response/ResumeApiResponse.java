package com.semicolon.africa.jobcrafter.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResumeApiResponse {
    private boolean isSuccessful;
    private Object data;
}
