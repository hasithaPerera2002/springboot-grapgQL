package com.example.demo.repo;

import com.example.demo.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepo extends JpaRepository<Activity, UUID> {
}
