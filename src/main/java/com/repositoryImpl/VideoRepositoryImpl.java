package com.repositoryImpl;

import com.model.Video;
import com.repository.VideoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VideoRepositoryImpl implements VideoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveVideo(Video newVideo) {
        entityManager.persist(newVideo);
    }

    @Override
    public void updateVideo(Video newVideo) {
        entityManager.merge(Video.class);
    }

    @Override
    public void deleteVideoById(Long id) {
        entityManager.remove(entityManager.find(Video.class,id));
    }

    @Override
    public List<Video> getVideos() {
        return entityManager.createQuery("select v from Video v",
                Video.class).getResultList();
    }

    @Override
    public Video getVideoById(Long id) {
        return entityManager.find(Video.class,id);
    }
}
