package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityPhotosDTO {
    private UUID activityPhotoId;

    private String image;

    private String caption;

    private ActivityDTO activityDTO;
}
