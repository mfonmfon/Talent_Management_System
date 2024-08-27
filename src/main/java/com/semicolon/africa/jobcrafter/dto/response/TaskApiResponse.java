package com.semicolon.africa.jobcrafter.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskApiResponse {
    private boolean isSuccessful;
    private Object data;
}
