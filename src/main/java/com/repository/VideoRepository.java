package com.repository;

import com.model.Video;

import java.util.List;

public interface VideoRepository {

    void saveVideo(Video newVideo);
    void updateVideo(Video newVideo);

    void deleteVideoById(Long id);

    List<Video> getVideos();

    Video getVideoById(Long id);
}
