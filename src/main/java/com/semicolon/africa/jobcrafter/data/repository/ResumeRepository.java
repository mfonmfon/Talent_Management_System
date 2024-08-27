package com.semicolon.africa.jobcrafter.data.repository;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResumeRepository extends MongoRepository<Resume, String> {
    boolean existsByEmail(String email);

    List<Resume> findResumeByFirstNameAndLastName(String firstName, String lastName);


}
