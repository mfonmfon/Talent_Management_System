package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.repository.ResumeRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddResumeRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateResumeRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateResumeResponse;
import com.semicolon.africa.jobcrafter.exception.ResumeEmailNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResumeServiceImplTest {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private ResumeService resumeService;

    @BeforeEach
    void setUp() {
        resumeRepository.deleteAll();
    }

    @Test
    public void testThatResumeCanBeCreated() {
        AddResumeRequest request = addResumeMapper();
        AddResumeResponse response = resumeService.createResume(request);
        assertThat(response.getMessage()).contains("Successfully created resume");
        assertThat(resumeService.allResumes().size()).isEqualTo(1L);
        assertThat(response).isNotNull();
    }

    private static AddResumeRequest addResumeMapper() {
        AddResumeRequest request = new AddResumeRequest();
        request.setFirstName("Edward");
        request.setLastName("Progress");
        request.setEmail("edward@gmail.com");
        request.setPhoneNumber("0825407012");
        request.setHomeAddress("Yaba, Lagos");
        request.setPosition("Software engineer");
        request.setVolunteer("Work on different project");
        request.setPersonalProjects("Build world greatest project");
        request.setWorkExperience("bla bla bla");
        request.setSkills("ssss");
        request.setFormerCompany("Google");
        request.setEducationStatus("Degree");
        request.setMarriageStatus("Single");
        request.setCertificate("3.5");
        return request;
    }

    @Test
    public void testThatResumeCanBeUpdated() {
        AddResumeRequest response = addResumeMapper();
        UpdateResumeRequest request = getUpdateResumeRequest();
        UpdateResumeResponse response1 = resumeService.updateResume(request);
        assertThat(response1).isNotNull();
        assertThat(response1.getMessage()).contains("Successfully Updated");
        assertThat(response).isNotNull();
    }

    private static UpdateResumeRequest getUpdateResumeRequest() {
        UpdateResumeRequest request = new UpdateResumeRequest();
        request.setFirstName("Edward");
        request.setLastName("Progress");
        request.setEmail("edward@gmail.com");
        request.setPhoneNumber("0825407012");
        request.setHomeAddress("Yaba, Lagos");
        request.setPosition("Software engineer");
        request.setVolunteer("Work on different project");
        request.setPersonalProjects("Build world greatest project");
        request.setWorkExperience("bla bla bla");
        request.setSkills("ssss");
        request.setFormerCompany("Google");
        request.setEducationStatus("Degree");
        request.setMarriageStatus("Single");
        request.setCertificate("3.5");
        return request;
    }


    @Test
    public void testThatEmailCanNotBeUsedTwoTimes() {
        AddResumeRequest request = addResumeMapper();
        AddResumeResponse response = resumeService.createResume(request);
        assertThrows(ResumeEmailNotFound.class, () -> resumeService.createResume(request));
    }

    @Test
    public void testThatResumeCanBeDeleted() {
        AddResumeRequest request = addResumeMapper();
        AddResumeResponse response =  resumeService.createResume(request);
        String id = response.getResumeId();
        DeleteResumeResponse response1 = resumeService.deleteResume(id);
        assertThat(response1.getMessage()).contains("Resume Deleted");
    }
}