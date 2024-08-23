package com.semicolon.africa.jobcrafter.utils;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.dto.response.AddFreelancerResponse;

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

}
