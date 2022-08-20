package com.repository;

import com.model.Task;

import java.util.List;

public interface TaskRepository {

    void saveTask(Task task);

    void updateTask( Task task);

    void deleteTask(Long id);

    List<Task> getTasks();

    Task getTaskById(Long id);

}
