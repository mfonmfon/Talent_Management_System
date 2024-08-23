package com.semicolon.africa.jobcrafter.data.repository;

import com.semicolon.africa.jobcrafter.data.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
