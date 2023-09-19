package com.example.demo.api;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.TownDTO;
import com.example.demo.service.ActivityService;
import com.example.demo.service.TownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class ActivityController {

    private final ActivityService activityService;

    private final TownService townService;

    ActivityController(ActivityService activityService, TownService townService) {
        this.activityService = activityService;
        this.townService = townService;
    }
    @MutationMapping
    public ActivityDTO addActivity(@Argument ActivityDTO input,@Argument UUID townId) {
        log.info("town id is {}",townId);
        TownDTO town = townService.getTown(townId);
        System.out.println(input.toString());
        input.setTownDTO(town);
        log.info("activity saved {}",input);
        return activityService.addActivity(input);
    }
    @MutationMapping
    public ActivityDTO updateActivity(@Argument ActivityDTO activityDTO) {
        return activityService.updateActivity(activityDTO);
    }
    @MutationMapping
    public void deleteActivity(@Argument UUID id) {
        activityService.deleteActivity(id);
    }
    @QueryMapping
    public ActivityDTO getActivityById(@Argument UUID id) {
        return activityService.getActivityById(id);
    }
    @QueryMapping
    public Flux<ActivityDTO> activities() {
        return Flux.fromIterable(activityService.getAllActivities());
    }
}
