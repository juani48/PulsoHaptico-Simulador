package com.pulsohaptico.bridge.builder.dataset.strategy;

import com.pulsohaptico.bridge.model.dataset.Dataset;

public interface SensingStrategy {
    void setLastSensing(Dataset dataset);
}
