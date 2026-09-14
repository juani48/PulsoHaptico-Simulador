package com.pulsohaptico.bridge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Deregulatory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double alertThreshold;

    @Column(nullable = false)
    private Double warningThreshold;

    @OneToOne
    @JoinColumn
    private PreliminaryNotice preliminaryNotice;

    @OneToOne
    @JoinColumn
    private Strategy strategy;

}
