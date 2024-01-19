package com.edu.tasksapi.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.edu.tasksapi.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    Mono<User> findByIduser(long iduser);

    Flux<User> findAll();

}
