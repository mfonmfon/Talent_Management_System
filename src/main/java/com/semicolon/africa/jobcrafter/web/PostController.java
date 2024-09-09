package com.semicolon.africa.jobcrafter.web;

import com.semicolon.africa.jobcrafter.data.model.Post;
import com.semicolon.africa.jobcrafter.dto.request.AddPostRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdatePostRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddPostResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeletePostResponse;
import com.semicolon.africa.jobcrafter.dto.response.PostApiResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdatePostResponse;
import com.semicolon.africa.jobcrafter.services.PostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostServices postServices;

    @PostMapping("/addPost")
    public ResponseEntity<?> addPost(@RequestBody AddPostRequest request){
        try {
            AddPostResponse responses = postServices.createdPost(request);
            return new ResponseEntity<>(new PostApiResponse(true, responses),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new PostApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("/updatePost")
    public ResponseEntity<?> updatePost(@RequestBody UpdatePostRequest request){
        try {
            UpdatePostResponse response = postServices.updatePost(request);
            return new ResponseEntity<>(new PostApiResponse(true, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
         return new ResponseEntity<>(new PostApiResponse(false, exception.getMessage()),
                 HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable  String id){
        try {
            DeletePostResponse response = postServices.deletePost(id);
           return new ResponseEntity<>(new PostApiResponse(true, response),
                   HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new PostApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllPosts(){
        try {
            List<Post>  findAllPosts = postServices.findAllPosts();
            return new ResponseEntity<>(new PostApiResponse(true, findAllPosts),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new PostApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
