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
public class Activity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime starts;

    @Column(nullable = false)
    private LocalDateTime ends;

    @Column(nullable = false)
    private Double wear; // desgaste

    @Column(nullable = false)
    private Boolean canPostponed; // desplazable

    @Column(nullable = false)
    private Boolean hasWarning;

    @ManyToMany(mappedBy = "activities")
    private List<Profile> profiles;

    public Activity(LocalDateTime starts, LocalDateTime ends, Double wear, Boolean canPostponed, Boolean hasWarning) {
        this.starts = starts;
        this.ends = ends;
        this.wear = wear;
        this.canPostponed = canPostponed;
        this.hasWarning = hasWarning;
    }
}
