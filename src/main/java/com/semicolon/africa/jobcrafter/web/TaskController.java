package com.semicolon.africa.jobcrafter.web;

import com.semicolon.africa.jobcrafter.data.model.Task;
import com.semicolon.africa.jobcrafter.dto.request.AddTaskRequest;
import com.semicolon.africa.jobcrafter.dto.request.UpdateTaskRequest;
import com.semicolon.africa.jobcrafter.dto.response.AddTaskResponse;
import com.semicolon.africa.jobcrafter.dto.response.TaskApiResponse;
import com.semicolon.africa.jobcrafter.dto.response.UpdateTaskResponse;
import com.semicolon.africa.jobcrafter.services.TaskServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private TaskServices taskServices;

    @PostMapping("/addTask")
    public ResponseEntity<?> addTask(@RequestBody AddTaskRequest request){
        try{
            AddTaskResponse response = taskServices.createTask(request);
            return new ResponseEntity<>(new TaskApiResponse(true, response),
                    HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new TaskApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("/updatedTask")
    public ResponseEntity<?> updatedTask(@RequestBody UpdateTaskRequest request){
        try {
            UpdateTaskResponse response = taskServices.updatedTask(request);
            return new ResponseEntity<>(new TaskApiResponse(true, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new TaskApiResponse(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> displayAllTask(){
        try {
            List<Task> findAllTask = taskServices.tasks();
            return new ResponseEntity<>(new TaskApiResponse(true, findAllTask),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new TaskApiResponse(false, exception),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> findTaskByTitle(@PathVariable String title){
        try {
            List<Task> findByTitle =taskServices.findTasksByTitle(title);
            return new ResponseEntity<>(new TaskApiResponse(true, findByTitle),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new TaskApiResponse(false, exception),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{description}")
    public ResponseEntity<?> findTaskByDescription(@PathVariable String description){
        try {
            List<Task> findDescription = taskServices.findTaskByDescription(description);
            return new ResponseEntity<>(new TaskApiResponse(false, findDescription),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new TaskApiResponse(false, exception),
                    HttpStatus.NOT_FOUND);
        }
    }
}
