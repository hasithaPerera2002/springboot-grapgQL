package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.build.ToStringPlugin;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {
    private UUID activityId;

    private String activityName;

    private String activityDescription;

    @ToString.Exclude
    TownDTO townDTO;

    private String contactNo;

    private String address;

    @ToString.Exclude
    List<ActivityPhotosDTO> activityPhotos;
}
