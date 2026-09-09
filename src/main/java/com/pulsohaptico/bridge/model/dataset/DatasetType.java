package com.pulsohaptico.bridge.model.dataset;

public enum DatasetType {
    HSNEAS("Estado alto, fuera de evento y sensado antiguo",
            "Estado alto; no hay un evento activo y la última medición es antigua."),
    LSNEAS("Estado bajo, fuera de evento y sensado antiguo",
            "Estado bajo; no hay un evento activo y la última medición es antigua."),
    HSOEAS("Estado alto, en evento y sensado antiguo",
            "Estado alto; hay un evento activo y la última medición es antigua."),
    LSOEAS("Estado bajo, en evento y sensado antiguo",
            "Estado bajo; hay un evento activo y la última medición es antigua."),
    HSNERS("Estado alto, fuera de evento y sensado reciente",
            "Estado alto; no hay un evento activo y la última medición es reciente."),
    LSNERS("Estado bajo, fuera de evento y sensado reciente",
            "Estado bajo; no hay un evento activo y la última medición es reciente.");
    private final String name;
    private final String description;

    DatasetType(String name, String description) {
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
