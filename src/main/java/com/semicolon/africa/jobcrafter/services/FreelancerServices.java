package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.data.model.Task;
import com.semicolon.africa.jobcrafter.dto.request.AddFreelancerRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerLoginRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerUpdateRequest;
import com.semicolon.africa.jobcrafter.dto.response.*;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerRegisterRequest;

import java.util.List;

public interface FreelancerServices {

    FreelancerRegisterResponse register(FreelancerRegisterRequest request);

    FreelancerLoginResponse login(FreelancerLoginRequest request);

    FreelancerLogoutResponse logout(String email);
    AddFreelancerResponse apply(AddFreelancerRequest request);

    List<Task> displayAllTask();

    FreelancerDeleteResponse withdrawApplication(String id);

    FreelancerUpdateResponse updateApplication(FreelancerUpdateRequest request);
}
