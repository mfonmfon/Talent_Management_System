package com.semicolon.africa.jobcrafter.utils;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.data.model.Resume;
import com.semicolon.africa.jobcrafter.dto.request.AddResumeRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateResumeRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddFreelancerResponse;
import com.semicolon.africa.jobcrafter.dto.response.AddResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.FreelancerUpdateResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateResumeResponse;

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



}
