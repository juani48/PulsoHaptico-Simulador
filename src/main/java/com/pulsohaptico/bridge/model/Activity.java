package com.pulsohaptico.bridge.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Activity {

    private LocalDateTime starts;
    private LocalDateTime ends;
    private Double wear; // desgaste
    private Boolean canPostponed; // desplazable
    private Boolean hasWarning;
}
