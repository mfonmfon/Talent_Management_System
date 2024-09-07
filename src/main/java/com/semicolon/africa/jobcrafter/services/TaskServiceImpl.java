package com.semicolon.africa.jobcrafter.services;

import com.semicolon.africa.jobcrafter.data.model.Task;
import com.semicolon.africa.jobcrafter.data.repository.TaskRepository;
import com.semicolon.africa.jobcrafter.dto.request.AddTaskRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateTaskRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddTaskResponse;
import com.semicolon.africa.jobcrafter.dto.response.DeleteTaskResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateTaskResponse;
import com.semicolon.africa.jobcrafter.exception.TaskIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskServices{

    @Autowired
    private  TaskRepository taskRepository;


    @Override
    public AddTaskResponse createTask(AddTaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDeadLine());
        task.setDateCreated(request.getDateCreated());
        taskRepository.save(task);
        AddTaskResponse response = new AddTaskResponse();
        response.setTaskId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setDeadLine(task.getDueDate());
        response.setDateCreated(LocalDateTime.now());
        response.setMessage("Task created successfully");
        return response;
    }

    @Override
    public UpdateTaskResponse updatedTask(UpdateTaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDeadLine());
        task.setDateUpdated(request.getDateUpdated());
        taskRepository.save(task);
        UpdateTaskResponse response = new UpdateTaskResponse();
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setDeadLine(request.getDeadLine());
        response.setDateUpdated(task.getDateUpdated());
        response.setMessage("Task updated successfully");
        return response;
    }
    @Override
    public DeleteTaskResponse deleteTask(String id) {
        Task task = findTasksById(id);
        taskRepository.delete(task);
        DeleteTaskResponse response = new DeleteTaskResponse();
        response.setMessage("Task deleted");
        return response;
    }
    private Task findTasksById(String id) {
        return taskRepository.findById(id).
                orElseThrow(()-> new TaskIdNotFoundException("Id Not Found"));
    }
    @Override
    public List<Task> tasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findTasksByTitle(String title) {
        return taskRepository.findTaskByTitle(title);
    }

    @Override
    public List<Task> findTaskByDescription(String description) {
        return taskRepository.findTaskByDescription(description);
    }

}
