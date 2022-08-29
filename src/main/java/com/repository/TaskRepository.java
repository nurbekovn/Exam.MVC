package com.repository;

import com.model.Task;

import java.util.List;

public interface TaskRepository {

    void saveTask(Task task, Long id);

    void updateTask(Long id, Task task );

    void deleteTask(Long id);

    List<Task> getTasks(Long id);

    Task getTaskById(Long id);

}
