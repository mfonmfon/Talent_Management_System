package com.semicolon.africa.jobcrafter.web;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import com.semicolon.africa.jobcrafter.dto.request.AddResumeRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateResumeRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.ResumeApiResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateResumeResponse;
import com.semicolon.africa.jobcrafter.services.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("addResume")
    public ResponseEntity<?> addResume(@RequestBody AddResumeRequest request){
        try {
            AddResumeResponse response = resumeService.createResume(request);
            return new ResponseEntity<>(new ResumeApiResponse(true,response),
                    HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ResumeApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("/editResume")
    public ResponseEntity<?> editResume(@RequestBody UpdateResumeRequest request){
        try {
            UpdateResumeResponse response = resumeService.updateResume(request);
            return new ResponseEntity<>(new ResumeApiResponse(true, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ResumeApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> delete(@PathVariable String id){
        try {
           DeleteResumeResponse  response = resumeService.deleteResume(id) ;
           return new ResponseEntity<>(new ResumeApiResponse(true, response),
                   HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ResumeApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<?> displayAllResume(){
        try {
            List<Resume> allResume = resumeService.allResumes();
            return new ResponseEntity<>(new ResumeApiResponse(true, allResume),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ResumeApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{firstName}/{lastName}")
    public ResponseEntity<?> searchByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
     try {
         List<Resume> searchFirstNameAndLastName = resumeService.findResumeByFirstNameAndLastName(firstName,lastName);
         return new ResponseEntity<>(new ResumeApiResponse(true, searchFirstNameAndLastName),
                 HttpStatus.OK);
     }
     catch (Exception exception){
         return new ResponseEntity<>(new ResumeApiResponse(false, exception),
                 HttpStatus.BAD_REQUEST);
     }
    }
}
