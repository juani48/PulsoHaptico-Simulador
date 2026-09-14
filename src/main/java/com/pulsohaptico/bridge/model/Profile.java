package com.pulsohaptico.bridge.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double state;

    @ManyToMany
    @JoinTable(
        name = "profile_deregulations",
        joinColumns = @JoinColumn(name = "profile_id"),
        inverseJoinColumns = @JoinColumn(name = "deregulation_id")
    )
    private List<Deregulatory> deregulations;

    @OneToOne
    @JoinColumn
    private VibrationStrategy vibrationStrategy;

    private List<Activity> activities;
}
