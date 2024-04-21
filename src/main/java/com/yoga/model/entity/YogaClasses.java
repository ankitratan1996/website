package com.yoga.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Yoga_Class")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class YogaClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID yogaclassId;
    @Column(nullable = false,name = "className")
    private String className;
    @Column(length = 1000)
    private String description;
    @JoinColumn
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Instructor associatedInstructor;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Studio associatedStudio;
    private Integer capacity;

    private LocalDateTime startTime;
    private String level;
    private String category;
    private BigDecimal price;
    @Enumerated(value = EnumType.STRING)
    private ClassStatus status;
    @OneToMany(mappedBy = "associatedYogaClasses",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<UsersInformation> user;
}
