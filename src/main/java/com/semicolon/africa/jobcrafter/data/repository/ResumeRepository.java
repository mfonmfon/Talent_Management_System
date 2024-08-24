package com.semicolon.africa.jobcrafter.data.repository;

import com.semicolon.africa.jobcrafter.data.model.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResumeRepository extends MongoRepository<Resume, String> {
    boolean existsByEmail(String email);

}
