package com.edu.tasksapi.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.tasksapi.entity.User;
import com.edu.tasksapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User getRandomUser() {
        int random = new Random().nextInt(4) + 1;
        return repo.findByIduser(random);

    }

}
