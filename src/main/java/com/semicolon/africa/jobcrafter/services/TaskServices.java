package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Task;
import com.semicolon.africa.jobcrafter.dto.request.AddTaskRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateTaskRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddTaskResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteTaskResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateTaskResponse;

import java.util.List;

public interface TaskServices {
    AddTaskResponse createTask(AddTaskRequest request);

    UpdateTaskResponse updatedTask(UpdateTaskRequest request);

    DeleteTaskResponse deleteTask(String id);

    List<Task> tasks();

    List<Task> findTasksByTitle(String title);

    List<Task> findTaskByDescription(String description);
}
