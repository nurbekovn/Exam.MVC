package com.service;

import com.model.Task;

import java.util.List;

public interface TaskService {

    void saveTask(Task task);

    void updateTask( Task task);

    void deleteTask(Long id);

    List<Task> getTasks();

    Task getTaskById(Long id);
}
