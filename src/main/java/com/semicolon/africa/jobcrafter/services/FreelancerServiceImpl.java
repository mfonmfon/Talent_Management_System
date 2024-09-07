package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import com.semicolon.africa.jobcrafter.data.model.Task;
import com.semicolon.africa.jobcrafter.data.repository.FreelancerRepository;
import com.semicolon.africa.jobcrafter.data.repository.TaskRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddFreelancerRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerLoginRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerRegisterRequest;
import com.semicolon.africa.jobcrafter.dto.request.FreelancerUpdateRequest;
import com.semicolon.africa.jobcrafter.dto.response.*;
import com.semicolon.africa.jobcrafter.exception.EmailNotExistException;
import com.semicolon.africa.jobcrafter.exception.InCorrectPassword;
import com.semicolon.africa.jobcrafter.exception.InvalidFreelancerEmail;
import com.semicolon.africa.jobcrafter.exception.TitleAlreadyExist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.jobcrafter.utils.Mapper.getAddFreelancerResponse;
import static com.semicolon.africa.jobcrafter.utils.Mapper.getFreelancerUpdateResponse;

@Service
public class FreelancerServiceImpl implements FreelancerServices {

    private static final Logger log = LoggerFactory.getLogger(FreelancerServiceImpl.class);
    @Autowired
    private FreelancerRepository freelancerRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public FreelancerRegisterResponse register(FreelancerRegisterRequest request) {
            Freelancer freelancer = new Freelancer();
            validateEmail(request.getEmail());
            freelancer.setEmail(request.getEmail());
            freelancer.setUserName(request.getUserName());
            freelancer.setPassword(request.getPassword());
        if (!freelancer.getEmail().contains("@") || !freelancer.getEmail().contains(".")) {
            throw new InvalidFreelancerEmail("Invalid email format, please check the " +
                    "email and signup again");
        } else {
            FreelancerRegisterResponse response = new FreelancerRegisterResponse();
            response.setEmail(freelancer.getEmail());
            response.setUserName(request.getUserName());
            response.setPassword(request.getPassword());
            response.setMessage("Register successfully");
            return response;
        }
    }
    private void validateEmail(String email) {
       boolean isEmailExist = freelancerRepository.existsByEmail(email);
       if (isEmailExist){
           throw new InvalidFreelancerEmail("Already exist");
       }
    }
    @Override
    public FreelancerLoginResponse login(FreelancerLoginRequest request) {
        validatePassword(request.getPassword());
        Freelancer freelancer = new Freelancer();
        if (!freelancer.getEmail().contains("@") || !freelancer.getEmail().contains(".")) {
            throw new InvalidFreelancerEmail("Invalid email format, please check the" +
                    "email and signup again");
        }
          if (!freelancerRepository.existsByEmail(request.getEmail()) || !freelancerRepository
                  .existsByEmail(request.getEmail())) {
              throw new InvalidFreelancerEmail("Invalid Details");
          } else {
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
        if (!freelancerRepository.existsByEmail(email)){
            throw new InCorrectPassword("Email does not exist");
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
        findFreelancerByEmail(request.getEmail());
        freelancer.setFirstName(request.getFirstName());
        freelancer.setLastName(request.getLastName());
        freelancer.setJobTitle(request.getJobTitle());
        freelancer.setJobDescription(request.getJobDescription());
        freelancer.setPhoneNumber(request.getPhoneNumber());
        freelancer.setEmail(request.getEmail());
        freelancer.setCv(request.getCv());
        freelancer.setJobType(request.getJobType());
        freelancer.setDateCreated(request.getDateApplied());
            freelancerRepository.save(freelancer);
            return getAddFreelancerResponse(freelancer);
        }

    @Override
    public List<Task> displayAllTask() {
        return taskRepository.findAll();
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
            if (freelancer.getId().equals(id)){
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
        freelancerRepository.save(freelancer);
        return getFreelancerUpdateResponse(freelancer);
    }


}
