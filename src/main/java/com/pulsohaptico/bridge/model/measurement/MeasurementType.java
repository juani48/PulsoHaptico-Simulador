package com.pulsohaptico.bridge.model.measurement;

public enum MeasurementType {
    DEREGULATED("Sin regulación", "Medición con alta presión arterial"),
    REGULATED("Regulado", "Medición con baja presión arterial");
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
