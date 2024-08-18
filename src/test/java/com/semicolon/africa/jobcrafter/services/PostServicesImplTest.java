package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.repository.PostRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddPostRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddPostResponse;
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
}