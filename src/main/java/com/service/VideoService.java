package com.service;

import com.model.Video;
import com.repository.VideoRepository;
import com.repositoryImpl.VideoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VideoService implements VideoRepository {

    private final VideoRepositoryImpl videoRepository;

    @Autowired
    public VideoService(VideoRepositoryImpl videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public void saveVideo(Video newVideo) {
        videoRepository.saveVideo(newVideo);
    }

    @Override
    public void updateVideo(Video newVideo) {
        videoRepository.updateVideo(newVideo);
    }

    @Override
    public void deleteVideoById(Long id) {
        videoRepository.deleteVideoById(id);
    }

    @Override
    public List<Video> getVideos() {
        return videoRepository.getVideos();
    }

    @Override
    public Video getVideoById(Long id) {
        return videoRepository.getVideoById(id);
    }
}
