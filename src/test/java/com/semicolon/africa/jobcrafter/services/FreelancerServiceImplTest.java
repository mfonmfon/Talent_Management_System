package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.data.repository.FreelancerRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddFreelancerRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerLoginRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerRegisterRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddFreelancerResponse;
import com.semicolon.africa.jobcrafter.dto.response.FreelancerLoginResponse;
import com.semicolon.africa.jobcrafter.dto.response.FreelancerRegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class FreelancerServiceImplTest {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private FreelancerServices freelancerServices;

    @BeforeEach
    void setUp() {
        freelancerServices.delete();
        freelancerRepository.deleteAll();
    }

    @Test
    public void testThatUsersCanRegisterAsFreelancers(){
        FreelancerRegisterRequest request = new FreelancerRegisterRequest();
        request.setEmail("mfon@gmail.com");
        request.setUserName("fonzi");
        request.setEmail("1234");
        FreelancerRegisterResponse response = freelancerServices.register(request);
        assertThat(response.getMessage()).contains("Register successfully");
    }
    @Test
    public void testThatTwoUsersCanNotRegisterWithTheSamePassWord(){
        FreelancerRegisterRequest request = new FreelancerRegisterRequest();
        request.setEmail("mfon@gmail.com");
        request.setUserName("fonzi");
        request.setPassword("1234");
        FreelancerRegisterResponse response = freelancerServices.register(request);
        assertThat(response.getMessage()).contains("Register successfully");
        FreelancerRegisterRequest request1 = new FreelancerRegisterRequest();
        request.setEmail("mfon@gmail.com");
        request.setUserName("fonzi");
        request.setPassword("1234");
        FreelancerRegisterResponse response1 = freelancerServices.register(request1);
        assertThat(response1.getMessage()).contains("Register successfully");
    }

    @Test
    public void testThatFreelancerCanApplyForJob(){
        AddFreelancerRequest request = new AddFreelancerRequest();
        request.setFirstName("Mfon");
        request.setLastName("Collin");
        request.setEmail("mfon@gmail.com");
        request.setJobTitle("Title");
        request.setJobDescription("Description");
        request.setPhoneNumber("089000988");
        request.setJobType("Backend engineer");
        AddFreelancerResponse response = freelancerServices.apply(request);
        assertThat(response.getMessage()).contains("Applied successfully");
    }
    @Test
    public void testThatFreelancersCanLogin(){
        FreelancerRegisterRequest request = new FreelancerRegisterRequest();
        request.setEmail("mfon@gmail.com");
        request.setUserName("fonzi");
        request.setPassword("1234");
        FreelancerRegisterResponse response = freelancerServices.register(request);
        assertThat(response.getMessage()).contains("Register successfully");
        FreelancerLoginRequest request1 = new FreelancerLoginRequest();
        request1.setEmail("mfon@gmail.com");
        request1.setPassword("1234");
        FreelancerLoginResponse response1 = freelancerServices.login(request1);
        assertThat(response1.getMessage()).contains("Login Successful");
    }
}