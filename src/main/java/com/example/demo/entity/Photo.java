package com.example.demo.entity;


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
    @Getter
    @Setter
    public class Photo {
        @Id
        @GeneratedValue(generator = "uuid")
        @Type(type="org.hibernate.type.UUIDCharType")
        private UUID photoId;

        @Lob
        private String image;


        private String destination;


        private String description;


        private String caption;

        @ManyToOne(cascade = CascadeType.DETACH)
        @JoinColumn(name = "townId")
        private Town town;

    }
