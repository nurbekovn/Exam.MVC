package com.serviceImp;

import com.model.Task;
import com.repository.TaskRepository;
import com.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public void saveTask(Task task, Long id) {
        taskRepository.saveTask(task,id );
    }

    @Override
    public void updateTask(Long id, Task task) {
        taskRepository.updateTask(id, task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }

    @Override
    public List<Task> getTasks(Long id) {
        return taskRepository.getTasks(id);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }
}

