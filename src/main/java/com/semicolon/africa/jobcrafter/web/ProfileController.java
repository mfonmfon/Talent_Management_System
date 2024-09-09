package com.semicolon.africa.jobcrafter.web;

import com.semicolon.africa.jobcrafter.data.model.Profile;
import com.semicolon.africa.jobcrafter.dto.request.AddProfileRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateProfileRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddProfileResponse;
import com.semicolon.africa.jobcrafter.dto.response.ProfileApiResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateProfileResponse;
import com.semicolon.africa.jobcrafter.services.ProfileServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
   private ProfileServices profileServices;

    @PostMapping("/add_profile")
    public ResponseEntity<?> addProfile(@RequestBody AddProfileRequest request){
        try {
            AddProfileResponse response = profileServices.addProfile(request);
            return new ResponseEntity<>(new ProfileApiResponse(true, response),
                    HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ProfileApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update_profile")
    public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileRequest request){
        try {
            UpdateProfileResponse response = profileServices.updateProfile(request);
            return new ResponseEntity<>(new ProfileApiResponse(true, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ProfileApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<?> allProfiles(){
        try {
            List<Profile> findAllProfiles = profileServices.allProfile();
            return new ResponseEntity<>(new ProfileApiResponse(true, findAllProfiles),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ProfileApiResponse(false, exception.getMessage()),
                    HttpStatus.OK);
        }
    }
    @GetMapping("/{firstName}")
    public ResponseEntity<?> searchProfile(@PathVariable String firstName){
        try {
            List<Profile> findByFirstName = profileServices.searchByFirstName(firstName);
            return new ResponseEntity<>(new ProfileApiResponse(true, findByFirstName),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ProfileApiResponse(true, exception.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/searchProfileByLastName{lastName}")
    public ResponseEntity<?> searchProfileByLastName(@PathVariable String lastName){
        try {
            List<Profile> findByLastName = profileServices.searchByLastName(lastName);
            return new ResponseEntity<>(new ProfileApiResponse(true, findByLastName),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ProfileApiResponse(true, exception.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }
}
