package com.serviceImp;

import com.model.Video;
import com.repository.VideoRepository;
import com.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public void saveVideo(Video newVideo, Long lessonId) {
        videoRepository.saveVideo(newVideo,lessonId );
    }

    @Override
    public void updateVideo(Long id, Video newVideo) {
        videoRepository.updateVideo(id, newVideo);
    }

    @Override
    public void deleteVideoById(Long id) {
        videoRepository.deleteVideoById(id);
    }

    @Override
    public List<Video> getVideos(Long id) {
        return videoRepository.getVideos(id);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoRepository.getVideoById(id);
    }
}
