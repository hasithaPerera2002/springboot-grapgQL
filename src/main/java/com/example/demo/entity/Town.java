package com.example.demo.entity;



import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Town {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID townId;


    private String townName;


    private String description;


    @OneToMany(mappedBy = "town", cascade = CascadeType.ALL)
    private List<Photo> photos = new ArrayList<>();

    /*public Town() {

    }
    public Town(int townId, String townName, String description, List<Photo> photos) {
        this.townId = townId;
        this.townName = townName;
        this.description = description;
        this.photos = photos;
    }*/
   /* public int getTownId() {
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
    public List<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }*/

}
