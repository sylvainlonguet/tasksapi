package com.edu.tasksapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.edu.tasksapi.entity.User;
import com.edu.tasksapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("users")

public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {

        return userRepository.findByIduser(id);

    }
}
