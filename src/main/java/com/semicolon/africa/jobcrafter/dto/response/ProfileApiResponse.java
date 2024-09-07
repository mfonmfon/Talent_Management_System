package com.semicolon.africa.jobcrafter.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfileApiResponse {
    private boolean isSuccessful;
    private Object data;
}
