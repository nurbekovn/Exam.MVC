package com.serviceImp;

import com.model.Video;
import com.repository.VideoRepository;
import com.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository) {
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
