package com.example.demo.service;


import com.example.demo.dto.PhotoDTO;
import com.example.demo.entity.Photo;
import com.example.demo.entity.Town;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;


public interface PhotoService {

       List<PhotoDTO> photosByTownId (UUID town);
       PhotoDTO save (PhotoDTO photo);

       PhotoDTO update (PhotoDTO photo);


       PhotoDTO findById (String id);
       boolean delete (String id);

       List<PhotoDTO> getAll();


}
