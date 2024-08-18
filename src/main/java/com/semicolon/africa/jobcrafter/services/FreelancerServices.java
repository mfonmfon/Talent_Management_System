package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.dto.request.AddFreelancerRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerLoginRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddFreelancerResponse;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerRegisterRequest;
import com.semicolon.africa.jobcrafter.dto.response.FreelancerLoginResponse;
import com.semicolon.africa.jobcrafter.dto.response.FreelancerLogoutResponse;
import com.semicolon.africa.jobcrafter.dto.response.FreelancerRegisterResponse;

import java.util.List;

public interface FreelancerServices {



    FreelancerRegisterResponse register(FreelancerRegisterRequest request);

    FreelancerLoginResponse login(FreelancerLoginRequest request);

    FreelancerLogoutResponse logout(String email);
    AddFreelancerResponse apply(AddFreelancerRequest request);

    List<Freelancer> displayAllFreelancers();


}
