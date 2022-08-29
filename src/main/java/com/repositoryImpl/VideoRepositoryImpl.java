package com.repositoryImpl;

import com.model.Lesson;
import com.model.Video;
import com.repository.VideoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VideoRepositoryImpl implements VideoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveVideo(Video newVideo, Long lessonId) {
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        lesson.addVideo(newVideo);
        newVideo.setLesson(lesson);
        entityManager.merge(newVideo);
    }

    @Override
    public void updateVideo(Long id, Video newVideo) {
        Video video = entityManager.find(Video.class, id);
        video.setVideoName(newVideo.getVideoName());
        video.setLink(newVideo.getLink());
        entityManager.merge(video);
    }

    @Override
    public void deleteVideoById(Long id) {
        Video video = entityManager.find(Video.class, id);
        video.setLesson(null);
        entityManager.remove(video);

    }

    @Override
    public List<Video> getVideos(Long id) {
        return entityManager.createQuery("select v from Video v " +
                        "where v.lesson.id = : id",
                Video.class).setParameter("id", id).getResultList();
    }

    @Override
    public Video getVideoById(Long id) {
        return entityManager.find(Video.class, id);
    }
}
