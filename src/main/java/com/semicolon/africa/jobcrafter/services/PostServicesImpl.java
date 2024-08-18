package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Post;
import com.semicolon.africa.jobcrafter.data.repository.PostRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddPostRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdatePostRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddPostResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeletePostResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdatePostResponse;
import com.semicolon.africa.jobcrafter.exception.PostIdNotFound;
import com.semicolon.africa.jobcrafter.exception.TitleAlreadyExist;
import com.semicolon.africa.jobcrafter.exception.TitleDoesNitExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServicesImpl implements  PostServices {

    @Autowired
    private  PostRepository postRepository;

    @Override
    public AddPostResponse createdPost(AddPostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        post.setFixedPrice(request.getFixedPrice());
        post.setLocation(request.getLocation());
        post.setDateCreated(request.getDateCreated());
        postRepository.save(post);
        AddPostResponse responses = new AddPostResponse();
        responses.setPostId(post.getId());
        responses.setTitle(post.getTitle());
        responses.setDescription(post.getDescription());
        responses.setFixedPrice(post.getFixedPrice());
        responses.setLocation(post.getLocation());
        responses.setDateCreated(LocalDateTime.now());
        responses.setMessage("Post created successfully");
        return responses;
    }
    private void validateTitle(String title) {
        boolean isTitleExists = postRepository.existsByTitle(title);
        if (isTitleExists){
            throw new TitleAlreadyExist("This title already exist," +
                    " please created with new title");
        }
    }
    @Override
    public UpdatePostResponse updatePost(UpdatePostRequest request) {
        Post post = findPostByTitle(request.getTitle());
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        post.setFixedPrice(request.getFixedPrice());
        post.setLocation(request.getLocation());
        post.setDateUpdated(post.getDateUpdated());
        postRepository.save(post);
        UpdatePostResponse response = new UpdatePostResponse();
        response.setTitle(post.getTitle());
        response.setDescription(post.getDescription());
        response.setFixedPrice(post.getFixedPrice());
        response.setLocation(post.getLocation());
        response.setMessage("You just updated your post");
        return response;
    }

    private Post findPostByTitle(String title) {
        return postRepository.findByTitle(title).
                orElseThrow(()-> new TitleDoesNitExistException("Title already exists"));
    }

    @Override
    public DeletePostResponse deletePost(String id) {
       Post post = findPostById(id);
       postRepository.delete(post);
       DeletePostResponse response = new DeletePostResponse();
       response.setMessage("Post deleted successfully");
        return response;
    }

    private Post findPostById(String id) {
        return postRepository.findById(id).
                orElseThrow(()-> new PostIdNotFound(" Post Not Found"));
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
