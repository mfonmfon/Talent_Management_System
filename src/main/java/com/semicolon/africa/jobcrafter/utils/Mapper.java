package com.semicolon.africa.jobcrafter.utils;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.data.model.Profile;
import com.semicolon.africa.jobcrafter.data.model.Resume;
import com.semicolon.africa.jobcrafter.dto.request.*;
import com.semicolon.africa.jobcrafter.dto.response.*;
import com.semicolon.africa.jobcrafter.exception.IncorrectEmailInput;

public class Mapper {

    public static AddFreelancerResponse getAddFreelancerResponse(Freelancer freelancer) {
        AddFreelancerResponse response = new AddFreelancerResponse();
        response.setFreelancerId(freelancer.getId());
        response.setFirstName(freelancer.getFirstName());
        response.setLastName(freelancer.getLastName());
        response.setJobTitle(freelancer.getJobTitle());
        response.setJobDescription(freelancer.getJobDescription());
        response.setEmail(freelancer.getEmail());
        response.setCv(freelancer.getCv());
        response.setJobType(freelancer.getJobType());
        response.setPhoneNumber(freelancer.getPhoneNumber());
        response.setDateApplied(freelancer.getDateCreated());
        response.setMessage("Applied successfully");
        return response;
    }

    public static FreelancerUpdateResponse getFreelancerUpdateResponse(Freelancer freelancer) {
        FreelancerUpdateResponse response = new FreelancerUpdateResponse();
        response.setFirstName(freelancer.getFirstName());
        response.setLastName(freelancer.getLastName());
        response.setJobTitle(freelancer.getJobTitle());
        response.setJobDescription(freelancer.getJobDescription());
        response.setEmail(freelancer.getEmail());
        response.setCv(freelancer.getCv());
        response.setJobType(freelancer.getJobType());
        response.setPhoneNumber(freelancer.getPhoneNumber());
        response.setDateUpdated(freelancer.getDateUpdated());
        response.setMessage("Updated successfully");
        return response;
    }


    public static Resume createResumeRequestMapper(AddResumeRequest request) {
        Resume resume = new Resume();
        resume.setFirstName(request.getFirstName());
        resume.setLastName(request.getLastName());
        resume.setEmail(request.getEmail());
        resume.setPhoneNumber(request.getPhoneNumber());
        resume.setHomeAddress(request.getHomeAddress());
        resume.setPosition(request.getPosition());
        resume.setVolunteer(request.getVolunteer());
        resume.setPersonalProjects(request.getPersonalProjects());
        resume.setWorkExperience(request.getWorkExperience());
        resume.setSkills(request.getSkills());
        resume.setFormerCompany(request.getFormerCompany());
        resume.setEducationStatus(request.getEducationStatus());
        resume.setMarriageStatus(request.getMarriageStatus());
        resume.setCertificate(request.getCertificate());
        return resume;
    }

    public static AddResumeResponse getAddResumeResponse(Resume resume) {
        AddResumeResponse response = new AddResumeResponse();
        response.setResumeId(resume.getId());
        response.setFirstName(resume.getFirstName());
        response.setLastName(resume.getLastName());
        response.setEmail(resume.getEmail());
        response.setPhoneNumber(resume.getPhoneNumber());
        response.setHomeAddress(resume.getHomeAddress());
        response.setPosition(resume.getPosition());
        response.setVolunteer(resume.getVolunteer());
        response.setPersonalProjects(resume.getPersonalProjects());
        response.setWorkExperience(resume.getWorkExperience());
        response.setSkills(resume.getSkills());
        response.setFormerCompany(resume.getFormerCompany());
        response.setEducationStatus(resume.getEducationStatus());
        response.setMarriageStatus(resume.getMarriageStatus());
        response.setCertificate(resume.getCertificate());
        response.setMessage("Successfully created resume");
        return response;
    }

    public static Resume getResumeUpdate(UpdateResumeRequest request) {
        Resume resume = new Resume();
        resume.setFirstName(request.getFirstName());
        resume.setFirstName(request.getFirstName());
        resume.setLastName(request.getLastName());
        resume.setEmail(request.getEmail());
        resume.setPhoneNumber(request.getPhoneNumber());
        resume.setHomeAddress(request.getHomeAddress());
        resume.setPosition(request.getPosition());
        resume.setVolunteer(request.getVolunteer());
        resume.setPersonalProjects(request.getPersonalProjects());
        resume.setWorkExperience(request.getWorkExperience());
        resume.setSkills(request.getSkills());
        resume.setFormerCompany(request.getFormerCompany());
        resume.setEducationStatus(request.getEducationStatus());
        resume.setMarriageStatus(request.getMarriageStatus());
        resume.setCertificate(request.getCertificate());
        return resume;
    }

