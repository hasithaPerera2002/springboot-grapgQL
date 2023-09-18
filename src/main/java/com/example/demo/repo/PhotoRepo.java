package com.example.demo.repo;

import com.example.demo.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PhotoRepo extends JpaRepository<Photo,UUID> {




    Optional<Photo> findByPhotoId(UUID id);

    List<Photo> findAllByTownTownId(UUID town_townId);
}
