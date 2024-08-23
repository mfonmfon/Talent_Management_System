package com.semicolon.africa.jobcrafter.web;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.dto.request.AddFreelancerRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerLoginRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerRegisterRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerUpdateRequest;
import com.semicolon.africa.jobcrafter.dto.response.*;
import com.semicolon.africa.jobcrafter.services.FreelancerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freelancer")
@RequiredArgsConstructor
public class FreelancerController {

    @Autowired
    private  FreelancerServices freelancerServices;

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
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody FreelancerLoginRequest request){
        try {
            FreelancerLoginResponse response = freelancerServices.login(request);
            return new ResponseEntity<>(new PostApiResponse(true, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new PostApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody AddFreelancerRequest request){
        try {
            AddFreelancerResponse response = freelancerServices.apply(request);
            return new ResponseEntity<>(new PostApiResponse(true,response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new PostApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody FreelancerUpdateRequest request){
        try {
            FreelancerUpdateResponse response = freelancerServices.updateApplication(request);
            return new ResponseEntity<>(new PostApiResponse(true, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new PostApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("displayAll")
    public ResponseEntity<?> displayAll(){
        try {
            List<Freelancer> freelancers = freelancerServices.displayAllFreelancers();
            return new ResponseEntity<>(new PostApiResponse(true, freelancers),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new PostApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
