package com.example.demo.service;


import com.example.demo.dto.PhotoDTO;
import com.example.demo.entity.Photo;
import com.example.demo.entity.Town;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public interface PhotoService {

       List<PhotoDTO> photosByTownId (String town);
       PhotoDTO save (PhotoDTO photo);

       PhotoDTO update (PhotoDTO photo);


       PhotoDTO findById (String id);
       boolean delete (String id);

       List<PhotoDTO> getAll();


}
