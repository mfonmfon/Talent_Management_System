package com.semicolon.africa.jobcrafter.data.repository;

import com.semicolon.africa.jobcrafter.data.model.Freelancer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FreelancerRepository extends MongoRepository<Freelancer, String> {

    boolean existsByEmail(String email);

    Freelancer findByEmail(String email);

    boolean findByPassword(String password);

    boolean existsByPassword(String password);

}
