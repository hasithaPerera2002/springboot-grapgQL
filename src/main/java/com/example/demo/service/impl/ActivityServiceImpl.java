package com.example.demo.service.impl;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.entity.Activity;
import com.example.demo.repo.ActivityRepo;
import com.example.demo.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepo activityRepo;
    private final ModelMapper modelMapper;


    ActivityServiceImpl(ActivityRepo activityRepo, ModelMapper modelMapper) {
        this.activityRepo = activityRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<ActivityDTO> getAllActivities() {
        return activityRepo.findAll().stream().map(activity -> modelMapper.map(activity, ActivityDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ActivityDTO getActivityById(UUID id) {
        return modelMapper.map(activityRepo.getReferenceById(id), ActivityDTO.class);
    }

    @Override
    public ActivityDTO addActivity(ActivityDTO activityDTO) {
        Activity save = activityRepo.save(modelMapper.map(activityDTO, Activity.class));
        return modelMapper.map(save, ActivityDTO.class);
    }

    @Override
    public ActivityDTO updateActivity(ActivityDTO activityDTO) {
        try {
            activityRepo.findById(activityDTO.getActivityId()).ifPresent(activity -> {
                activity.setActivityName(activityDTO.getActivityName());
                activity.setActivityDescription(activityDTO.getActivityDescription());
                activity.setAddress(activityDTO.getAddress());
                activity.setContactNo(activityDTO.getContactNo());
                activityRepo.save(activity);

            });
            return activityDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteActivity(UUID id) {
        activityRepo.deleteById(id);
    }
}
