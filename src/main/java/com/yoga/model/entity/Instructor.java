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
@Table(name = "instructor_info")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID instructorId;
    private String instructorName;
    private String email;
    private String qualification;
    private String phone;

}
