package com.example.demo.api;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.ActivityPhotosDTO;
import com.example.demo.entity.ActivityPhotos;
import com.example.demo.service.ActivityPhotoService;
import com.example.demo.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
public class ActivityPhotoController {
    private final ActivityPhotoService activityPhotoService;
    private final ActivityService activityService;


    @Autowired
    ActivityPhotoController(ActivityPhotoService activityPhotoService, ActivityService activityService) {
        this.activityService = activityService;
        this.activityPhotoService = activityPhotoService;
    }

    @MutationMapping
    public Mono<ActivityPhotosDTO> addActivityPhoto(@Argument ActivityPhotosDTO input,@Argument UUID activityId) {
        ActivityDTO activityById = activityService.getActivityById(activityId);
        input.setActivityDTO(activityById);
        return Mono.just(activityPhotoService.addPhoto(input));
    }
    @MutationMapping
    public Mono<ActivityPhotosDTO> updateActivityPhoto(@Argument ActivityPhotosDTO input) {
        return Mono.just(activityPhotoService.updatePhoto(input));
    }
    @MutationMapping
    public boolean deleteActivityPhoto(@Argument String id) {
      return   activityPhotoService.deletePhoto(UUID.fromString(id));
    }

    @QueryMapping
    public Mono<ActivityPhotosDTO> getActivityPhotoById(@Argument String id) {
        return Mono.just(activityPhotoService.getPhotoById(UUID.fromString(id)));
    }


}
