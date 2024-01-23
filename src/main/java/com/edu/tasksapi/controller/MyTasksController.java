package com.edu.tasksapi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.tasksapi.entity.Task;
import com.edu.tasksapi.repository.TasksRepository;

@RestController
@RequestMapping("/tasks")
public class MyTasksController {

    @Autowired
    private TasksRepository repo;

    @GetMapping
    public List<Task> getMyTasks(Principal principal) {

        return repo.findByAssigneeEmail(principal.getName());

    }
}
