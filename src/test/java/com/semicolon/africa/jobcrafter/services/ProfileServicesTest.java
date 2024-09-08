package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Profile;
import com.semicolon.africa.jobcrafter.data.repository.ProfileRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddPostRequest;
import com.semicolon.africa.jobcrafter.dto.request.AddProfileRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateProfileRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddProfileResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteProfileResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateProfileResponse;
import com.semicolon.africa.jobcrafter.exception.EmailNotExistException;
import com.semicolon.africa.jobcrafter.exception.EmptyFieldsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfileServicesTest {

    @Autowired
    private ProfileServices profileServices;

    @Autowired
    private ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
        profileRepository.deleteAll();
    }
    @Test
    public void testThatProfileCanBeAdded(){
        AddProfileRequest profileRequest = createProfile();
        AddProfileResponse response = profileServices.addProfile(profileRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Successfully added Profile");
    }

    private static AddProfileRequest createProfile() {
        AddProfileRequest profileRequest = new AddProfileRequest();
        profileRequest.setFirstName("Janet");
        profileRequest.setLastName("Oluwafemi");
        profileRequest.setUserName("janetoluwa");
        profileRequest.setEmail("janet@gmail.com");
        profileRequest.setBio("software engineer");
        profileRequest.setCountry("Nigeria");
        profileRequest.setStateOfOrigin("Lagos");
        profileRequest.setResidence("Bariga");
        profileRequest.setPhoneNumber("90346512345");
        profileRequest.setPassword("12345");
        return profileRequest;
    }
    @Test
    public void testThatProfile_canUpdateProfile(){
        UpdateProfileRequest request = new UpdateProfileRequest();
        createProfile();
        UpdateProfileResponse response = profileServices.updateProfile(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Updated successfully");
    }
    @Test
    public void testThatProfileCanBeDeletedById(){
        createProfile();
        AddProfileResponse response = profileServices.addProfile(createProfile());
        assertThat(response.getMessage()).contains("Successfully added Profile");
        String id = response.getProfileId();
        DeleteProfileResponse response1 = profileServices.deleteProfile(id);
        assertThat(response1.getMessage()).contains("Deleted");
    }

    @Test
    public void testThatWhenAllTheFieldsAreEmpty_throwAnException(){
        AddProfileRequest profileRequest = new AddProfileRequest();
        profileRequest.setFirstName("");
        profileRequest.setLastName("");
        profileRequest.setUserName("");
        profileRequest.setEmail("");
        profileRequest.setBio("");
        profileRequest.setCountry("");
        profileRequest.setStateOfOrigin("");
        profileRequest.setResidence("");
        profileRequest.setPhoneNumber("");
        profileRequest.setPassword("");
        assertThrows(EmptyFieldsException.class, ()-> profileServices.addProfile(profileRequest));
    }
}