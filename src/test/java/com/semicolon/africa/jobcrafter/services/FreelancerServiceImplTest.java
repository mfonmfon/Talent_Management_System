package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.data.repository.FreelancerRepository;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerRegisterRequest;
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
        freelancerRepository.deleteAll();
    }

    @Test
    public void testThatUsersCanApplyAsFreelancers(){
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
}