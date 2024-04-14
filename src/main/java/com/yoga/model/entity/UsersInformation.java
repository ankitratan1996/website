package com.yoga.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Register_User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsersInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String surname;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    @Embedded
    private Address Address;
}
