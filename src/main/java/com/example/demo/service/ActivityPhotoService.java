package com.example.demo.service;

import com.example.demo.dto.ActivityPhotosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface ActivityPhotoService  {
    ActivityPhotosDTO addPhoto(ActivityPhotosDTO activityPhotosDTO);

    ActivityPhotosDTO updatePhoto(ActivityPhotosDTO activityPhotosDTO);

    boolean deletePhoto(UUID id);

    ActivityPhotosDTO getPhotoById(UUID id);


}
