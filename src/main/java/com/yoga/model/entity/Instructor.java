package com.yoga.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "instructor_info")
public class Instructor  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID instructorId;
    @Column(name ="InstructorName",columnDefinition="varchar(20)",nullable = false)
    private String instructorName;
    @Column(name = "Email_Id",columnDefinition = "varchar(20)",nullable = false)
    private String email;
    @Column(name = "Qualification",nullable = false)
    private String qualification;
    @Column(name = "mobile",nullable = false)
    private String phone;
    @OneToMany(mappedBy = "associatedInstructor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<YogaClasses> yogaClasses;

}
