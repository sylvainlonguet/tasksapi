package com.edu.tasksapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.tasksapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIduser(long iduser);

    List<User> findAll();

}
