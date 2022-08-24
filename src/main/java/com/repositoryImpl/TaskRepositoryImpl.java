package com.repositoryImpl;

import com.model.Task;
import com.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskRepositoryImpl implements TaskRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveTask(Task task) {
        entityManager.persist(task);
    }

    @Override
    public void updateTask(Task task) {
        entityManager.merge(Task.class);
    }

    @Override
    public void deleteTask(Long id) {
        entityManager.remove(entityManager.find(Task.class,id));
    }

    @Override
    public List<Task> getTasks() {
        return entityManager.createQuery("select t from Task t",
                Task.class).getResultList();
    }

    @Override
    public Task getTaskById(Long id) {
        return entityManager.find(Task.class,id);
    }
}
