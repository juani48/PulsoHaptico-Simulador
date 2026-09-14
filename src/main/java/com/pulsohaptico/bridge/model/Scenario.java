package com.pulsohaptico.bridge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Scenario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @OneToMany
    @JoinColumn
    private Profile profile;

    @Column(nullable = false)
    private Double pulse; // starter pulse

    @Column(nullable = false)
    private Double state; // starter state

    @Column(nullable = false)
    private LocalDateTime moment;

    @ManyToMany
    private List<Activity> activities;
}
