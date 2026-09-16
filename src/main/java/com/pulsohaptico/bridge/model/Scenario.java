package com.pulsohaptico.bridge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Scenario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, name = "base_pulse")
    private Double basePulse;

    @Column(nullable = false, name = "base_state")
    private Double baseState;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Scenario(String description, Double basePulse, Double baseState, Profile profile) {
        this.description = description;
        this.basePulse = basePulse;
        this.baseState = baseState;
        this.profile = profile;
    }
}
