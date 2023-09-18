package com.example.demo.repo;

import com.example.demo.entity.ActivityPhotos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityPhotoRepo extends JpaRepository<ActivityPhotos, UUID> {
}
