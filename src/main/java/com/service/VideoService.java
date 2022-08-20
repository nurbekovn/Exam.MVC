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
public class VideoService  {

    private final VideoRepositoryImpl videoRepository;

    @Autowired
    public VideoService(VideoRepositoryImpl videoRepository) {
        this.videoRepository = videoRepository;
    }


    public void saveVideo(Video newVideo) {
        videoRepository.saveVideo(newVideo);
    }


    public void updateVideo(Video newVideo) {
        videoRepository.updateVideo(newVideo);
    }


    public void deleteVideoById(Long id) {
        videoRepository.deleteVideoById(id);
    }


    public List<Video> getVideos() {
        return videoRepository.getVideos();
    }


    public Video getVideoById(Long id) {
        return videoRepository.getVideoById(id);
    }
}
