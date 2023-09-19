package com.example.demo.service.impl;

import com.example.demo.dto.ActivityPhotosDTO;
import com.example.demo.entity.ActivityPhotos;
import com.example.demo.repo.ActivityPhotoRepo;
import com.example.demo.service.ActivityPhotoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public  class ActivityPhotoServiceImpl implements ActivityPhotoService {
    private final ActivityPhotoRepo activityPhotoRepo;

    private final ModelMapper modelMapper;

    ActivityPhotoServiceImpl(ActivityPhotoRepo activityPhotoRepo, ModelMapper modelMapper) {
        this.activityPhotoRepo = activityPhotoRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public ActivityPhotosDTO addPhoto(ActivityPhotosDTO input) {
        ActivityPhotos save = activityPhotoRepo.save(modelMapper.map(input, ActivityPhotos.class));
        return modelMapper.map(save, ActivityPhotosDTO.class);
    }

    @Override
    public ActivityPhotosDTO updatePhoto(ActivityPhotosDTO activityPhotosDTO) {
        try{
            activityPhotoRepo.findById(activityPhotosDTO.getActivityPhotoId()).ifPresent(activityPhotos -> {
                activityPhotos.setImage(activityPhotosDTO.getImage());
                activityPhotos.setCaption(activityPhotosDTO.getCaption());
                activityPhotoRepo.save(activityPhotos);
            });
            return activityPhotosDTO;
        }catch (Exception e){
            log.error("Error while updating activity photo", e);
            throw new RuntimeException("Error while updating activity photo");
        }
    }

    @Override
    public boolean deletePhoto(UUID id) {
        try {
            activityPhotoRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Error while deleting activity photo", e);
            return false;


        }


    }

    @Override
    public ActivityPhotosDTO getPhotoById(UUID id) {
        return modelMapper.map(activityPhotoRepo.findById(id).get(), ActivityPhotosDTO.class);
    }
}
