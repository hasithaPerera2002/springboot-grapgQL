package com.example.demo.api;

import com.example.demo.dto.PhotoDTO;
import com.example.demo.dto.TownDTO;
import com.example.demo.service.PhotoService;
import com.example.demo.service.TownService;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;

import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Controller
@Slf4j
public class TownController  {

    private final TownService townService;
    private final PhotoService photoService;

    @Autowired
    public TownController(TownService townService, PhotoService photoService) {
        this.photoService = photoService;

        this.townService = townService;
    }

    @QueryMapping
    public Flux<TownDTO> towns() {
        List<TownDTO> all = townService.getAll();
        log.info("Fetching all towns{}",all);
        System.out.println(all);
        return Flux.fromIterable(all);
    }

    @MutationMapping
    public Mono<TownDTO> addTown(@Argument TownDTO input) {
        return Mono.just(townService.save(input));
    }

    @MutationMapping
    public Mono<TownDTO> updateTown(@Argument TownDTO input) {
        return Mono.just(townService.update(input));
    }

    @MutationMapping
    public boolean deleteTown(@Argument String id) {
        return townService.delete(id);
    }

    @QueryMapping
    public Mono<TownDTO> getTownById(@Argument UUID id) {
        System.out.println(id);
        return Mono.just(townService.getTown(id));
    }
    @BatchMapping
    Map<TownDTO,List<PhotoDTO>>photos(List<TownDTO> towns){
        log.info("Fetching photos for towns");
        System.out.println("towns---------------------------------");
        return towns.stream().collect(Collectors.toMap(town -> town,
                town -> photoService.photosByTownId(town.getTownId())));
    }

}
