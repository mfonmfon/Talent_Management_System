package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.repository.PostRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddPostRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdatePostRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddPostResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeletePostResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdatePostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServicesImplTest {

    @Autowired
    private  PostRepository postRepository;

    @Autowired
    private PostServices postServices;

    @BeforeEach
    void setUp() {
        postRepository.deleteAll();
    }

    @Test
    public void testThatPostCanBeAdded(){
        AddPostRequest request = new AddPostRequest();
        request.setTitle("Title");
        request.setDescription("Description");
        request.setFixedPrice("5000000");
        request.setLocation("Location");
        AddPostResponse responses = postServices.createdPost(request);
        assertThat(responses.getMessage()).contains("Post created successfully");
        assertThat(postRepository.count()).isEqualTo(1);
    }

    @Test
    public void testThatPostCanBeUpdated(){
        UpdatePostRequest request = new UpdatePostRequest();
        request.setTitle("New Title");
        request.setDescription("New Description");
        request.setLocation("New Location");
        UpdatePostResponse response = postServices.updatePost(request);
        assertThat(response.getMessage()).contains("You just updated your post");
    }

    @Test
    public void testThatPostCanBeDeleted(){
        AddPostRequest request = new AddPostRequest();
        AddPostResponse response = postServices.createdPost(request);
        String id = response.getPostId();
        DeletePostResponse response1 = postServices.deletePost(id);
        assertThat(response1.getMessage()).contains("Post deleted successfully");
    }
}