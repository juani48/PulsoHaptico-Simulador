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
public class RegulationStrategy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "regulationStrategies")
    private List<Profile> profiles;

    public RegulationStrategy(String description) {
        this.description = description;
        this.profiles = new ArrayList<>();
    }
}
