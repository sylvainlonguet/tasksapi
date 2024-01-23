package com.edu.tasksapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.edu.tasksapi.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByIduser(long iduser);

    List<User> findAll();

    Optional<User> findByEmail(String email);

}
