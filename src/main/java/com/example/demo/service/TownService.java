package com.example.demo.service;

import com.example.demo.dto.TownDTO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component

public interface TownService {

    TownDTO getTown(UUID id);



    boolean delete(String id);

    TownDTO update(TownDTO input);

    TownDTO save(TownDTO input);

    List<TownDTO> getAll();
}
