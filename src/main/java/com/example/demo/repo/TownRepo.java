package com.example.demo.repo;

import com.example.demo.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TownRepo extends JpaRepository<Town, UUID> {
    @Query(value = "SELECT * FROM Town ORDER BY RANDOM() LIMIT 4", nativeQuery = true)
    List<Town> findFourRandomTowns();

    Town findTownByTownId(UUID townId);

    List<Town> findAll();
}
