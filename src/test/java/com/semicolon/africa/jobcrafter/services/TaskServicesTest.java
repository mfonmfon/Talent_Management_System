package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.repository.TaskRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddTaskRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateTaskRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddTaskResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteResumeResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteTaskResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateTaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServicesTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskServices taskService;

    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
    }

    @Test
    void createTask() {
        AddTaskRequest request = new AddTaskRequest();
        request.setTitle("Create a landing page");
        request.setDescription("The landing page must be beautiful and responsive");
        request.setDeadLine("12/6/2024");
        AddTaskResponse response = taskService.createTask(request);
        assertThat(response.getMessage()).contains("Task created successfully");
        assertThat(response).isNotNull();
    }

    @Test
    void updatedTask() {
        UpdateTaskRequest request = new UpdateTaskRequest();
        request.setTitle("Link the backend");
        request.setDescription("Link you backend with react and save all your fields in the data base");
        request.setDeadLine("12/6/2024  ");
        UpdateTaskResponse response = taskService.updatedTask(request);
        assertThat(response.getMessage()).contains("Task updated successfully");
        assertThat(response).isNotNull();
    }

    @Test
    void deleteTask() {
        AddTaskRequest request = new AddTaskRequest();
        AddTaskResponse response = taskService.createTask(request);
        assertThat(response.getMessage()).contains("Task created successfully");
        String id = response.getTaskId();
        DeleteTaskResponse response1 = taskService.deleteTask(id);
        assertThat(response1.getMessage()).contains("Task deleted");
    }

    @Test
    void tasks() {
    }

    @Test
    void findTasksByTitle() {
    }

    @Test
    void findTaskByDescription() {
    }
}