package com.service;

import com.model.Task;
import com.repository.TaskRepository;
import com.repositoryImpl.TaskRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskService  {
    private final TaskRepositoryImpl taskRepository;

    @Autowired
    public TaskService(TaskRepositoryImpl taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void saveTask(Task task) {
        taskRepository.saveTask(task);
    }


    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }


    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }


    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }


    public Task getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }
}

