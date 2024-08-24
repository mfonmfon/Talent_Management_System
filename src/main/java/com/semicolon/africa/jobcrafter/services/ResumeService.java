package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import com.semicolon.africa.jobcrafter.dto.request.AddResumeRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateResumeRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateResumeResponse;

import java.util.List;

public interface ResumeService {

    AddResumeResponse createResume(AddResumeRequest request);

    UpdateResumeResponse updateResume(UpdateResumeRequest request);

    DeleteResumeResponse deleteResume(String id);

    List<Resume> allResumes();
}
