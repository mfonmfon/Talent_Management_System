package com.semicolon.africa.jobcrafter.web;

import com.semicolon.africa.jobcrafter.dto.request.FreelancerRegisterRequest;
import com.semicolon.africa.jobcrafter.dto.response.FreelancerRegisterResponse;
import com.semicolon.africa.jobcrafter.dto.response.PostApiResponse;
import com.semicolon.africa.jobcrafter.services.FreelancerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/freelancer")
@RequiredArgsConstructor
public class FreelancerController {

    private final FreelancerServices freelancerServices;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody FreelancerRegisterRequest request){
        try {
            FreelancerRegisterResponse response = freelancerServices.register(request);
            return new ResponseEntity<>(new PostApiResponse(true, response),
                    HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new PostApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
