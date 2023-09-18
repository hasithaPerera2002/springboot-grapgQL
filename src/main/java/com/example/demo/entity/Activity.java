package com.example.demo.entity;

import com.example.demo.dto.ActivityPhotosDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue(generator = "uuid")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID activityId;

    private String activityName;

    private String activityDescription;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "townId")
    private Town town;

    private String contactNo;

    private String address;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "activityPhotoId")
    ActivityPhotos activityPhotos;
}
