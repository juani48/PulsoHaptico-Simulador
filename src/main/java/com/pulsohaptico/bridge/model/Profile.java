package com.pulsohaptico.bridge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "profile_deregulations",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "deregulation_id")
    )
    private List<Deregulatory> deregulations;

    @ManyToMany
    @JoinTable(
            name = "profile_regulation_strategies",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "regulation_strategy_id")
    )
    private List<RegulationStrategy> regulationStrategies;

    @ManyToMany
    @JoinTable(
            name = "profile_activity",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> activities;

    @OneToMany(mappedBy = "profile")
    private List<Scenario> scenario;

    public Profile(String name, String description) {
        this.name = name;
        this.description = description;
        this.deregulations = new ArrayList<>();
        this.regulationStrategies = new ArrayList<>();
        this.activities = new ArrayList<>();
        this.scenario = new ArrayList<>();
    }
}