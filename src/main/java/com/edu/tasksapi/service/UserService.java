package com.edu.tasksapi.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.tasksapi.aop.LogExecutionTime;
import com.edu.tasksapi.entity.User;
import com.edu.tasksapi.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Value("${custom.random.limit:4}")
    private int limit;

    @LogExecutionTime
    public User getRandomUser() {
        int random = new Random().nextInt(limit) + 1;
        User user = repo.findByIduser(random).block(); // orElseThrow(() -> new RuntimeException("ID " + random + "
                                                       // inexistant!"));

        return user;
    }

    @PostConstruct
    public void onJustConstructed() {
        System.out.println();

        System.out.println(" ------- Je viens d'être instancié !!");
        System.out.println();

    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println();

        System.out.println(" ------- Je vais être detruit !!");
        System.out.println();

    }

}
