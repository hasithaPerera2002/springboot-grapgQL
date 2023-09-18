package com.example.demo.api;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class ActivityController {

    private final ActivityService activityService;

    ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }
    @MutationMapping
    public ActivityDTO addActivity(@Argument ActivityDTO activityDTO) {
        return activityService.addActivity(activityDTO);
    }
    @MutationMapping
    public ActivityDTO updateActivity(@Argument ActivityDTO activityDTO) {
        return activityService.updateActivity(activityDTO);
    }
    @MutationMapping
    public void deleteActivity(@Argument String id) {
        activityService.deleteActivity(UUID.fromString(id));
    }
    @QueryMapping
    public ActivityDTO getActivityById(@Argument String id) {
        return activityService.getActivityById(UUID.fromString(id));
    }
    @BatchMapping(typeName = "Activity")
    public List<ActivityDTO> getAllActivities() {
        return activityService.getAllActivities();
    }
}
