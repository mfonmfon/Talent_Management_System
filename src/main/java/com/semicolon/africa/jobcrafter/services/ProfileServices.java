package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Profile;
import com.semicolon.africa.jobcrafter.dto.request.AddProfileRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateProfileRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddProfileResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteProfileResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateProfileResponse;

import java.util.List;

public interface ProfileServices {

    AddProfileResponse addProfile(AddProfileRequest request);

    UpdateProfileResponse updateProfile(UpdateProfileRequest request);

    DeleteProfileResponse deleteProfile(String id);

    List<Profile> allProfile();

    List<Profile> searchByFirstName(String firstName);

    List<Profile> searchByLastName(String lastName);

    List<Profile> searchByUserName(String userName);
}
