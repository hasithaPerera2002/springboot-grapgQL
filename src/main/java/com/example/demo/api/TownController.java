package com.example.demo.api;

import com.example.demo.dto.TownDTO;
import com.example.demo.service.TownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;

import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;


@Controller
@Slf4j
public class TownController  {

    private final TownService townService;

    @Autowired
    public TownController(TownService townService) {
        this.townService = townService;
    }

    @BatchMapping(typeName = "Town")
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
    public Mono<TownDTO> getTownById(@Argument String id) {
        System.out.println(id);
        return Mono.just(townService.getTown(UUID.fromString(id)));
    }

}
