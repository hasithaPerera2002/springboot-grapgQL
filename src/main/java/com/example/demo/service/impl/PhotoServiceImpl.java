package com.example.demo.service.impl;


import com.example.demo.dto.PhotoDTO;
import com.example.demo.entity.Photo;
import com.example.demo.repo.PhotoRepo;
import com.example.demo.service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService {

    private final ModelMapper modelMapper;

    private final PhotoRepo photoRepo;

    @Autowired
    public PhotoServiceImpl(ModelMapper modelMapper, PhotoRepo photoRepo) {
        this.modelMapper = modelMapper;
        this.photoRepo = photoRepo;

    }

    @Override
    public List<PhotoDTO> photosByTownId(UUID town) {
        return photoRepo.findAllByTownTownId(town).stream().map(photo -> modelMapper.map(photo, PhotoDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    public PhotoDTO save(PhotoDTO photo) {
        Photo save = photoRepo.save(modelMapper.map(photo, Photo.class));
        return modelMapper.map(save, PhotoDTO.class);
    }

    @Override
    public PhotoDTO update(PhotoDTO photo) {
        if (photoRepo.existsById(photo.getPhotoId())) {
            Photo map = modelMapper.map(photo, Photo.class);
            return modelMapper.map(photoRepo.save(map), PhotoDTO.class);

        } else {
            throw new RuntimeException("id not found");
        }

    }

    @Override
    public PhotoDTO findById(String id) {
        return modelMapper.map(photoRepo.findByPhotoId(UUID.fromString(id)), PhotoDTO.class);
    }

    @Override
    public boolean delete(String id) {
        try {
            photoRepo.deleteById(UUID.fromString(id));
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PhotoDTO> getAll() {
        return photoRepo.findAll().stream().map(photo -> modelMapper.map(photo, PhotoDTO.class)).
                collect(Collectors.toList());
    }
}
