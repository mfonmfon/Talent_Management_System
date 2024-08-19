package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.data.repository.FreelancerRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddFreelancerRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerLoginRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerRegisterRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerUpdateRequest;
import com.semicolon.africa.jobcrafter.dto.response.*;
import com.semicolon.africa.jobcrafter.exception.InCorrectPassword;
import com.semicolon.africa.jobcrafter.exception.InvalidFreelancerEmail;
import com.semicolon.africa.jobcrafter.exception.TitleAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FreelancerServiceImpl implements FreelancerServices {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Override
    public FreelancerRegisterResponse register(FreelancerRegisterRequest request) {
        validateEmail(request.getEmail());
        Freelancer freelancer = new Freelancer();
        freelancer.setEmail(request.getEmail());
        if (!freelancer.getEmail().contains("@") && freelancer.getEmail().contains(">")){
            throw new InvalidFreelancerEmail("OGA!! you no go school? " +
                    "Enter the correct email before we go fight now!!");
        }
        else if (!freelancerRepository.existsByEmail(freelancer.getEmail())){
            throw new InvalidFreelancerEmail("Already exist");
        }
        freelancer.setUserName(request.getUserName());
        freelancer.setPassword(request.getPassword());
        FreelancerRegisterResponse response = new FreelancerRegisterResponse();
        response.setEmail(freelancer.getEmail());
        response.setUserName(request.getUserName());
        response.setPassword(request.getPassword());
        response.setMessage("Register successfully");
        return response;
    }
    private void validateEmail(String email) {
       boolean isEmailExist = freelancerRepository.existsByEmail(email);
       if (isEmailExist){
           throw new InvalidFreelancerEmail("Already exist");
       }
    }

    @Override
    public FreelancerLoginResponse login(FreelancerLoginRequest request) {
        Freelancer freelancer = new Freelancer();
          if (freelancerRepository.existsByEmail(freelancer.getEmail())) {
            throw new InvalidFreelancerEmail("Already exist");
        }
          else if (freelancerRepository.existsByEmail(request.getEmail())) {
              throw new InvalidFreelancerEmail("Not Found");
          }else{
            freelancer.setLoggedIn(true);
            freelancerRepository.save(freelancer);
            FreelancerLoginResponse response = new FreelancerLoginResponse();
            response.setMessage("Login Successfully");
            response.setLoggedIn(freelancer.isLoggedIn());
            return response;
        }
    }

    private void validatePassword( String password) {
        if(freelancerRepository.findByPassword(password))
            throw new TitleAlreadyExist("invalid credentials");
    }

    private Freelancer findFreelancerByEmail(String email) {
        if (freelancerRepository.existsByEmail(email)){
            throw new InCorrectPassword("Email already exist");
        }
        return freelancerRepository.findByEmail(email);
    }

    @Override
    public FreelancerLogoutResponse logout(String email) {
        Freelancer freelancer = findFreelancerByEmail(email);
        freelancer.setLoggedIn(false);
        freelancerRepository.save(freelancer);
        FreelancerLogoutResponse response = new FreelancerLogoutResponse();
        response.setMessage("Logout successful");
        return response;
    }

    @Override
    public AddFreelancerResponse apply(AddFreelancerRequest request) {
        Freelancer freelancer = new Freelancer();
        freelancer.setFirstName(request.getFirstName());
        freelancer.setLastName(request.getLastName());
        freelancer.setJobTitle(request.getJobTitle());
        freelancer.setJobDescription(request.getJobDescription());
        freelancer.setPhoneNumber(request.getPhoneNumber());
        freelancer.setCv(request.getCv());
        freelancer.setJobType(request.getJobType());
        freelancer.setDateCreated(LocalDateTime.now());
        AddFreelancerResponse response = new AddFreelancerResponse();
        response.setFirstName(freelancer.getFirstName());
        response.setLastName(freelancer.getLastName());
        response.setJobTitle(freelancer.getJobTitle());
        response.setJobDescription(freelancer.getJobDescription());
        response.setEmail(freelancer.getEmail());
        response.setCv(freelancer.getCv());
        response.setJobType(freelancer.getJobType());
        response.setPhoneNumber(freelancer.getPhoneNumber());
        response.setMessage("Applied successfully");
        return response;
    }
    @Override
    public List<Freelancer> displayAllFreelancers() {
        return freelancerRepository.findAll();
    }

    @Override
    public FreelancerDeleteResponse withdrawApplication(String id) {
        Freelancer freelancer = findFreelancerById(id);
        freelancerRepository.delete(freelancer);
        FreelancerDeleteResponse response = new FreelancerDeleteResponse();
        response.setMessage("Deleted");
        return response;
    }

    private Freelancer findFreelancerById(String id) {
        for (Freelancer freelancer: freelancerRepository.findAll()){
            if (freelancer.getFreelancerId().equals(id)){
                return freelancer;
            }
        }
        throw new InvalidFreelancerEmail("Not Found");
    }

    @Override
    public FreelancerUpdateResponse updateApplication(FreelancerUpdateRequest request) {
        Freelancer freelancer = new Freelancer();
        freelancer.setFirstName(request.getFirstName());
        freelancer.setLastName(request.getLastName());
        freelancer.setJobTitle(request.getJobTitle());
        freelancer.setJobDescription(request.getJobDescription());
        freelancer.setPhoneNumber(request.getPhoneNumber());
        freelancer.setCv(request.getCv());
        freelancer.setJobType(request.getJobType());
        freelancer.setDateUpdated(request.getDateUpdated());
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


}
