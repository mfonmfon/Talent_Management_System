package com.semicolon.africa.jobcrafter.data.repository;

import com.semicolon.africa.jobcrafter.data.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProfileRepository extends MongoRepository<Profile,String> {
    List<Profile> findByFirstName(String firstName);

    List<Profile> findByUserName(String userName);

    List<Profile> findByLastName(String lastName);
}
