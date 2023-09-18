package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhotoDTO {


    private UUID photoId;

    private String image;


    private String destination;


    private String description;


    private String caption;


    private TownDTO town;
}
