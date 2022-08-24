package com.service;

import com.model.Video;

import java.util.List;

public interface VideoService {
    void saveVideo(Video newVideo);
    void updateVideo(Video newVideo);

    void deleteVideoById(Long id);

    List<Video> getVideos();

    Video getVideoById(Long id);
}
