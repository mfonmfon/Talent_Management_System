package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import com.semicolon.africa.jobcrafter.data.repository.ResumeRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddResumeRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateResumeRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateResumeResponse;
import com.semicolon.africa.jobcrafter.exception.FirstNameNotFound;
import com.semicolon.africa.jobcrafter.exception.ResumeEmailNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.jobcrafter.utils.Mapper.*;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    private ResumeRepository resumeRepository;


    @Override
    public AddResumeResponse createResume(AddResumeRequest request) {
        validateResumeEmail(request.getEmail());
        Resume resume = createResumeRequestMapper(request);
        resume = resumeRepository.save(resume);
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
        validateResumeEmail(request.getEmail());
        Resume resume = getResumeUpdate(request);
        resume= resumeRepository.save(resume);
        return getUpdateResumeResponse(resume);
    }

    @Override
    public DeleteResumeResponse deleteResume(String id) {
        Resume resume = findResumeById(id);
        resumeRepository.delete(resume);
        DeleteResumeResponse response = new DeleteResumeResponse();
        response.setMessage("Resume Deleted");
        return response;
    }

    private Resume findResumeById(String id) {
        return resumeRepository.findById(id)
                .orElseThrow(()-> new ResumeEmailNotFound("Id not found"));
    }

    @Override
    public List<Resume> allResumes() {
        return resumeRepository.findAll();
    }

    @Override
    public List<Resume> findResumeByFirstNameAndLastName(String firstName, String lastName) {
        return resumeRepository.findResumeByFirstNameAndLastName(firstName, lastName);
    }
}
