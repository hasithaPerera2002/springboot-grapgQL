package com.example.demo.service;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.entity.Activity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ActivityService {
    List<ActivityDTO>getAllActivities();

    ActivityDTO getActivityById(UUID id);

    ActivityDTO addActivity(ActivityDTO activityDTO);

    ActivityDTO updateActivity(ActivityDTO activityDTO);

    void deleteActivity(UUID id);
}
