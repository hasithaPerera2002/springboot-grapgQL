package com.example.demo.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.dto.PhotoDTO;

import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService){
        this.photoService = photoService;
    }

    @BatchMapping(typeName = "Photo")
    public Flux<PhotoDTO>photos(){
        List<PhotoDTO> all = photoService.getAll();
        return Flux.fromIterable(all);
    }
    @MutationMapping
    public Mono<PhotoDTO> addPhoto(@Argument PhotoDTO input){
        return Mono.just(photoService.save(input));
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
        List<PhotoDTO> photoDTOS = photoService.photosByTownId(town);
        return Flux.fromIterable(photoDTOS);
    }
    @QueryMapping
    public Mono<PhotoDTO> photoById(@Argument String id){
        return Mono.just(photoService.findById(id));
    }
}
