package com.repository;

import com.model.Video;

import java.util.List;

public interface VideoRepository {

    void saveVideo(Video newVideo,Long lessonId);
    void updateVideo(Long id,Video newVideo);

    void deleteVideoById(Long id);

    List<Video> getVideos(Long id);

    Video getVideoById(Long id);
}
