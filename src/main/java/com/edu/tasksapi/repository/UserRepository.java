package com.edu.tasksapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edu.tasksapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByIduser(long iduser);

    List<User> findAll();
}
