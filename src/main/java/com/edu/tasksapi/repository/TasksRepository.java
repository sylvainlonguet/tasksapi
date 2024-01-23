package com.edu.tasksapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.tasksapi.entity.Task;
import com.edu.tasksapi.entity.User;

@Repository
public interface TasksRepository extends CrudRepository<Task, Long> {

    Optional<Task> findByIdtask(long iduser);

    List<Task> findByAssignee(User user);

    @Query(value = "SELECT t.* FROM tasks t , user u WHERE u.email = ?1 and u.iduser = t.assignee", nativeQuery = true)
    List<Task> findByAssigneeEmail(String name);

}