    public static UpdateResumeResponse getUpdateResumeResponse(Resume resume) {
        UpdateResumeResponse response = new UpdateResumeResponse();
        response.setFirstName(resume.getFirstName());
        response.setLastName(resume.getLastName());
        response.setEmail(resume.getEmail());
        response.setPhoneNumber(resume.getPhoneNumber());
        response.setHomeAddress(resume.getHomeAddress());
        response.setPosition(resume.getPosition());
        response.setVolunteer(resume.getVolunteer());
        response.setPersonalProjects(resume.getPersonalProjects());
        response.setWorkExperience(resume.getWorkExperience());
        response.setSkills(resume.getSkills());
        response.setFormerCompany(resume.getFormerCompany());
        response.setEducationStatus(resume.getEducationStatus());
        response.setMarriageStatus(resume.getMarriageStatus());
        response.setCertificate(resume.getCertificate());
        response.setMessage("Successfully Updated");
        return response;
    }

    private void freelancerAddRequest(AddFreelancerRequest request, Freelancer freelancer) {
        freelancer.setFirstName(request.getFirstName());
        freelancer.setLastName(request.getLastName());
        freelancer.setJobTitle(request.getJobTitle());
        freelancer.setJobDescription(request.getJobDescription());
        freelancer.setPhoneNumber(request.getPhoneNumber());
        freelancer.setEmail(request.getEmail());
        freelancer.setCv(request.getCv());
        freelancer.setJobType(request.getJobType());
        freelancer.setDateCreated(request.getDateApplied());
    }

    public static void addProfileRequest(AddProfileRequest request, Profile profile) {
        profile.setFirstName(request.getFirstName());
        profile.setLastName(request.getLastName());
        profile.setEmail(request.getEmail());
        profile.setUserName(request.getUserName());
        if (!(profile.getEmail().contains("@")) && profile.getEmail().contains(".")){
            throw new IncorrectEmailInput("Enter a valid email");
        }
        profile.setEmail(request.getBio());
        profile.setPhoneNumber(request.getPhoneNumber());
        profile.setCountry(request.getCountry());
        profile.setStateOfOrigin(request.getStateOfOrigin());
        profile.setResidence(request.getResidence());
//        profile.setPassword(request.getPassword());
    }

    public static AddProfileResponse getAddProfileResponse(Profile profile) {
        AddProfileResponse response = new AddProfileResponse();
        response.setProfileId(profile.getId());
        response.setFirstName(profile.getFirstName());
        response.setLastName(profile.getLastName());
        response.setEmail(profile.getEmail());
        response.setPhoneNumber(profile.getPhoneNumber());
        response.setBio(profile.getBio());
        response.setCountry(profile.getCountry());
        response.setStateOfOrigin(profile.getStateOfOrigin());
        response.setResidence(profile.getResidence());
        response.setPassword(profile.getPassword());
        response.setMessage("Successfully added Profile");
        return response;
    }

    public static UpdateProfileResponse getUpdateProfileResponse(Profile profile) {
        UpdateProfileResponse response = new UpdateProfileResponse();
        response.setFirstName(profile.getFirstName());
        response.setLastName(profile.getLastName());
        response.setUserName(profile.getUserName());
        response.setBio(profile.getBio());
        response.setEmail(profile.getEmail());
        response.setPhoneNumber(profile.getPhoneNumber());
        response.setCountry(profile.getCountry());
        response.setStateOfOrigin(profile.getStateOfOrigin());
        response.setResidence(profile.getResidence());
        response.setMessage("Updated successfully");
        return response;
    }

    public static Profile UpdateProfileRequest(UpdateProfileRequest request) {
        Profile profile = new Profile();
        profile.setFirstName(request.getFirstName());
        profile.setLastName(request.getLastName());
        profile.setUserName(request.getUserName());
        profile.setBio(request.getBio());
        profile.setEmail(request.getEmail());
        profile.setPhoneNumber(request.getPhoneNumber());
        profile.setCountry(request.getCountry());
        profile.setStateOfOrigin(request.getStateOfOrigin());
        profile.setResidence(request.getResidence());
        profile.setPassword(request.getPassword());
        profile.setPhoneNumber(request.getPhoneNumber());
        return profile;
    }

}
