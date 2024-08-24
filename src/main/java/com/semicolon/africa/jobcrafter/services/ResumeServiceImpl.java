package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import com.semicolon.africa.jobcrafter.data.repository.ResumeRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddResumeRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateResumeRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateResumeResponse;
import com.semicolon.africa.jobcrafter.exception.ResumeEmailNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.jobcrafter.utils.Mapper.createResumeRequestMapper;
import static com.semicolon.africa.jobcrafter.utils.Mapper.getAddResumeResponse;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    private ResumeRepository resumeRepository;


    @Override
    public AddResumeResponse createResume(AddResumeRequest request) {
        Resume resume = createResumeRequestMapper(request);
        validateResumeEmail(request.getEmail());
        resumeRepository.save(resume);
        return getAddResumeResponse(resume);
    }

    private void validateResumeEmail(String email) {
        boolean isValidEmail = resumeRepository.existsByEmail(email);
        if (isValidEmail){
            throw new ResumeEmailNotFound("Email Already exist");
        }
    }


    @Override
    public UpdateResumeResponse updateResume(UpdateResumeRequest request) {
        Resume resume = new Resume();
        resume.setFirstName(request.getFirstName());

        return null;
    }

    @Override
    public DeleteResumeResponse deleteResume(String id) {
        return null;
    }

    @Override
    public List<Resume> allResumes() {
        return List.of();
    }
}
