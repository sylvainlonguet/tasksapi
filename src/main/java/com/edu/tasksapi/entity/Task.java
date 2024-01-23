package com.edu.tasksapi.entity;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idtask;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assignee", nullable = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private User assignee;

    private Date duedate;

    public long getIdtask() {
        return idtask;
    }

    public void setIdtask(long idtask) {
        this.idtask = idtask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date dueDate) {
        this.duedate = dueDate;
    }

}
