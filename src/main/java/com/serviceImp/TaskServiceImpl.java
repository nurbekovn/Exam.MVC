package com.serviceImp;

import com.model.Task;
import com.repository.TaskRepository;
import com.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public void saveTask(Task task) {
        taskRepository.saveTask(task);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }
}

