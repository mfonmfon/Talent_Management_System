package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Post;
import com.semicolon.africa.jobcrafter.dto.request.AddPostRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdatePostRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddPostResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeletePostResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdatePostResponse;

import java.util.List;

public interface PostServices {

    AddPostResponse createdPost(AddPostRequest request);

    UpdatePostResponse updatePost(UpdatePostRequest request);

    DeletePostResponse deletePost(String id);

    List<Post> findAllPosts();

}
