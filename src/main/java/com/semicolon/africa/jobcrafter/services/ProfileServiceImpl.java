package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.data.model.Profile;
import com.semicolon.africa.jobcrafter.data.repository.FreelancerRepository;
import com.semicolon.africa.jobcrafter.data.repository.ProfileRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddProfileRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateProfileRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddProfileResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteProfileResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateProfileResponse;
import com.semicolon.africa.jobcrafter.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import static ch.qos.logback.core.util.StringUtil.isNullOrEmpty;
import static com.semicolon.africa.jobcrafter.utils.Mapper.*;

@Service
public class ProfileServiceImpl implements ProfileServices{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public AddProfileResponse addProfile(AddProfileRequest request) {
        Profile profile = new Profile();
        addProfileRequest(request, profile);
        if (isValueNullOrEmpty(profile.getFirstName()) ||
                isValueNullOrEmpty(profile.getLastName())||
                isValueNullOrEmpty(profile.getEmail()) ||
                isValueNullOrEmpty(profile.getPhoneNumber())||
                isValueNullOrEmpty(profile.getBio()) ||
                isValueNullOrEmpty(profile.getCountry()) ||
                isValueNullOrEmpty(profile.getResidence()) ||
                isValueNullOrEmpty(profile.getStateOfOrigin())) {
            throw new EmptyFieldsException("Empty Fields, please enter all fields");
        }
            profileRepository.save(profile);
            return getAddProfileResponse(profile);
        }
    private boolean isValueNullOrEmpty(String value){
        boolean isValueEmpty =  value == null || value.trim().isEmpty();
        if (isValueEmpty){
            throw new NoFieldsFoundException("Empty Fields, please enter all fields");
        }
        return Boolean.parseBoolean(value);
    }

    @Override
    public UpdateProfileResponse updateProfile(UpdateProfileRequest request) {
        Profile profile = UpdateProfileRequest(request);
        if (isValueNullOrEmpty(profile.getFirstName())||
                isValueNullOrEmpty(profile.getLastName()) ||
                isValueNullOrEmpty(profile.getEmail()) ||
                isValueNullOrEmpty(profile.getPhoneNumber())||
                isValueNullOrEmpty(profile.getBio())||
                isValueNullOrEmpty(profile.getCountry())||
                isValueNullOrEmpty(profile.getResidence()) ||
                isValueNullOrEmpty(profile.getStateOfOrigin())){
            throw new EmptyFieldsException("Empty Fields, please enter all fields");
        }
        profileRepository.save(profile);
        return getUpdateProfileResponse(profile);
    }
    @Override
    public DeleteProfileResponse deleteProfile(String id) {
        Profile profile = findProfileById(id);
        profileRepository.delete(profile);
        DeleteProfileResponse response = new DeleteProfileResponse();
        response.setMessage("Profile Deleted");
        return response;
    }
    private Profile findProfileById(String id) {
        return profileRepository.findById(id).
                orElseThrow(()->new ProfileIdNotFound("Profile ID Not Found"));
    }
    @Override
    public List<Profile> allProfile() {
        return profileRepository.findAll();
    }
    @Override
    public List<Profile> searchByFirstName(String firstName) {
        return profileRepository.findByFirstName(firstName);
    }
    @Override
    public List<Profile> searchByLastName(String firstName) {
        return profileRepository.findByFirstName(firstName);
    }
    @Override
    public List<Profile> searchByUserName(String userName) {
        return profileRepository.findByUserName(userName);
    }
}
