package com.yoga.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID studioID;
    private String studioName;
    @Embedded
    private Address address;

}
