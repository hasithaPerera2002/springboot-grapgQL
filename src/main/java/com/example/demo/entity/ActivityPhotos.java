package com.example.demo.entity;

import com.example.demo.dto.ActivityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActivityPhotos {

    @Id
    @GeneratedValue(generator = "uuid")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID activityPhotoId;

    @Lob
    private String image;



    private String caption;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "activityId")
    private Activity activity;
}
