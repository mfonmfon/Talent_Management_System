package com.semicolon.africa.jobcrafter.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PostApiResponse {
    private boolean isSuccessful;
    private Object data;
}
