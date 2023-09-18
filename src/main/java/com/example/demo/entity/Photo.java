package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
        @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
        private UUID photoId;

        @Lob
        private String image;


        private String destination;


        private String description;


        private String caption;

        @ManyToOne
        @JoinColumn(name = "townId")
        private Town town;

    }
