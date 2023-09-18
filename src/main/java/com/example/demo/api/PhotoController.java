package com.example.demo.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.dto.PhotoDTO;

import com.example.demo.dto.TownDTO;
import com.example.demo.service.PhotoService;
import com.example.demo.service.TownService;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class PhotoController {

    private final PhotoService photoService;

    private final TownService townService;

    @Autowired
    public PhotoController(PhotoService photoService, TownService townService){
        this.photoService = photoService;
        this.townService = townService;
    }

    @QueryMapping
    public Flux<PhotoDTO>photos(){
        List<PhotoDTO> all = photoService.getAll();
        return Flux.fromIterable(all);
    }
    @MutationMapping

    public Mono<PhotoDTO> addPhoto(@Argument PhotoDTO input,@Argument UUID townId){
       log.info("town id is {}",townId);
        TownDTO town = townService.getTown(townId);
        input.setTown(town);
        PhotoDTO save = photoService.save(input);
        log.info("photo saved {}",save);
        return Mono.just(save
);
    }

    public Mono<PhotoDTO> updatePhoto(@Argument PhotoDTO input){
        return Mono.just(photoService.update(input));
    }

    @MutationMapping
    public boolean deletePhoto(@Argument String id){
        return photoService.delete(id);
    }
    @QueryMapping
    public Flux<PhotoDTO> photosByTownId(@Argument String town){
        List<PhotoDTO> photoDTOS = photoService.photosByTownId(UUID.fromString(town));
        return Flux.fromIterable(photoDTOS);
    }
    @QueryMapping
    public Mono<PhotoDTO> photoById(@Argument String id){
        return Mono.just(photoService.findById(id));
    }
}
