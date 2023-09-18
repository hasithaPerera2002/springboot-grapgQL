package com.example.demo.dto;

import lombok.*;
import net.bytebuddy.build.ToStringPlugin;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TownDTO {

    private UUID townId;

    private String townName;

    private String description;



    @ToString.Exclude
    private List<PhotoDTO> photos;

  /*  public TownDTO() {

    }
    public TownDTO(int townId, String townName, String description, List<PhotoDTO> photos) {
        this.townId = townId;
        this.townName = townName;
        this.description = description;
        this.photos = photos;
    }

    public int getTownId() {
        return townId;
    }
    public void setTownId(int townId) {
        this.townId = townId;
    }
    public String getTownName() {
        return townName;
    }
    public void setTownName(String townName) {
        this.townName = townName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<PhotoDTO> getPhotos() {
        return photos;
    }
    public void setPhotos(List<PhotoDTO> photos) {
        this.photos = photos;
    }*/
}
