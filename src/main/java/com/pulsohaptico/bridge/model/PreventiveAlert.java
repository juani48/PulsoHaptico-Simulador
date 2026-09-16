package com.pulsohaptico.bridge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PreventiveAlert {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @OneToOne(mappedBy = "preventiveAlert")
    private Deregulatory deregulatory;

    public PreventiveAlert(String message) {
        this.message = message;
    }
}
