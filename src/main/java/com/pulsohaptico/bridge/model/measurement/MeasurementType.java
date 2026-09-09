package com.pulsohaptico.bridge.model.measurement;

public enum MeasurementType {
    DEREGULATED("Sin regulación", "Escenario sin regulación"),
    REGULATED("Regulado", "Escenario con regulación");
    private final String name;
    private final String description;

    MeasurementType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
