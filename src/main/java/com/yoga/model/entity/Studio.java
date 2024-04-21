package com.yoga.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "studio")
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID studioID;
    @Column(name = "StudioName",nullable = false)
    private String studioName;
    @Embedded
    private Address address;
    @OneToMany(mappedBy ="associatedStudio",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<YogaClasses> yogaClasses;

}
